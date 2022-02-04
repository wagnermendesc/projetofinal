import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DaoPadrao<T> {
    
    EntityManagerFactory emf;
    EntityManager em;
    private final Class<T> classe;

    
    public DaoPadrao(Class<T> classe){
       
        emf = Persistence.createEntityManagerFactory("ObrasPU");
        em = emf.createEntityManager();
        this.classe =  classe; 
    }
    
    
   
    public void gravar(T t){
        abrirConexao();
        try { // Tenta fazer as operações abaixo
            em.getTransaction().begin(); //Inicia operação no banco
            em.persist(t); // Insere registro no banco
            em.getTransaction().commit(); // Confirma
        } catch (Exception e){ // Se deu algum problema nas operações
            em.getTransaction().rollback(); // Desfaz o que foi feito
            e.printStackTrace();
        }finally {
            fecharConexao();
        }
    }
    
    public void alterar(T t){
        abrirConexao();
        try{
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            fecharConexao();
        }
    }

    public T remover(int id){
        abrirConexao();
        T object = null;
        try{
            em.getTransaction().begin();
            object = em.find(classe,id );
            em.remove(object);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            fecharConexao();
        }
        return object;
    }

    public List<T> listar(){
        abrirConexao();
        List<T> objects = null;
        try{
            objects = (List<T>) em.createQuery("from " + classe.getName(), this.classe).getResultList();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
           fecharConexao();
        }
        return objects;
    }
    
    public T buscarId(int id){
        abrirConexao();
        T object = null;
         try{
            em.getTransaction().begin();
            object = em.find(classe, id);
            em.getTransaction().commit();

         }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

         }finally {
            fecharConexao();
         }
        return object;
    }

    protected void fecharConexao() {
        em.close();
        emf.close();
    }
    
    protected void abrirConexao(){
        emf = Persistence.createEntityManagerFactory("ObrasPU");
        em = emf.createEntityManager();
    }
    
}

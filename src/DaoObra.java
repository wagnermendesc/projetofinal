
import java.util.List;


public class DaoObra extends DaoPadrao<Obra> {

    public DaoObra() {
       super(Obra.class);
    }
        
    public void insere(Obra obra)  {
        gravar(obra);
    }
    
    public void altera(Obra novaObra, int id) {
        Obra obraAntiga = buscarId(id);
        
        obraAntiga.setNome(novaObra.getNome());
        obraAntiga.setCidade(novaObra.getCidade());
        obraAntiga.setCusto(novaObra.getCusto());
        obraAntiga.setStatus(novaObra.getStatus());
        obraAntiga.setTipo(novaObra.getTipo());
        
        alterar(obraAntiga);
    }
    
    public void exclui(int id) {
        remover(id);
    }
    
    public List<Obra> lista() {
        return super.listar();
    }
    
}

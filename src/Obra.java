import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="obra")
@Table(name="obra")
public class Obra {
    
    @Id
    @GeneratedValue
    private int id;
    
    /*
    * Usa-se "private" para só a classe poder alterar seu atributo
    */
    private String nome;
    private String cidade;
    private float custo;
    
    /**
     * 1 - SAUDE
     * 2 - EDUCACAO
     */
    private int tipo;
    
    /**
     * 1 - NÃO INICIADA
     * 2 - EM ANDAMENTO
     * 3 - FINALIZADA
     * 4 - PARADA
     */
    private int status;

    public Obra() {}
    
    public Obra(String nome, String cidade, float custo, int tipo, int status) {
        this.nome = nome;
        this.cidade = cidade;
        this.custo = custo;
        this.tipo = tipo;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public float getCusto() {
        return custo;
    }


    public void setCusto(float custo) {
        if(custo >= 0) {
            this.custo = custo;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

import java.util.List;
import java.util.Scanner;


public class Sistema {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int operacao;
        DaoObra dao = new DaoObra();
        
        do {
            System.out.println("Informe a operação desejada: ");
            System.out.println("0 - SAIR");
            System.out.println("1 - CADASTRAR OBRA");
            System.out.println("2 - ALTERAR OBRA");
            System.out.println("3 - EXCLUIR OBRA");
            System.out.println("4 - LISTAR OBRAS");

            operacao = input.nextInt();
            
            switch(operacao) {
                case 1: {
                    System.out.println("Nome: ");
                    String nomeCadastro = input.next();
                    
                    System.out.println("Cidade: ");
                    String cidadeCadastro = input.next();
                    
                    System.out.println("Custo: ");
                    float custoCadastro = input.nextFloat();
                    
                    System.out.println("Tipo");
                    System.out.println("1 - SAÚDE");
                    System.out.println("2 - EDUCAÇÃO");
                    int tipoCadastro = input.nextInt();
                    
                    int statusCadastro = 1;
                    
                    Obra obraCadastro = new Obra(nomeCadastro, cidadeCadastro, custoCadastro, tipoCadastro, statusCadastro);
                    
                    dao.insere(obraCadastro);
                    
                    break;
                }
                
                case 2: {
                    System.out.println("Id a ser alterado: ");
                    int idAlteracao = input.nextInt();
                    
                    System.out.println("Novo nome: ");
                    String nomeAlteracao = input.next();
                    
                    System.out.println("Nova cidade: ");
                    String cidadeAlteracao = input.next();
                 
                    System.out.println("Novo custo: ");
                    float custoAlteracao = input.nextFloat();
                    
                    System.out.println("Novo Tipo");
                    System.out.println("1 - SAÚDE");
                    System.out.println("2 - EDUCAÇÃO");
                    int tipoAlteracao = input.nextInt();
                    
                    System.out.println("Novo Status: ");
                    System.out.println("1 - NÃO INICIADA");
                    System.out.println("2 - EM ANDAMENTO");
                    System.out.println("3 - FINALIZADA");
                    System.out.println("4 - PARALIZADA");
                    int statusAlteracao = input.nextInt();
                    
                    Obra obraAlteracao = new Obra(nomeAlteracao, cidadeAlteracao, custoAlteracao, tipoAlteracao, statusAlteracao);
                    
                    dao.altera(obraAlteracao, idAlteracao);
                    
                    break;
                }
                case 3: {
                    System.out.println("Id a ser excluido: ");
                    int idExclusao = input.nextInt();
                    
                    dao.exclui(idExclusao);
                    
                    break;
                }
                case 4: {
                    List<Obra> obras = dao.lista();
                    
                    for(int i = 0; i < obras.size(); i++) {
                        
                        Obra obraListar = obras.get(i);
                        
                        System.out.println("OBRA NUMERO " + obraListar.getId() + ": ");
                        System.out.println("Nome: " + obraListar.getNome());
                        System.out.println("Cidade: " + obraListar.getCidade());
                        System.out.println("Custo: " + obraListar.getCusto());
                        
                        if(obraListar.getTipo() == 1) {
                            System.out.println("Tipo: Saúde");
                        } 
                        if(obraListar.getTipo() == 2) {
                            System.out.println("Tipo: Educação");
                        }
                        
                        System.out.println("Status: " + obraListar.getStatus());
                        
                        System.out.println("-------------------------");
                    }
                    
                    break;
                }
            }
            
        } while(operacao >= 1 && operacao <= 4);
    }
}

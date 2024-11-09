import java.time.LocalDate;

public class Graduacao extends Estudante{
    private String estagioSupervisionado;

    public Graduacao(String cpf, String nome, LocalDate dataNascimento, double cra, String estagioSupervisionado){
        super(cpf, nome, dataNascimento, cra);
        this.estagioSupervisionado = estagioSupervisionado;
    }
    
    @Override
    public void imprimirInformacoes(){
        System.out.println("<< Informações Estudante de Pós Graduação >>");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("CRA: " + getCra());
        System.out.println("Estágio Supervisinado: " + estagioSupervisionado);
    }

}   

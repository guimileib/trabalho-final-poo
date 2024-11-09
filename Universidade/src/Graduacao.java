import java.time.LocalDate;

public class Graduacao extends Estudante{
    private String estagioSupervisionado;

    public Graduacao(String cpf, String nome, LocalDate dataNascimento, double cra, String estagioSupervisionado){
        super(cpf, nome, dataNascimento, cra);
        this.estagioSupervisionado = estagioSupervisionado;
    }
    
    @Override
    public String getDetalhes(){
        return "Estudante Graduação: " + getNome() + ", Estágio Supervisionado" + estagioSupervisionado; 
    }

}   

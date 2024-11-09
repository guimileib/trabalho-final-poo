import java.time.LocalDate;

public class PosGraduacao extends Estudante {
    private String temaPesquisa;

    public PosGraduacao(String cpf, String nome, LocalDate dataNascimento, double cra, String temaPesquisa){
        super(cpf, nome, dataNascimento, cra);
        this.temaPesquisa = temaPesquisa;
    }

    @Override
    public String getDetalhes(){
        return "Estudante Pós-Graduação: " + getNome() + ", Tema de Pesquisa: " + temaPesquisa;
    }

}

import java.time.LocalDate;

public class Estudante {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private double cra;

    public Estudante(String cpf, String nome, LocalDate dataNascimento, double cra){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cra = cra;
    }
    
}

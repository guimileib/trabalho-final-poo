import java.time.LocalDate;

abstract class Estudante {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private double cra;

    public Estudante(String cpf, String nome, LocalDate dataNascimento, double cra){
        setCpf(cpf);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cra = cra;
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public double getCra(){
        return cra;
    }
    // Criei uma exceção caso o cpf não for inserido ou conter menos de 11 dígitos
    public void setCpf(String cpf){
        if(cpf == null || !cpf.matches("\\d{11}")){
            throw new VerificacaoCpfException("CPF inválido: deve conter 11 dígitos.");
        }
        this.cpf = cpf;
    }

    public abstract void imprimirInformacoes();
    
    
}

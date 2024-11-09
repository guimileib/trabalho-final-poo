import java.time.LocalDate;

public class Professor {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate inicioContrato;
    private String departamentoVinculado;

    public Professor(String cpf, String nome, LocalDate dataNascimento, 
    LocalDate inicioContrato, String departamentoVinculado){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.inicioContrato = inicioContrato;
        this.departamentoVinculado = departamentoVinculado;
    }
    
    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new VerificacaoCpfException("CPF inválido: deve conter 11 dígitos.");
        }
        this.cpf = cpf;
    }

    public void imprimirInformacoes(){
        System.out.println("<< Informações Professor >>");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data Nascimento: " + dataNascimento);
        System.out.println("Início Contrato: " + inicioContrato);
        System.out.println("Departamento vinculado: " + departamentoVinculado);
        System.out.println(" ");
    }
}

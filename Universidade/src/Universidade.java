import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Universidade {
    private static ArrayList<Estudante> estudantes = new ArrayList();
    private static ArrayList<Professor> professores = new ArrayList();
    private static LocalDate dataNascimentoEstudante;
        public static void main(String[] args) {
            //Disciplina poo = new Disciplina("FACOM101", "Programação Orientada a Objetos", 64);
            //Disciplina sd = new Disciplina("FACOM102", "Sistemas Digitais", 64);
    
    
            Scanner s = new Scanner(System.in);
            int opcao = 0;
    
            do{
                System.out.println("------------ Menu Universidade -------------");
                System.out.println("1. Cadastrar");
                System.out.println("2. Ver informações." );
                System.out.println("3. Sair.");
                System.out.print("\nDigite sua opção: ");
                opcao = s.nextInt();
    
                switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    verInformacoes();
                    break;
                default:
                    System.err.println("Opção inválida, tente novamente.");
                }

            }while(opcao != 0);
        }
    
        // Criei funções para facilitar a visualização dos switch cases
        public static void cadastrar(){
            int subOpcao = 0;
            Scanner s = new Scanner(System.in);
            System.out.println("------------ Menu Universidade -------------");
            System.out.println("Qual opção você deseja?");
            System.out.println("1. Cadastrar Professores.");
            System.out.println("2. Cadastrar Estudantes");
            System.out.println("3. Cadastrar Disciplina || Turma");

            System.out.print("\nDigite sua opção: ");
            subOpcao = s.nextInt();
            s.nextLine(); // Limpando o buffer
    
            switch (subOpcao) {
                case 1:
                    System.out.println("------------ Menu Cadastro Professor ------------ ");
                    System.out.print("Digite o nome do Professor: ");
                    String nome = s.nextLine();
                    System.out.print("Digite o CPF do Professor: ");
                    String cpf = s.nextLine();
                    System.out.print("Digite o departamento vinculado: ");
                    String departamentoVinculado = s.nextLine();

                    // Formatação do Date time | String <-> DateTime
                    DateTimeFormatter formatterAniversario  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    DateTimeFormatter formatterContrato  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    // Inicializando os objetos, ainda não criados
                    LocalDate inicioContrato = null;
                    LocalDate dataNascimento = null;
                    Professor novoProfessor = null;
                    // Formatando e convertendo os tipos Local Date
                    try{ 
                        System.out.print("Digite o início do Contrato (formato dd/MM/yyyy): ");
                        String inicioContratoInput = s.nextLine();
                        System.out.print("Digite a data de nascimento(formato dd/MM/yyyy): ");
                        String dataInput = s.nextLine();
    
                        dataNascimento = LocalDate.parse(dataInput, formatterAniversario);
                        inicioContrato = LocalDate.parse(inicioContratoInput, formatterContrato);

                    }catch(DateTimeParseException e){
                        System.err.println("Formato de data inválido.Por favor, use o formato dd/MM/yyyy ");
                        break;
                    }

                    novoProfessor = new Professor(cpf, nome, dataNascimento, inicioContrato, departamentoVinculado);  
                    
                    if (novoProfessor != null) {
                        System.out.println("Professor cadastrado com sucesso!");
                    } 

                    break;
                    
                case 2:
                    System.out.println("------------ Menu Cadastro Estudante ------------ ");
                    System.out.print("Digite o nome do Estudante: ");
                    String nomeEstudante = s.nextLine();
                    System.out.print("Digite o CPF do Estudante: ");
                    String cpfEstudante = s.nextLine();
                    System.out.print("Digite o CRA do aluno: ");
                    double cra = s.nextDouble();
    
                    DateTimeFormatter formatterNascimento = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatação do Date time
                    LocalDate dataNascimentoEstudante = null;
                    Estudante novoEstudante = null;
    
                    try{ 
                        System.out.print("Digite a data de nascimento: ");
                        String dataInput =  s.nextLine();
                        dataNascimentoEstudante = LocalDate.parse(dataInput, formatterNascimento);
                        
                    }catch(DateTimeParseException x){
                        System.out.println("Formato de data inválido.Por favor, use o formato dd/MM/yyyy ");
                    }
                    
                    System.out.print("Digite o tipo de estudante (graduação/pós-graduação): ");
                    String tipoEstudante = s.nextLine().toLowerCase();
                    
                    if(tipoEstudante.equals("graduação")){
                        System.out.print("Digite o estágio: ");
                        String estagioSupervisionado = s.nextLine();
                        novoEstudante = new PosGraduacao(cpfEstudante, nomeEstudante, dataNascimentoEstudante, cra, estagioSupervisionado);

                    } else if(tipoEstudante.equals("pós-graduação")){
                        System.out.print("Digite o tema da Pesquisa: ");
                        String temaPesquisa = s.nextLine();
                        novoEstudante = new PosGraduacao(cpfEstudante, nomeEstudante, dataNascimentoEstudante, cra, temaPesquisa);

                    }else{
                        System.out.println("Tipo de estudante inválido, por favor, tente novamente.");
                        break;
                    }
                    if(novoEstudante != null){
                        System.out.println("Estudante cadastrado com sucesso!");
                    }
                    break;
                
                case 3:
                    Disciplina novaDisciplina = null;
                    Turma novaTurma = null;
                    System.out.println("------------ Menu Cadastro Disciplina ------------ ");
                    System.out.print("Digite o código da disciplina: ");
                    String codigo = s.nextLine();
                    System.out.print("Digite o nome da disciplina:");
                    String nomeDisciplina = s.nextLine();
                    System.out.print("Digite a carga horária dessa disciplina: ");
                    double cargaHoraria = s.nextDouble();

                    novaDisciplina = new Disciplina(codigo, nomeDisciplina, cargaHoraria);
                    System.out.println("Disciplina cadastrada com sucesso!");
                    
                    // Cadastro turma associada
                    System.out.println("\nDeseja cadastrar uma turma para essa disciplina? (s/n)");
                    String resposta = s.nextLine();

                    if(resposta.equals("s")){
                        System.out.println("------------ Cadastro Turma ------------ ");
                        System.out.print("Digite o semestre da turma");
                        int semestre = s.nextInt();
                        System.out.print("Digite o ano da turma: ");
                        int anoTurma = s.nextInt();
                        
                        novaTurma = new Turma(novaDisciplina, semestre, anoTurma);
                        System.out.println("Turma cadastrada e associada à disciplina com sucesso!");
                    }else{
                        System.out.println("A disciplina foi cadastrada sem turmas associadas a ela.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                
            }
    }

    public static void verInformacoes(){
        Scanner s = new Scanner(System.in);
        System.out.println("------------ Menu Informações Universidade ------------");
        System.out.println("1. Ver informações dos Professores.");
        System.out.println("2. Ver informacões de todos Estudantes.");
        System.out.println("3. Ver informações de Estudantes Graduação.");
        System.out.println("4. Ver informações dos Estudantes de Pós-Graduação.");
        System.out.println("5. Ver informações da Turma.");
        System.out.println("6. Ver informações das Disciplinas.");
        System.out.print("\nDigite sua opção: ");
        int informacao = s.nextInt();

        switch (informacao) {
            case 1:
                for(Professor professor : professores){
                    professor.imprimirInformacoes();
                }
                break;
            case 2:
                for(Estudante estudante : estudantes){
                    estudante.imprimirInformacoes();
                }
                break;
            case 3: 
                for(Estudante estudante : estudantes){
                    if(estudante instanceof Graduacao){
                        estudante.imprimirInformacoes();
                    }
                }
                break;
            case 4:
                for(Estudante estudante : estudantes){
                    if(estudante instanceof PosGraduacao){
                        estudante.imprimirInformacoes();
                    }
                }
                break;
            default:
                System.out.println("Opção Inválida, tente outra vez.");
        }

    }

}

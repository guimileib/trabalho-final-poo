import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Universidade {
    public static boolean cadastroRealizado = false;
    private static ArrayList<Estudante> estudantes = new ArrayList();
    private static ArrayList<Professor> professores = new ArrayList();
    private static ArrayList<Turma> turmas = new ArrayList();
    private static ArrayList<Disciplina> disciplinas = new ArrayList();
        public static void main(String[] args) {
    
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
                case 3:
                    System.out.println("Você saiu do menu.");
                    opcao = 0;
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
            System.out.println("1. Cadastrar Professores.");
            System.out.println("2. Cadastrar Estudantes");
            System.out.println("3. Cadastrar Disciplina || Turma");
            System.out.println("4. Pré-cadastro automático.");

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

                    if(cpfJaCadastrado(cpf)){
                        System.out.println("Cpf já foi cadastrado no sistema.");
                    }

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
                    // Adcionando cada professor ao array
                    if (novoProfessor != null) {
                        professores.add(novoProfessor);
                        System.out.println("Professor cadastrado com sucesso!");
                    } 
                    break;
                case 2:
                    System.out.println("------------ Menu Cadastro Estudante ------------ ");
                    System.out.print("Digite o nome do Estudante: ");
                    String nomeEstudante = s.nextLine();
                    System.out.print("Digite o CPF do Estudante: ");
                    String cpfEstudante = s.nextLine();
                    // chamada método para comparar ver se o cpf ja foi cadastrado
                    if(cpfJaCadastrado(cpfEstudante)){
                        System.out.println("Cpf já foi cadastrado no sistema");
                    }

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
                    // Adcionando cada estudante ao array
                    if(novoEstudante != null){
                        estudantes.add(novoEstudante);
                        System.out.println("Estudante cadastrado com sucesso!");
                    }
                    break;
                case 3:
                    Disciplina novaDisciplina = null;
                    Turma novaTurma = null;
                    System.out.println("------------ Menu Cadastro Disciplina ------------ ");
                    System.out.print("Digite o código da disciplina: ");
                    String codigo = s.nextLine();
                    System.out.print("Digite o nome da disciplina: ");
                    String nomeDisciplina = s.nextLine();
                    System.out.print("Digite a carga horária dessa disciplina: ");
                    double cargaHoraria = s.nextDouble();

                    novaDisciplina = new Disciplina(codigo, nomeDisciplina, cargaHoraria);
                    System.out.println("Disciplina cadastrada com sucesso!");
                    
                    // Cadastro turma associada
                    System.out.print("\nDeseja cadastrar uma turma para essa disciplina? (s/n): ");
                    String resposta = s.nextLine();

                    if(resposta.equalsIgnoreCase("s")){
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
                    if(novaTurma != null){
                        turmas.add(novaTurma);
                    }

                    break;

                case 4:
                    realizarPreCadastro();
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

            public static void realizarPreCadastro() {
                if(cadastroRealizado){
                    System.out.println("Pré cadastro já foi realizado anteriormente.");
                }
                Professor professor1 = new Professor("11111111111", "Carlos Silva", LocalDate.of(1980, 5, 15), LocalDate.of(2010, 3, 1), "Departamento de Matemática");
                Professor professor2 = new Professor("22222222222", "Ana Oliveira", LocalDate.of(1975, 7, 20), LocalDate.of(2005, 8, 15), "Departamento de Física");
                professores.add(professor1);
                professores.add(professor2);

                Estudante estudante1 = new Graduacao("33333333333", "João Souza", LocalDate.of(2002, 9, 10), 8.5, "Estágio em Desenvolvimento");
                Estudante estudante2 = new PosGraduacao("44444444444", "Maria Costa", LocalDate.of(1998, 4, 5), 9.0, "Pesquisa em IA");
                
                estudantes.add(estudante1);
                estudantes.add(estudante2);
            
                Disciplina disciplina1 = new Disciplina("MAT101", "Cálculo I", 60);
                Disciplina disciplina2 = new Disciplina("FIS202", "Física II", 80);
                disciplinas.add(disciplina1);
                disciplinas.add(disciplina2);

                Turma turma1 = new Turma(disciplina1, 1, 2024);
                Turma turma2 = new Turma(disciplina2, 2, 2024);
                turmas.add(turma1);
                turmas.add(turma2);
                cadastroRealizado = true;
                System.out.println("Pré-cadastro realizado com sucesso!");
            }
            
            private static boolean cpfJaCadastrado(String cpf) {
                for (Estudante estudante : estudantes) {
                    if (estudante.getCpf().equals(cpf)) {
                        return true; 
                    }
                }
                for (Professor professor : professores) {
                    if (professor.getCpf().equals(cpf)) {
                        return true; 
                    }
                }
                return false; 
            }
}

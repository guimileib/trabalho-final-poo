package com.universidade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Universidade {
   
    public static boolean cadastroRealizado = false;
    private static List<Estudante> estudantes = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
        public static void main(String[] args) {
            
            carregarDados();

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
                    salvarDados();
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
            System.out.println("2. Cadastrar Estudantes.");
            System.out.println("3. Cadastrar Disciplina & Turma.");
            System.out.println("4. Pré-cadastro automático.");
            System.out.println("5. Voltar.");

            System.out.print("\nDigite sua opção: ");
            subOpcao = s.nextInt();
            s.nextLine(); 
    
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

                    DateTimeFormatter formataAniversario  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    DateTimeFormatter formataContrato  = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    LocalDate inicioContrato = null;
                    LocalDate dataNascimento = null;
                    Professor novoProfessor = null;

                    try{ 
                        System.out.print("Digite o início do Contrato (formato dd/MM/yyyy): ");
                        String dataInicioContrato = s.nextLine();
                        System.out.print("Digite a data de nascimento(formato dd/MM/yyyy): ");
                        String data = s.nextLine();
    
                        dataNascimento = LocalDate.parse(data, formataAniversario);
                        inicioContrato = LocalDate.parse(dataInicioContrato, formataContrato);

                    }catch(DateTimeParseException e){
                        System.err.println("Formato de data inválido.Por favor, use o formato dd/MM/yyyy ");
                        break;
                    }

                    novoProfessor = new Professor(cpf, nome, dataNascimento, inicioContrato, departamentoVinculado);  

                    if (novoProfessor != null) {
                        professores.add(novoProfessor);
                        salvarDados();
                        System.out.println("Professor cadastrado com sucesso!");
                    } 
                    break;

                case 2:
                    double cra = 0;
                    System.out.println("------------ Menu Cadastro Estudante ------------ ");
                    System.out.print("Digite o nome do Estudante: ");
                    String nomeEstudante = s.nextLine();
                    System.out.print("Digite o CPF do Estudante: ");
                    String cpfEstudante = s.nextLine();

                    // chamada método para comparar ver se o cpf ja foi cadastrado
                   if(cpfJaCadastrado(cpfEstudante)){
                        System.out.println("Cpf já foi cadastrado no sistema");
                        break;
                    }

                    System.out.print("Digite o CRA do aluno: ");
                    cra = s.nextDouble();
                    s.nextLine();

    
                    DateTimeFormatter formataNascimento = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatação do Date time
                    LocalDate dataNascimentoEstudante = null;
                    Estudante novoEstudante = null;
                    while(true){
                        try{ 
                            System.out.print("Digite a data de nascimento: ");
                            String data =  s.nextLine();
                            dataNascimentoEstudante = LocalDate.parse(data, formataNascimento);
                            break;
                        }catch(DateTimeParseException x){
                            System.out.println("Formato de data inválido.Por favor, use o formato dd/MM/yyyy ");
                        }
                    }

                    while(true){
                        System.out.print("Digite o tipo de estudante (1 = graduação | 2 = pós-graduação): ");
                        Integer tipoEstudante = s.nextInt();
                        s.nextLine();
                    
                        if(tipoEstudante.equals(1)){
                            System.out.print("Digite o estágio: ");
                            String estagioSupervisionado = s.nextLine();
                            novoEstudante = new Graduacao(cpfEstudante, nomeEstudante, dataNascimentoEstudante, cra, estagioSupervisionado);
                            
                        } else if(tipoEstudante.equals(2)){
                            System.out.print("Digite o tema da Pesquisa: ");
                            String temaPesquisa = s.nextLine();
                            novoEstudante = new PosGraduacao(cpfEstudante, nomeEstudante, dataNascimentoEstudante, cra, temaPesquisa);
                            
                        }else{
                            System.out.println("Tipo de estudante inválido, por favor, tente novamente.");  
                        }

                        break;
                    }
                    // Adcionando cada estudante ao array
                    if(novoEstudante != null){
                        estudantes.add(novoEstudante);
                        salvarDados();
                        System.out.println("Estudante cadastrado com sucesso!");
                    }
                    break;
                case 3:
                    Disciplina novaDisciplina = null;
                    Turma novaTurma = null;
                    System.out.println(" ");
                    System.out.println("------------ Menu Cadastro Disciplina ------------ ");
                    System.out.print("Digite o código da disciplina: ");
                    String codigo = s.nextLine();

                    System.out.print("Digite o nome da disciplina: ");
                    String nomeDisciplina = s.nextLine();
                    
                    System.out.print("Digite a carga horária dessa disciplina: ");
                    double cargaHoraria = s.nextDouble();
                    s.nextLine(); // sem estava bugando o s/n
                    novaDisciplina = new Disciplina(codigo, nomeDisciplina, cargaHoraria);

                    while(true){ // vai garantir que tenha uma entrada válida
                        System.out.print("Deseja cadastrar uma turma para essa disciplina? (s/n): "); // Cadastro turma associada
                        String resposta = s.nextLine();

                        if(resposta.equalsIgnoreCase("n")){
                            disciplinas.add(novaDisciplina);
                            System.out.println("Disciplina cadastrada com sucesso!");
                            salvarDados();
                            break;

                        }else if(resposta.equalsIgnoreCase("s")){
                            System.out.println("------------ Cadastro Turma ------------ ");
                            System.out.print("Digite o semestre da turma: ");
                            int semestre = s.nextInt();
                            s.nextLine();

                            System.out.print("Digite o ano da turma: ");
                            int anoTurma = s.nextInt();
                            s.nextLine();

                            novaTurma = new Turma(novaDisciplina, semestre, anoTurma);
                            turmas.add(novaTurma);
                            System.out.println("Turma cadastrada e associada à disciplina com sucesso!");
                            disciplinas.add(novaDisciplina);
                            salvarDados();
                            break;
                            
                        }else{
                            System.out.println("Digite uma opção válida: (s ou n). ");
                        }

                    }

                    break;   
                case 4:
                    realizarPreCadastro();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
             }
            }

            public static void verInformacoes(){
                carregarDados();
                Scanner s = new Scanner(System.in);
                System.out.println("------------ Menu Informações Universidade ------------");
                System.out.println("1. Ver informações dos Professores.");
                System.out.println("2. Ver informacões de todos Estudantes.");
                System.out.println("3. Ver informações de Estudantes Graduação.");
                System.out.println("4. Ver informações dos Estudantes de Pós-Graduação.");
                System.out.println("5. Ver informações da Turma.");
                System.out.println("6. Ver informações das Disciplinas.");
                System.out.println("7. Voltar.");
                System.out.print("\nDigite sua opção: ");
                int informacao = s.nextInt();
                s.nextLine();
                
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
                case 5:
                    for(Turma turma : turmas){
                        turma.imprimirInfoTurmas();
                    }
                    break;
                case 6:
                    for(Disciplina disciplina : disciplinas){
                        disciplina.imprimirInformacoes();
                    }
                    break;
                case 7:

                    return;
                default:
                    System.out.println("Opção Inválida, tente outra vez.");

                }

            }

            public static void realizarPreCadastro() {
                if(cadastroRealizado){
                    System.out.println("Pré cadastro já foi realizado anteriormente.");
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                Professor professor1 = new Professor("11111111111", "Carlos Silva", LocalDate.parse("15/05/1980", formatter), LocalDate.parse("01/03/2010", formatter), "Departamento de Matemática");
                Professor professor2 = new Professor("22222222222", "Ana Oliveira", LocalDate.parse("20/07/1975", formatter), LocalDate.parse("15/08/2005", formatter), "Departamento de Física");
                professores.add(professor1);
                professores.add(professor2);

                Estudante estudante1 = new Graduacao("33333333333", "João Souza", LocalDate.parse("10/09/2002", formatter), 8.5, "Estágio em Desenvolvimento");
                Estudante estudante2 = new PosGraduacao("44444444444", "Maria Costa", LocalDate.parse("05/04/1998", formatter), 9.0, "Pesquisa em IA");
                
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
                carregarDados();

                if(estudantes == null || estudantes.isEmpty() && 
                    (professores == null || professores.isEmpty())){ // verificar se a lista antes de acessar o metodo
                    System.out.println("Lista de estudantes não carregada corretamente!"); 
                    return false;
                }

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

            
            public static void salvarDados(){
                String caminhoArquivo =  "G:\\Aulas\\POO\\Trabalho Final\\Universidade\\demo\\src\\main\\resources\\universidade_data.ser";
                try(FileOutputStream fileOut = new FileOutputStream(caminhoArquivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut) ){
                    out.writeObject(estudantes);
                    out.writeObject(professores);
                    out.writeObject(turmas);
                    out.writeObject(disciplinas);
                    out.close();
                    System.out.println("Dados salvos com sucesso!");
                } catch (Exception e) {
                    System.err.println("Erro ao salvar dados: " + e.getMessage());
                }
            }

            @SuppressWarnings("unchecked")
            public static void carregarDados() {
                String caminhoArquivo =  "G:\\Aulas\\POO\\Trabalho Final\\Universidade\\demo\\src\\main\\resources\\universidade_data.ser";
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo));
                    estudantes = (List<Estudante>) ois.readObject();
                    professores = (List<Professor>) ois.readObject();
                    turmas = (List<Turma>) ois.readObject();
                    disciplinas = (List<Disciplina>) ois.readObject();
                    ois.close();
                    System.out.println("Dados carregados com sucesso!");
                } catch (Exception e) {
                    System.out.println("Nenhum dado salvo encontrado ou erro ao carregar dados. Criando novas listas.");
                    estudantes = new ArrayList<>();
                    professores = new ArrayList<>();
                    turmas = new ArrayList<>();
                    disciplinas = new ArrayList<>();
                }
            }

}

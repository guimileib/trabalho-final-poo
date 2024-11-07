public class Universidade {
    public static void main(String[] args) {
        Disciplina poo = new Disciplina("FACOM101", "Programação Orientada a Objetos", 64);
        Disciplina sd = new Disciplina("FACOM102", "Sistemas Digitais", 64);

        Turma turma1 = new Turma(poo, 3, 2023);
        Turma turma2 = new Turma(poo,3,2023);

        Turma turma3 = new Turma(sd,2,2024);
        Turma turma4 = new Turma(sd, 2, 2024);


        poo.imprimirInfoDisciplina();
        sd.imprimirInfoDisciplina();
        System.out.println(" ");
        turma1.imprimirInfoTurmas();
        turma2.imprimirInfoTurmas();
    }
}

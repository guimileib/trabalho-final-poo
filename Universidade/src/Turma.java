public class Turma {
    private int semestre;
    private int anoTurma;
    private Disciplina disciplina;

    public Turma(Disciplina disciplina, int semestre, int anoTurma){
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.anoTurma = anoTurma;
        disciplina.adicionarTurma(this);
    }

    public int getSemestre() {
        return semestre;
    }

    public int getAnoTurma() {
        return anoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void imprimirInfoTurmas(){
        System.out.println("Disciplinas: " + disciplina.getNomeDisciplina() + " | " + "Semestre: " + semestre + " | "
        + "Ano Turma: " + anoTurma);
    }
}

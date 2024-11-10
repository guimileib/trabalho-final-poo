public class Turma {
    private int semestre;
    private int anoTurma;
    private Disciplina disciplina;

    public Turma(Disciplina disciplina, int semestre, int anoTurma){
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.anoTurma = anoTurma;
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

    //Criando set's com tratamento para possíveis erros
    public void setSemestre(int semestre){
        // limite de semesre e semestres positivos

    }   

    public void setAnoTurma(int anoTurma){
        // limite de ano e ano potivo
        if(anoTurma < 0){
            
        }
    }


    public void imprimirInfoTurmas(){
        System.out.println("Disciplinas: " + disciplina.getNomeDisciplina() + " | " + "Semestre: " + semestre + " | "
        + "Ano Turma: " + anoTurma);
    }
}

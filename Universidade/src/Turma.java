public class Turma {
    private int semestre;
    private int anoTurma;
    private Disciplina disciplina;

    public Turma(Disciplina disciplina, int semestre, int anoTurma){
        this.disciplina = disciplina;
        this.semestre = semestre;
        setAnoTurma(anoTurma);
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
        // limite de semestre e semestres positivos
        if(semestre < 1){
            throw new InvalidoTurmaException("O semestre deve ser maior ou igual a 1.");
        }
    }   

    public void setAnoTurma(int anoTurma){
        // limite de ano e ano potivo
        if(anoTurma < 1){
            throw new InvalidoTurmaException("Ano turma inválido: cadastro é a apartir do primeiro ano. ");
        }
        this.anoTurma = anoTurma;
    }


    public void imprimirInfoTurmas(){
        System.out.println("Disciplinas: " + disciplina.getNomeDisciplina() + " | " + "Semestre: " + semestre + " | "
        + "Ano Turma: " + anoTurma);
    }
}

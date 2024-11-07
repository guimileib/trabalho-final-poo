import java.util.ArrayList;

public class Disciplina {
    private String codigo;
    private String nomeDisciplina;
    private double cargaHoraria;
    private ArrayList<Turma> turmas;

    public Disciplina(String codigo, String nomeDisciplina, double cargaHoraria){
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma){
        turmas.add(turma);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void imprimirInfoDisciplina(){
        System.out.println("Turmas da Disciplina: " + nomeDisciplina);
        for(Turma turma : turmas){
            System.out.println("Ano: " + turma.getAnoTurma() + ", Semestre: " + turma.getSemestre());
        }
    }
}

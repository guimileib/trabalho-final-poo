public class Disciplina {
    private String codigo;
    private String nomeDisciplina;
    private double cargaHoraria;

    public Disciplina(String codigo, String nomeDisciplina, double cargaHoraria){
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
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



    public void imprimirInformacoes(){
        System.out.println("Turmas da Disciplina: " + nomeDisciplina);
    }
}

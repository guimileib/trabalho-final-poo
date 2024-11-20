package com.universidade;

import java.time.LocalDate;

public class PosGraduacao extends Estudante  {
    private String temaPesquisa;

    public PosGraduacao(String cpf, String nome, LocalDate dataNascimento, double cra, String temaPesquisa){
        super(cpf, nome, dataNascimento, cra);
        this.temaPesquisa = temaPesquisa;
    }

    @Override
    public void imprimirInformacoes() {
        System.out.println("<< Informações Estudante de Pós-Graduação >>");
        System.out.println("Nome: " + getNome() + "| CPF: " + getCpf() + "| Data de Nascimento: " + getDataNascimento() + " | CRA: " + getCra() + "| Tema de Pesquisa: " + temaPesquisa);
        System.out.println(" ");
    }

}   

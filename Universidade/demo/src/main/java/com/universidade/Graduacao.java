package com.universidade;
import java.time.LocalDate;

public class Graduacao extends Estudante {
    private String estagioSupervisionado;

    public Graduacao(String cpf, String nome, LocalDate dataNascimento, double cra, String estagioSupervisionado){
        super(cpf, nome, dataNascimento, cra);
        this.estagioSupervisionado = estagioSupervisionado;
    }
    
    @Override
    public void imprimirInformacoes(){
        System.out.println("<< Informações Estudante de Graduação >>");
        System.out.println("Nome: " + getNome() + "| CPF: " + getCpf() + "| Data de Nascimento: " + getDataNascimento() + "| CRA: " + getCra() + "| Estágio Supervisinado: " + estagioSupervisionado);
        System.out.println(" ");
    }

}   

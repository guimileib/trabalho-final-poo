package com.universidade;

import java.io.Serializable;
import java.time.LocalDate;

public class Professor implements Serializable {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate inicioContrato;
    private String departamentoVinculado;

    public Professor(String cpf, String nome, LocalDate dataNascimento, 
    LocalDate inicioContrato, String departamentoVinculado){
        setCpf(cpf);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.inicioContrato = inicioContrato;
        this.departamentoVinculado = departamentoVinculado;
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new VerificacaoCpfException("CPF inválido: deve conter 11 dígitos.");
        }
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    } 

    public void imprimirInformacoes(){
        System.out.println("<< Informações Professor >>");
        System.out.println("Nome: " + nome + "| CPF: " + cpf + "| Data Nascimento: " + dataNascimento + "| Início Contrato: " + inicioContrato + "| Departamento vinculado: " + departamentoVinculado);
        System.out.println(" ");
    }
}

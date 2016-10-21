package com.sistema.bean;


public class Aluno {

    private String cod_aluno;
    private String nome_aluno;
    private String senha_aluno;

    public void get_data(String codigo, String nome, String senha) {
        this.cod_aluno = codigo;
        this.nome_aluno = nome;
        this.senha_aluno = senha;
    }

    public String get_codigo() {
        return cod_aluno;
    }

    public String get_nome() {
        return nome_aluno;
    }

    // dont think this function should really exist ? can somebody look here?
    public String get_senha() {
        return senha_aluno;
    }

}

package com.sistema.bean;

public class Question {

    private String enunciado;
    private String a, b, c, d;

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setOpcoes(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

}

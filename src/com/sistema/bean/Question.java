package com.sistema.bean;

public class Question {

    private String enunciado;
    private String a, b, c, d, resp;

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setOpcoes(String a, String b, String c, String d, String resp) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.resp = resp;
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

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

}

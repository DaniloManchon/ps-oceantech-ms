package com.oceantech.model;

public class Oceans<T> {
    String id;
    String nome;
    String data;
    float ph;
    int co;

    public Oceans(String id, String nome, String data, float ph, int co) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.ph = ph;
        this.co = co;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }
}

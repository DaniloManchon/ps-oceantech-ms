package com.oceantech.model;

public class Oceans<T> {
    String id;
    String name;
    String data;
    float ph;
    int co;

    public Oceans(String id, String nome, String data, float ph, int co) {
        this.id = id;
        this.name = nome;
        this.data = data;
        this.ph = ph;
        this.co = co;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

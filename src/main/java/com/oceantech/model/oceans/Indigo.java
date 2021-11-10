package com.oceantech.model.oceans;

import lombok.Data;

@Data
public class Indigo {
    public double ph;
    public int co;

    public Indigo(double ph, int co) {
        this.ph = ph;
        this.co = co;
    }
}

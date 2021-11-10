package com.oceantech.model.oceans;

import lombok.Data;

@Data
public class Pacifico {
    public double ph;
    public int co;

    public Pacifico(double ph, int co) {
        this.ph = ph;
        this.co = co;
    }
}

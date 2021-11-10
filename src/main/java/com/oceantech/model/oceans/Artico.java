package com.oceantech.model.oceans;

import lombok.Data;

@Data
public class Artico {
    public double ph;
    public int co;

    public Artico(double ph, int co) {
        this.ph = ph;
        this.co = co;
    }
}

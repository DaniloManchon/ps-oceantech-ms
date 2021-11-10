package com.oceantech.model.oceans;

import lombok.Data;

@Data
public class Atlantico {
    public double ph;
    public int co;

    public Atlantico(double ph, int co) {
        this.ph = ph;
        this.co = co;
    }
}

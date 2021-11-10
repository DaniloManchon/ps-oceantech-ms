package com.oceantech.model.oceans;

import lombok.Data;

@Data
public class Antartico {
    public double ph;
    public int co;

    public Antartico(double ph, int co) {
        this.ph = ph;
        this.co = co;
    }
}

package com.oceantech.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "oceans")
public class Oceans {
    @Id
    String id;
    String name;
    String data;
    float ph;
    int co;

    public Oceans(String name, String data, float ph, int co) {
        this.name = name;
        this.data = data;
        this.ph = ph;
        this.co = co;
    }
}

package com.oceantech.model.oceans;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "antartico")
public class Antartico {
    @Id
    String id;
    String nome;
    String data;
    float ph;
    int co;
}

package com.oceantech.model;

import com.oceantech.model.oceans.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("Caracteristicas")
public class Caracteristicas {
    @Id
    private String id;

    private String data_coleta;
    //oceans
    private Atlantico atlantico;
    private Pacifico pacifico;
    private Artico artico;
    private Antartico antartico;
    private Indigo indigo;

    public Caracteristicas(String data_coleta, Atlantico atlantico, Pacifico pacifico, Artico artico, Antartico antartico, Indigo indigo) {
        this.data_coleta = data_coleta;
        this.atlantico = atlantico;
        this.pacifico = pacifico;
        this.artico = artico;
        this.antartico = antartico;
        this.indigo = indigo;
    }
}

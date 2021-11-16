package com.oceantech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OceansResponseDto {
    @JsonIgnore
    String id;
    String nome;
    String data;
    float ph;
    int co;
}

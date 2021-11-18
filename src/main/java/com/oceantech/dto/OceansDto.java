package com.oceantech.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OceansDto {
    @JsonProperty
    String name;
    @JsonProperty
    String data;
    @JsonProperty
    float ph;
    @JsonProperty
    int co;
}

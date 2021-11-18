package com.oceantech.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OceansUpdateDto {
    @JsonProperty
    String data;
    @JsonProperty
    float ph;
    @JsonProperty
    int co;
}

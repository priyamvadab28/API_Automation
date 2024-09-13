package com.automation.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AuthResponseModel {
    @JsonProperty
    private String token;

}

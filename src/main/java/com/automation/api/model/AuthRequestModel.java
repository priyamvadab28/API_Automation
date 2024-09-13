package com.automation.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthRequestModel {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;
}
package com.automation.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponseModel {

    @JsonProperty("bookingid")
    int bookingId;

    @JsonProperty("booking")
    BookingRequestModel bookingRequestModel;
}

package com.automation.api.client;


import com.automation.api.config.ApiConfig;
import io.restassured.http.ContentType;

import static com.automation.api.constant.APIEndpoint.AUTH_ENDPOINT;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

import com.automation.api.model.AuthRequestModel;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class AuthApiImpl implements AuthApi {


    private final Logger logger = LoggerFactory.getLogger(getClass());


    static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());


    @Override
    public String createToken(AuthRequestModel authRequestModel) {


        String token=  given(requestSpecification).contentType(ContentType.JSON)
                .body(authRequestModel)
                .when()
                .post(AUTH_ENDPOINT.get())
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .get("token");
        logger.info("Token generated successfully.");

        return token;

    }

    public static RequestSpecification requestSpecification = with()
            .log().uri()
            .log().body()
            .baseUri(config.baseUrl());


}

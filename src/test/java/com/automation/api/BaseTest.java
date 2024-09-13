package com.automation.api;

import com.automation.api.client.AuthApiImpl;
import com.automation.api.config.ApiConfig;
import com.automation.api.model.AuthRequestModel;
import com.automation.api.client.AuthApi;
import com.automation.api.client.BookingService;
import com.automation.api.client.BookingServiceImpl;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    protected String token;
    TestData testData = new TestData();
    AuthApi authApi= new AuthApiImpl();
    BookingService bookingService= new BookingServiceImpl();

    @BeforeEach
    void CreateToken() {
        AuthRequestModel authRequestModel = new AuthRequestModel(config.username(), config.password());
        token = authApi.createToken(authRequestModel);

    }

}

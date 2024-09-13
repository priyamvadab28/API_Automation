package com.automation.api.client;


import com.automation.api.config.ApiConfig;
import com.automation.api.constant.APIEndpoint;
import com.automation.api.model.BookingRequestModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.springframework.stereotype.Service;
import static io.restassured.RestAssured.with;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


@Slf4j
@Service
public class BookingServiceImpl implements BookingService {

    static ApiConfig config= ConfigFactory.create(ApiConfig.class, System.getProperties());

    @Override
    public Response getAllbooking() {

        return given(requestSpecification)
                .when()
                .get(APIEndpoint.BOOKING_ENDPOINT.get())
                .then()
                .extract()
                .response();
    }

    @Override
    public Response getBookingIdsByName(String firstName, String lastName) {
        return given(requestSpecification).param("firstname", firstName)
                .param("lastname", lastName)
                .when()
                .get(APIEndpoint.BOOKING_ENDPOINT.get())
                .then()
                .extract()
                .response();
    }

    public Response getBookingById(int id) {
        return given(requestSpecification).get(APIEndpoint.BOOKING_ENDPOINT.get() + id);
    }

    @Override
    public Response createBooking(BookingRequestModel bookingRequestModel, String token) {

        return given(requestSpecification).contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .contentType(JSON)
                .body(bookingRequestModel)
                .when()
                .post(APIEndpoint.BOOKING_ENDPOINT.get());
    }


    public Response updateBooking(BookingRequestModel bookingRequestModel, String token, int id) {
        return given(requestSpecification)
                .header("Cookie", "token=" + token)
                .contentType(JSON)
                .body(bookingRequestModel)
                .when()
                .put(APIEndpoint.BOOKING_ENDPOINT.get()+ id);
    }


    public static RequestSpecification requestSpecification = with()
            .log().uri()
            .log().body()
            .baseUri(config.baseUrl());


}



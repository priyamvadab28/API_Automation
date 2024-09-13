package com.automation.api;

import com.automation.api.model.AuthRequestModel;
import com.automation.api.model.BookingRequestModel;
import com.automation.api.model.BookingResponseModel;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.http.HttpStatus.SC_OK;

public class BookingTest extends BaseTest {


    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdfDate.format(new Date());

    @Test
    public void testCreateTokenReturnsNotNull(){
        AuthRequestModel authRequestModel = new AuthRequestModel(config.username(), config.password());


        String token = authApi.createToken(authRequestModel);
        Assert.assertNotNull(token);
    }

    @Test
    public void testGetAllBookingReturns200() {
        Response response = bookingService.getAllbooking();

        Assert.assertEquals(response.statusCode(), SC_OK);
    }

    @Test
    public void testGetBookingIdsByNameReturns200() {
        Response response = bookingService.getBookingIdsByName("John", "Smith");

        Assert.assertEquals(response.statusCode(), SC_OK);
    }

    @Test
    public void testCreateNewBookingreturns200() {
        BookingRequestModel bookingRequestModel = testData.createBookingRequestModel();

        Response response = bookingService.createBooking(bookingRequestModel,token);

        Assert.assertEquals(response.statusCode(), SC_OK);

        BookingResponseModel bookingResponseModel=response.then().extract().as(BookingResponseModel.class);

        int bookingId= bookingResponseModel.getBookingId();

        response= bookingService.getBookingById(bookingId);
        Assert.assertEquals(response.statusCode(), SC_OK);


    }


    @Test
    public void testUpdateBookingReturns200() {
        BookingRequestModel bookingRequestModel = testData.createBookingRequestModel();

        int id =
                bookingService.createBooking(bookingRequestModel,token)
                        .as(BookingResponseModel.class)
                        .getBookingId();

        bookingRequestModel.setTotalPrice(testData.getTotalPrice());

        Response response = bookingService.updateBooking(bookingRequestModel, token, id);

        Assert.assertEquals(response.statusCode(), SC_OK);
    }



}

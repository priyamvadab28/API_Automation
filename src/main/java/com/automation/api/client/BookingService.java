package com.automation.api.client;

import com.automation.api.model.BookingRequestModel;
import io.restassured.response.Response;

public interface BookingService {

    Response getAllbooking();
    Response getBookingIdsByName(String firstName, String lastName);
    Response createBooking(BookingRequestModel bookingRequestModel,String token);
    Response getBookingById(int id);
    Response updateBooking(BookingRequestModel bookingRequestModel, String token, int id);


}

package com.automation.api;

import com.automation.api.model.BookingDates;
import com.automation.api.model.BookingRequestModel;
import com.github.javafaker.Faker;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestData {

    final Faker faker = new Faker();

    @Setter
    String firstName, lastName, additionalNeeds, checkin, checkout;
    String[] needs = new String[]{"Breakfast", "Dinner", "Room service", "Free parking", "None"};
    @Setter
    int totalPrice;
    @Setter
    boolean depositPaid;

    public LocalDate generateRandomDate() {
        int year = faker.number().numberBetween(2020, 2050);
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 28);
        return LocalDate.of(year, month, day);
    }

    public void getDates() {
        LocalDate checkInDate = generateRandomDate();
        LocalDate checkOutDate = checkInDate.plusDays(faker.number().numberBetween(1, 30));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        setCheckin(checkInDate.format(dateTimeFormatter));
        setCheckout(checkOutDate.format(dateTimeFormatter));
    }

    public String getRandomItemFromArray(String[] items) {
        return faker.options().option(items);
    }

    public void generateData() {
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        setAdditionalNeeds(getRandomItemFromArray(needs));
        setTotalPrice(faker.number().numberBetween(100, 1000));
        setDepositPaid(faker.bool().bool());
    }

    public int getTotalPrice(){
        return faker.number().numberBetween(100, 500);
    }

    BookingRequestModel createBookingRequestModel() {
        generateData();
        getDates();

        return BookingRequestModel.builder()
                .firstName(firstName)
                .lastName(lastName)
                .totalPrice(totalPrice)
                .depositPaid(depositPaid)
                .bookingDates(new BookingDates(checkin, checkout))
                .additionalNeeds(additionalNeeds).
                        build();
    }
}

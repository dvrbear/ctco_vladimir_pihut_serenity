package starter.definition;

import io.cucumber.java.en.When;
import starter.implementation.Booking;

public class BookingDef {

    Booking booking;

    @When("submit workplace booking")
    public void submitWorkplaceBooking() {
        booking.submitWorkplaceBooking();
    }

    @When("cancel workplace booking")
    public void cancelWorkplaceBooking() {
        booking.cancelWorkplaceBooking();
    }

    @When("try to cancel workplace booking")
    public void tryToCancelWorkplaceBooking() {
        booking.tryToCancelWorkplaceBooking();
    }

    @When("select first free place")
    public void selectFirstFreePlace() {
        booking.selectFirstFreePlace();
    }

    @When("submit parking booking for car number : {}")
    public void submitParkingBooking(String carNumber) {
        booking.submitParkingBooking(carNumber);
    }

}

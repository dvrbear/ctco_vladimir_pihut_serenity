package starter.definition;

import io.cucumber.java.en.When;
import starter.implementation.Booking;
import starter.implementation.Login;

import static starter.utils.Creds.BASE_URL;

public class BookingDef {

    Booking booking;

    @When("submit booking")
    public void submitBooking() {
        booking.submitBooking();
    }

    @When("cancel booking")
    public void cancelBooking() {
        booking.cancelBooking();
    }

    @When("select first free place")
    public void selectFirstFreePlace() {
        booking.selectFirstFreePlace();
    }

}

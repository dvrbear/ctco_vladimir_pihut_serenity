package starter.implementation;

import static starter.utils.Const.FREE_PLACE_SEARCH_PATTERN;
import static starter.utils.ConstXpath.*;

public class Booking extends BasePageObject {

    public void selectFirstFreePlace() {
        clickOnFirstFound(FREE_PLACE_SEARCH_PATTERN);
    }

    public void submitWorkplaceBooking() {
        click(BOOK_BTN_XP);
        click(CLOSE_BTN_XP);
    }

    public void cancelBooking() {
        click(CANCEL_BTN_XP);
        click(YES_BTN_XP);
        click(CLOSE_BTN_XP);
    }

    public void submitParkingBooking(String carNumber) {
        click(BOOK_BTN_XP);
        input(carNumber, CAR_NUMBER_XP);
        click(CONFIRM_BTN_XP);
        click(CLOSE_BTN_XP);
    }

}

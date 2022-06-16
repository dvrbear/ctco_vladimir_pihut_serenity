package starter.definition;

import io.cucumber.java.en.When;
import starter.implementation.CalendarNav;

import static starter.utils.ConstXpath.SWITCH_BTN_XPATH;

public class CalendarDef  {

    private CalendarNav calendar;

    @When("selects date : {} {}")
    public void selectDate(String month, String dayOfMonth){
        calendar.click(SWITCH_BTN_XPATH);
        calendar.clickNextWeek(month,dayOfMonth);
//        calendar.checkWhatMonth(month,dayOfMonth);
    }

    @When("select current date plus {} day(s)")
    public void selectCurrentDatePlusDays(int addDays){
        calendar.selectCurrentDatePlusDays(addDays);
    }

    @When("selects place by hours: from {} to {}")
    public void selectHours(String startHour, String endHour){
        calendar.timeDrag(startHour, endHour);
    }
}

package starter.definition;

import io.cucumber.java.en.When;
import starter.implementation.WorkScheduleNav;

import static starter.utils.ConstXpath.*;


public class MyWorkScheduleDef {

    private  WorkScheduleNav workSchedule;
    @When("navigates to MySettings")

    public void navigateToMySettings(){
        workSchedule.click(MY_ICON_IN_RIGHT_CORNER_XP);
        workSchedule.click(MY_SETTINGS_XP);
    }

    @When("opens Work Schedule")

    public void openWorkSchedule(){
        workSchedule.click(WORK_SCHEDULE_XP);
    }

    @When("selects working days")

    public void selectDay(){
        workSchedule.click(WORK_SCHEDULE_EDIT_BUTTON_XP);
        workSchedule.deselectIfSelected();
        workSchedule.selectWorkingDays();
    }

    @When("selects working hours from {} to {}")

    public void selectWorkingHours(String fromHour, String toHour){
       workSchedule.selectHours(fromHour,toHour);
    }

    @When("clicks Save")

    public void clickSave(){
        workSchedule.click(WORK_SCHEDULE_SAVE_BUTTON_XP);
        workSchedule.click(WORK_SCHEDULE_OK_BUTTON_XP);
    }

    @When("clicks Reset")

    public void clickReset(){
        workSchedule.click(WORK_SCHEDULE_RESET_BUTTON_XP);
    }
}

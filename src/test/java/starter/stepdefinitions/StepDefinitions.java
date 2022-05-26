package starter.stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static starter.utils.ConstXpath.*;

public class StepDefinitions extends BaseSteps {


    @When("opens main page")
    public void openShopPage() {
        initDriver("https://senseit-test.orange.md/");
        System.out.println("*********************************************");
        System.out.println(driver.toString());
        System.out.println("*********************************************");
    }

    @When("introduce username and pass")
    public void readFile() {
        input("vpihut", user_x);
        input("Batman1903", pass_x);
    }

    @When("press login button")
    public void loginButt() {
        click(login_x);
    }

    @When("inserts token")
    public void insertToken() {
        input(getClipboard(), token_x);
    }

    @When("sign in seat")
    public void signIn() {
        click(signin_x);
    }

    @When("go to booking")
    public void goToBooking() {
        click(extend_nav_bar_x);
        click(booking_x);
    }

    @When("open workplaces")
    public void openWorkspaces() {
        click(workplace_x);
    }

    @When("select ZTower")
    public void selectZTower() {
        click(ztower_x);
    }

    @When("select Kitchen")
    public void selectKitchen() {
        click(kitchen_x);
    }

    @When("submit booking")
    public void submitBooking() {
        click(book_btn);
        click(close_btn);
    }

    @When("cancel booking")
    public void cancelBooking() {
        click(cancel_btn);
        click(yes_btn);
        click(close_btn);
    }

    @When("select date")
    public void selectDate() {
        click(date_x);
    }

    @When("select place {}")
    public void selectPlace(String place) {
        clickOnFreePLace(place);
    }

    @When("select first free place")
    public void selectFirstFreePlace() {
        List<WebElement> list = getAllFreePlaces();
        if (list.size() > 0) {
            WebElement element = getAllFreePlaces().get(0);
            System.out.println(element);
            actionClick(getAllFreePlaces().get(0));
        }
    }

}

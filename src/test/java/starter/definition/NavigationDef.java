package starter.definition;

import io.cucumber.java.en.When;
import starter.implementation.Navigation;

import static starter.utils.Const.BASE_URL;

public class NavigationDef {

    private Navigation navigation;

    @When("open main page")
    public void openShopPage() {
        navigation.gotoURL(BASE_URL);
    }

    @When("goto vacancies")
    public void gotoVacancies() {
        navigation.gotoVacancies();
    }

    @When("goto test automation engineer")
    public void gotoAutomation() {
        navigation.gotoAutomation();
    }

}

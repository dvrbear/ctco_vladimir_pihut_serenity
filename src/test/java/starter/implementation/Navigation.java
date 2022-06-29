package starter.implementation;

import static starter.utils.ConstXpath.*;

public class Navigation extends BasePageObject {

    public void gotoVacancies() {
        hover(MAIN_MENU_CAREERS_XP);
        click(MAIN_MENU_VACANCIES_XP);
    }

    public void gotoAutomation() {
        click(VACANCIES_MENU_AUTOMATION_XP);
    }

}

package starter.implementation;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static starter.utils.Const.LONG_TIMEOUT;

public class BasePageObject extends PageObject {

    public WebDriver driver;
    private WebDriverWait wait;

    public BasePageObject() {
        driver = Serenity.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, LONG_TIMEOUT);
    }

    public void gotoURL(String url) {
        driver.get(url);
    }

    public void click(String xpath) {
        try {
            WebElement element = getElement(xpath);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Actions action = new Actions(driver);
            action.moveToElement(element)
                    .click()
                    .build()
                    .perform();
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void hover(String xpath) {
        try {
            WebElement element = getElement(xpath);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            failWithMessage("Insomnia");
        }
    }

    private WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    private void locatorNotFound(String xpath) {
        failWithMessage(String.format("Locator was not found: [%s]", xpath));
    }

    public void failWithMessage(String message) {
        Assert.fail("> > > > > > > " + message);
    }
}

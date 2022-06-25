package starter.implementation;

import de.taimos.totp.TOTP;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.utils.Const;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static starter.utils.Const.FREE_PLACE_SEARCH_PATTERN;
import static starter.utils.Const.LONG_TIMEOUT;

public class BasePageObject extends PageObject {

    public WebDriver driver;
    private WebDriverWait wait;

    public BasePageObject() {
        driver = Serenity.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, LONG_TIMEOUT);
    }

    public void gotoURL(String url){
        driver.get(url);
    }

    public void initDriver(String baseURL) {
        driver = Serenity.getDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, LONG_TIMEOUT);
    }

    public void clickOnFirstFound(String xpath) {
        try {
            sleep(1);
            click(driver.findElements(By.xpath(xpath)).get(0));
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void click(String xpath) {
        try {
            sleep(2);
            click(getElement(xpath));
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void click(WebElement element) {
        try {
            sleep(1);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Actions action = new Actions(driver);
            action.moveToElement(element)
                    .click()
                    .build()
                    .perform();
        } catch (Exception e) {
            locatorNotFound(element.toString());
        }
    }

    public void timeDrag(String sourceElm, String targetElm){
        sleep(1);
        WebElement startTimeElement = driver.findElement(By.xpath(String.format(Const.HOUR_PATTERN, sourceElm)));
        WebElement endTimeElement = driver.findElement(By.xpath(String.format("//td[contains(@data-time,'%s')]/ancestor::tr[position()=1]/preceding-sibling::tr[position()=1]",targetElm)));
        scroll(startTimeElement);
        Actions builder = new Actions(driver);
        builder.clickAndHold(startTimeElement).build().perform();
        scroll(endTimeElement);
        builder.release(endTimeElement).build().perform();
    }

    public void input(String text, String xpath) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
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

    public void scroll(String xpath) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(xpath));
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void scroll(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            elementNotFound(element.toString());
        }
    }



    public void saveValue(String key, Object value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public Object loadValue(String key) {
        return Serenity.sessionVariableCalled(key);
    }

    public static String otp(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
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

    private void elementNotFound(String str) {
        failWithMessage(String.format("Element was not found: [%s]", str));
    }

    private void locatorNotFound(String xpath) {
        failWithMessage(String.format("Locator was not found: [%s]", xpath));
    }

    public void failWithMessage(String message) {
        Assert.fail("> > > > > > > " + message);
    }
}

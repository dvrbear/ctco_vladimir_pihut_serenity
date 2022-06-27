package starter.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WorkScheduleNav extends BasePageObject{

    public void deselectIfSelected(){
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='selector']/*"));
        for(WebElement e : elements){
            if (e.getAttribute("class").contains("selected")){
                click(e);
            }
        }
    }

    public void selectWorkingDays(){
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='selector']/*"));
        for (int i = 0; i < 5; i++){
            click(elements.get(i));
        }
    }


    public void selectHours(String fromHour, String toHour){
        int fromHourCal = converterTimeToSlideSections(fromHour);
        int toHourCal = converterTimeToSlideSections(toHour);
        WebElement sliderHandler1 = driver.findElement(By.xpath("//span[@data-index='0']"));
        WebElement sliderHandler2 = driver.findElement(By.xpath("//span[@data-index='1']"));
        WebElement sliderBar = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-rail')]"));
        int Handler1Width = sliderHandler1.getSize().getWidth();
        int sliderBarWidth = sliderBar.getSize().getWidth();
        int xCoordsSliderBar = sliderBar.getLocation().getX();
        int xCoordsHandler1 = sliderHandler1.getLocation().getX();
        int Handler1PositionOnBar= xCoordsHandler1 - (xCoordsSliderBar-(Handler1Width/2));
        int Handler2PositionOnBar= sliderBarWidth + xCoordsSliderBar;
        float targetPositionHandler1 = fromHourCal * ((float) (sliderBarWidth) / 47);
        float targetPositionHandler2= (47 - toHourCal) * ((float) (sliderBarWidth) / 47);

        Actions action = new Actions(driver);
        action.dragAndDropBy(sliderHandler1,-Handler1PositionOnBar,0).build().perform();
        action.dragAndDropBy(sliderHandler2,Handler2PositionOnBar,0).build().perform();

        action.dragAndDropBy(sliderHandler1,(int) targetPositionHandler1,0).build().perform();
        action.dragAndDropBy(sliderHandler2,-((int)targetPositionHandler2),0).build().perform();
    }

    private int converterTimeToSlideSections(String time){
        int intAHours = Integer.parseInt((String) time.split("[:]")[0]);
        int intAMinutes= Integer.parseInt((String) time.split("[:]")[1]);
        return intAMinutes == 0 ? intAHours * 2 : (intAHours * 2) +1;
    }

}


package starter.implementation;

import org.junit.Assert;
import org.openqa.selenium.By;

import static starter.utils.ConstXpath.PROFESSIONAL_SKILLS_XP;

public class Verification extends BasePageObject {

    public void verifySkills(int countOfSkills) {
        Assert.assertEquals(
                countOfSkills,
                driver.findElements(By.xpath(PROFESSIONAL_SKILLS_XP)).size());
    }

    public void verifySkillsNegative(int countOfSkills) {
        Assert.assertNotEquals(
                countOfSkills,
                driver.findElements(By.xpath(PROFESSIONAL_SKILLS_XP)).size());
    }

}

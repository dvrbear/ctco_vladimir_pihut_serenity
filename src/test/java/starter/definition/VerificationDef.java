package starter.definition;

import io.cucumber.java.en.Then;
import starter.implementation.Verification;

public class VerificationDef {

    private Verification verification;

    @Then("count of skills should be equal to : {}")
    public void verifySkills(int countOfSkills) {
        verification.verifySkills(countOfSkills);
    }

    @Then("count of skills should not be equal to : {}")
    public void verifySkillsNegative(int countOfSkills) {
        verification.verifySkillsNegative(countOfSkills);
    }

}

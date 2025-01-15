package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.Cucumber_BDD_Testing.appsCommon.StepsImplementation;
import com.chromatech.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ability_To_Enable_After_Disabeling_Student_Steps extends PageInitializer {

    @When("clicks on Disable Student button")
    public void clicks_on_disable_student_button() {
        StepsImplementation.clicks_on_disable_student_button();
    }

    @When("a user enables the student record")
    public void a_user_enables_the_student_record() {
        StepsImplementation.a_user_enables_the_student_record();
    }

    @Then("the student record is successfully enabled")
    public void the_student_record_is_successfully_enabled() {
        CommonMethods.assertTrue(disabledStudentPage.disableButton.isDisplayed());
    }
}
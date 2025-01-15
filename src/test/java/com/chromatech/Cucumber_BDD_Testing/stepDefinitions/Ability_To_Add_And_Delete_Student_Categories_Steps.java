package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import io.cucumber.java.en.Then;

public class Ability_To_Add_And_Delete_Student_Categories_Steps extends PageInitializer {

    @Then("user clicks on student information submodule")
    public void user_clicks_on_student_information_submodule() {
        dashboardPage.studentInformationModule.click();
    }
}
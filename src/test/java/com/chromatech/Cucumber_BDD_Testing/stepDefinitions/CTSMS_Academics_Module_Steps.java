package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.Cucumber_BDD_Testing.appsCommon.StepsImplementation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CTSMS_Academics_Module_Steps extends PageInitializer {

    @When("the user clicks on the Academics Module")
    public void the_user_clicks_on_the_academics_module() {
        dashboardPage.academicsModule.click();
    }

    @Then("the following submodules are displayed: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_following_submodules_are_displayed(String classTimetable, String teachersTimetable, String assignClassTeacher, String promoteStudent, String subjectGroup, String subjects, String classClass, String sections) {
        StepsImplementation.the_following_submodules_are_displayed(classTimetable, teachersTimetable, assignClassTeacher, promoteStudent, subjectGroup, subjects, classClass, sections);
    }
}
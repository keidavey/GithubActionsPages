package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.pages.DashboardPage;
import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.CucumberLogUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Homework_Module_Steps {

    DashboardPage dashboardPage = new DashboardPage();

    @Given("the user clicks on the Homework module")
    public void the_user_clicks_on_the_homework_module() {
        dashboardPage.homeworkModule.click();
    }

    @Then("the {string} module displays")
    public void the_module_displays(String addHomework) {
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(dashboardPage.addHomeworkSubModule.getText(), addHomework);
    }
}
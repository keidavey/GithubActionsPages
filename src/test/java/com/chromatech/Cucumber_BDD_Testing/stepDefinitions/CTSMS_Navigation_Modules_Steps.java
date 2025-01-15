package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.Cucumber_BDD_Testing.appsCommon.StepsImplementation;
import io.cucumber.java.en.Then;

public class CTSMS_Navigation_Modules_Steps extends PageInitializer {

    @Then("the following modules are displayed: {string}, {string} , {string} , {string} , {string} , {string} , {string} , {string}")
    public void the_following_modules_are_displayed(String studentInformation, String feesCollection, String Income, String expenses, String academics, String humanResource, String homework, String reports) {
        StepsImplementation.the_following_modules_are_displayed(studentInformation, feesCollection, Income, expenses, academics, humanResource, homework, reports);
    }
}
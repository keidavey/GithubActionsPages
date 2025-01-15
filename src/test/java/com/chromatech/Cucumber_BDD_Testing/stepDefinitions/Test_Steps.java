package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.chromatech.utils.WebDriverUtils;

public class Test_Steps extends PageInitializer {

    @Given("the user is on {string}")
    public void the_user_is_on(String googleUrl) {
        WebDriverUtils.driver.get(googleUrl);
    }

    @When("the user enters some text")
    public void the_user_enters_some_text() {
        googlePage.searchBox.sendKeys("Cucumber");
    }

    @Then("the text is entered")
    public void the_text_is_entered() {
        CommonMethods.assertEquals(googlePage.searchBox.getText(), "Cucumber");
    }
}

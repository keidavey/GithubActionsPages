package com.cicd.Cucumber_BDD_Testing.stepDefinitions;

import com.cicd.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.cicd.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.cicd.utils.WebDriverUtils;
import java.time.Duration;

public class Test_Steps extends PageInitializer {
    String text = "Cucumber";

    @Given("the user is on {string}")
    public void the_user_is_on(String googleUrl) {
        WebDriverUtils.driver.get(googleUrl);
    }

    @When("the user enters some text")
    public void the_user_enters_some_text() {
        googlePage.searchBox.sendKeys(text);
    }

    @Then("the text is entered")
    public void the_text_is_entered() {
        WebDriverUtils.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String enteredText = googlePage.searchBox.getAttribute("value");
        CommonMethods.assertEquals(enteredText, text);
    }
}

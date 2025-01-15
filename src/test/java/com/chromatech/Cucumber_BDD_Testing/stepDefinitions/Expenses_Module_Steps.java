package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.pages.DashboardPage;
import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.CucumberLogUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Expenses_Module_Steps {

    DashboardPage dashboardPage = new DashboardPage();

    @When("the user clicks on the Expenses module")
    public void the_user_clicks_on_the_expenses_module() {
        dashboardPage.expensesModule.click();
    }

    @Then("the following submodules are displayed {string}, {string}, {string}")
    public void the_following_submodules_are_displayed(String addExpense, String searchExpense, String expenseHead) {
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(dashboardPage.addExpenseSubModule.getText(), addExpense);
        CommonMethods.assertEquals(dashboardPage.searchExpenseSubModule.getText(), searchExpense);
        CommonMethods.assertEquals(dashboardPage.expenseHeadSubModule.getText(), expenseHead);
    }
}
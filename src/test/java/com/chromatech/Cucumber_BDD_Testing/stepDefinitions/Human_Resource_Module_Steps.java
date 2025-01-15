package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.pages.DashboardPage;
import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.CucumberLogUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Human_Resource_Module_Steps {

    DashboardPage dashboardPage = new DashboardPage();

    @When("the user clicks on the Human Resource module")
    public void the_user_clicks_on_the_human_resource_module() {
        dashboardPage.humanResourceModule.click();
    }

    @Then("the following submodules are displayed {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_following_submodules_are_displayed(String staffDirectory, String staffAttendance, String payRoll, String approveLeaveRequest, String applyLeave, String leaveType, String teachersRating, String department, String designation) {
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(dashboardPage.staffDirectorySubModule.getText(), staffDirectory);
        CommonMethods.assertEquals(dashboardPage.staffAttendanceSubModule.getText(), staffAttendance);
        CommonMethods.assertEquals(dashboardPage.payrollSubModule.getText(), payRoll);
        CommonMethods.assertEquals(dashboardPage.approveLeaveRequestSubModule.getText(), approveLeaveRequest);
        CommonMethods.assertEquals(dashboardPage.applyLeaveSubModule.getText(), applyLeave);
        CommonMethods.assertEquals(dashboardPage.leaveTypeSubModule.getText(), leaveType);
        CommonMethods.assertEquals(dashboardPage.teachersRatingSubModule.getText(), teachersRating);
        CommonMethods.assertEquals(dashboardPage.departmentSubModule.getText(), department);
        CommonMethods.assertEquals(dashboardPage.designationSubModule.getText(), designation);
    }
}
package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.Cucumber_BDD_Testing.appsCommon.StepsImplementation;
import com.chromatech.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class_And_Sections_Steps extends PageInitializer {

    @When("the user navigates to the Class submodule")
    public void the_user_navigates_to_the_class_submodule() {
        StepsImplementation.the_user_navigates_to_the_class_submodule();
    }

    @Then("there are two classes, SDET and Cyber Security displayed with the following sections:")
    public void there_are_two_classes_sdet_and_cyber_security_displayed_with_the_following_sections(DataTable expectedClassesTable) {
        CommonMethods.dataTableVsTable(expectedClassesTable, classesPage.classesTable, "div");
    }
}

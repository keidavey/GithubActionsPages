package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.Cucumber_BDD_Testing.appsCommon.StepsImplementation;
import io.cucumber.java.en.Then;

public class Student_Admission_With_Unique_Admission_Number_Steps extends PageInitializer {

    @Then("the user should see {string}")
    public void the_user_should_see(String expectedAdmissionNoUniqueValueMessage) {
        StepsImplementation.the_user_should_see(expectedAdmissionNoUniqueValueMessage);
    }

    @Then("navigate to test student {string}, {string}, {string}")
    public void navigate_to_test_student(String classOption, String sectionOption, String admissionNo) {
        StepsImplementation.navigate_to_test_student(classOption, sectionOption, admissionNo);
    }
}
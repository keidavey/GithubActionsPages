package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.pages.BulkDeletePage;
import com.chromatech.Cucumber_BDD_Testing.pages.DashboardPage;
import com.chromatech.Cucumber_BDD_Testing.pages.StudentDetailsPage;
import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.JavascriptMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verifying_Student_Data_Steps {

    StudentDetailsPage studentDetailsPage = new StudentDetailsPage();
    DashboardPage dashboardPage = new DashboardPage();
    BulkDeletePage bulkDeletePage = new BulkDeletePage();

    @When("a student has been admitted with {string} and {string}")
    public void a_student_has_been_admitted_with_and_(String admissionNo, String studentFullName) {
        dashboardPage.studentDetailsSubModule.click();
        studentDetailsPage.searchByKeywordTextBox.sendKeys(admissionNo);
        studentDetailsPage.searchByKeywordButton.click();
        CommonMethods.assertEquals(StudentDetailsPage.dynamicAdmissionRecordNameLocator(admissionNo).getText(), studentFullName);
    }

    @And("an admin navigates to a student record with {string}")
    public void an_admin_navigates_to_a_student_record(String admissionNo) {
        StudentDetailsPage.dynamicAdmissionRecordNameLocator(admissionNo).click();
    }

    @Then("all data submitted with the record should display as expected {string}, {string}, {string}, {string}, {string} {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void allDataSubmittedWithTheRecordShouldDisplayAsExpected(String admissionNo, String rollNumber, String classOption, String sectionOption, String fullName, String gender, String dateOfBirth, String category, String email, String admissionDate, String bloodGroup, String asOnDate, String mobileNumber, String height, String weight, String fatherName, String fatherPhone, String fatherOccupation, String motherName, String motherPhone, String motherOccupation, String guardianEmail, String guardianAddress) {
        CommonMethods.assertEquals(StudentDetailsPage.dynamicNameRecordLocator(fullName).getText(), fullName);
        StudentDetailsPage.boxProfileInformation(admissionNo, rollNumber, classOption, sectionOption, "No", gender);
        StudentDetailsPage.profileTabInformation(admissionDate, dateOfBirth, category, email, mobileNumber, height, weight, fatherName, fatherPhone, fatherOccupation, motherName, motherPhone, motherOccupation, motherName, guardianEmail, "Mother", motherPhone, motherOccupation, guardianAddress, bloodGroup, asOnDate);
    }

    @And("find record on the bulk delete page with {string}, {string}, {string}")
    public void findRecordOnTheBulkDeletePageWith(String classOption, String sectionOption, String admissionNo) {
        bulkDeletePage.bulkDeleteSubModule.click();
        CommonMethods.selectDropDownValue(classOption, bulkDeletePage.classDropDown);
        CommonMethods.selectDropDownValue(sectionOption, bulkDeletePage.sectionDropDown);
        bulkDeletePage.searchButton.click();
        JavascriptMethods.scrollIntoView(BulkDeletePage.dynamicRecordLocateDeleter(admissionNo));
    }
}
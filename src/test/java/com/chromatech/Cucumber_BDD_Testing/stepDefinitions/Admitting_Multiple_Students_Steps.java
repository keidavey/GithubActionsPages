package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.Cucumber_BDD_Testing.appsCommon.StepsImplementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Admitting_Multiple_Students_Steps extends PageInitializer {

    @And("verifies a student with {string} is not an existing student")
    public void verifies_a_student_with_is_not_an_existing_student(String admissionNo) {
        StepsImplementation.verifies_a_student_with_is_not_an_existing_student(admissionNo);
    }

    @Given("verifies a sibling with {string} is not an existing student")
    public void verifies_a_sibling_with_is_not_an_existing_student(String siblingAdmissionNO) {
        StepsImplementation.verifies_a_sibling_with_is_not_an_existing_student(siblingAdmissionNO);
    }

    @And("creates a test category {string}")
    public void creates_a_test_category(String categoryName) {
        StepsImplementation.creates_a_test_category(categoryName);
    }

    @When("a CTSMS admin or faculty member is on the student admission page {string}")
    public void a_ctsms_admin_or_faculty_member_is_on_the_student_admission_page(String expectedAdmissionPageUrl) {
        StepsImplementation.a_ctsms_admin_or_faculty_member_is_on_the_student_admission_page(expectedAdmissionPageUrl);
    }

    @And("creates a test sibling with admission number {string}, class {string}, section {string}, first name {string}, gender {string}, date of birth {string}, guardian name {string}, guardian phone number {string}")
    public void creates_a_test_sibling_with_admission_number_class_section_first_name_gender_date_of_birth_guardian_name_guardian_phone_number(String admissionNo, String classOption, String sectionOption, String firstName, String genderOption, String dateOfBirth, String guardianName, String guardianPhoneNumber) {
        StepsImplementation.creates_a_test_sibling_with_admission_number_class_section_first_name_gender_date_of_birth_guardian_name_guardian_phone_number(admissionNo, classOption, sectionOption, firstName, genderOption, dateOfBirth, guardianName, guardianPhoneNumber);
    }

    @And("adds a sibling")
    public void adds_a_sibling() {
        StepsImplementation.adds_a_sibling();
    }

    @And("the user fills out all fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_fills_out_all_fields(String admissionNo, String rollNumber, String classOption, String sectionOption, String firstName, String lastName, String genderOption, String dateOfBirth, String categoryOption, String email, String admissionDate, String bloodGroupOption, String asOnDate, String mobileNumber, String height, String weight, String fatherName, String fatherPhone, String fatherOccupation, String motherName, String motherPhone, String motherOccupation, String guardianEmail, String guardianAddress) {
        StepsImplementation.the_user_fills_out_all_fields(admissionNo, rollNumber, classOption, sectionOption, firstName, lastName, genderOption, dateOfBirth, categoryOption, email, admissionDate, bloodGroupOption, asOnDate, mobileNumber, height, weight, fatherName, fatherPhone, fatherOccupation, motherName, motherPhone, motherOccupation, guardianEmail, guardianAddress);
    }

    @And("uploads family member photos")
    public void uploads_family_member_photos() {
        StepsImplementation.uploads_family_member_photos();
    }

    @And("clicks the Add More Details button")
    public void clicks_the_add_more_details_button() {
        studentAdmissionPage.addMoreDetailsBox.click();
    }

    @And("adds Student Address Details")
    public void adds_student_address_details() {
        StepsImplementation.adds_student_address_details();
    }

    @And("adds Miscellaneous Details {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void adds_miscellaneous_details(String bankAccountNumber, String bankName, String ifscCode, String nationalIDNumber, String localIDNumber, String previousSchoolDetails, String note) {
        StepsImplementation.adds_miscellaneous_details(bankAccountNumber, bankName, ifscCode, nationalIDNumber, localIDNumber, previousSchoolDetails, note);
    }

    @And("uploads documents {string}, {string}, {string}, {string}")
    public void uploads_documents(String titleOne, String titleTwo, String titleThree, String titleFour) {
        StepsImplementation.uploads_documents(titleOne, titleTwo, titleThree, titleFour);
    }

    @When("clicks save")
    public void clicks_save() {
        studentAdmissionPage.saveButton.click();
    }

    @Then("the user should be able to admit students with unique admission numbers {string}, {string}, {string}")
    public void the_user_should_be_able_to_admit_students_with_unique_admission_numbers(String classOption, String sectionOption, String admissionNo) {
        StepsImplementation.the_user_should_be_able_to_admit_students_with_unique_admission_numbers(classOption, sectionOption, admissionNo);
    }

    @And("delete test account with {string}")
    public void delete_test_account_with(String admissionNo) {
        StepsImplementation.delete_test_account_with(admissionNo);
    }

    @And("delete test sibling account with admission number {string}")
    public void delete_test_sibling_account_with_admission_number_with_class_section(String admissionNo) {
        StepsImplementation.delete_test_sibling_account_with_admission_number_with_class_section(admissionNo);
    }

    @Then("delete the test category")
    public void delete_the_test_category() {
        StepsImplementation.delete_the_test_category();
    }
}
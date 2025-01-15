package com.chromatech.Cucumber_BDD_Testing.appsCommon;

import com.chromatech.Cucumber_BDD_Testing.Constants.AppConstants;
import com.chromatech.Cucumber_BDD_Testing.pages.BulkDeletePage;
import com.chromatech.Cucumber_BDD_Testing.pages.StudentDetailsPage;
import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.CucumberLogUtils;
import com.chromatech.utils.JavascriptMethods;
import static com.chromatech.utils.CommonMethods.assertEquals;
import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.NoSuchElementException;

public class StepsImplementation extends PageInitializer {

    /**
     * Fills out all the required fields with the provided values such as admission number, class section,
     * first name, gender, date of birth, guardian name, and guardian phone number.
     *
     * @param admissionNo         The admission number of the student.
     * @param classOption         The class option of the student.
     * @param sectionOption       The section option of the student.
     * @param firstName           The first name of the student.
     * @param genderOption        The gender option of the student.
     * @param dateOfBirth         The date of birth of the student.
     * @param guardianName        The guardian name of the student.
     * @param guardianPhoneNumber The guardian phone number of the student.
     */
    public static void fills_out_all_required_fields_with_admission_number_class_section_first_name_gender_date_of_birth_guardian_name_guardian_phone_number(String admissionNo, String classOption, String sectionOption, String firstName, String genderOption, String dateOfBirth, String guardianName, String guardianPhoneNumber) {
        studentAdmissionPage.admissionNoTextBox.sendKeys(admissionNo);
        CommonMethods.selectDropDownValue(classOption, studentAdmissionPage.classDropDown);
        CommonMethods.selectDropDownValue(sectionOption, studentAdmissionPage.sectionDropDown);
        studentAdmissionPage.firstNameTextBox.sendKeys(firstName);
        CommonMethods.selectDropDownValue(genderOption, studentAdmissionPage.genderDropDown);
        JavascriptMethods.selectDateByJS(studentAdmissionPage.dateOfBirthTextBox, dateOfBirth);
        studentAdmissionPage.fatherRadioButton.click();
        studentAdmissionPage.guardianNameTextBox.sendKeys(guardianName);
        studentAdmissionPage.guardianPhoneTextBox.sendKeys(guardianPhoneNumber);
        studentAdmissionPage.saveButton.click();
        CommonMethods.waitForVisibility(studentAdmissionPage.studentSavedSuccessfullyAlert);
    }

    /**
     * Adds a section by entering the section name in the section text box and clicking the save button.
     */
    public static void the_user_adds_a_section(String section) {
        addAndDeleteSectionsPage.sectionTextBox.sendKeys(section);
        addAndDeleteSectionsPage.clickSaveButton.click();
    }

    /**
     * This method adds a section and verifies if the section is successfully added.
     */
    public static void the_section_is_added() {
        CommonMethods.sleep(1000);
        CommonMethods.assertTrue(addAndDeleteSectionsPage.successMessage.isDisplayed());
    }

    /**
     * Deletes the section by clicking the delete button and accepting the confirmation alert.
     */
    public static void the_user_can_also_delete_the_section() {
        addAndDeleteSectionsPage.deleteButton.click();
    }

    /**
     * Navigates the user to the class submodule in the academics module of the dashboard.
     */
    public static void the_user_navigates_to_the_class_submodule() {
        dashboardPage.academicsModule.click();
        dashboardPage.classClassSubModule.click();
    }

    /**
     * Navigates the user to the test student in the bulk delete submodule.
     *
     * @param classOption   The class option of the student.
     * @param sectionOption The section option of the student.
     * @param admissionNo   The admission number of the student.
     */
    public static void navigate_to_test_student(String classOption, String sectionOption, String admissionNo) {
        bulkDeletePage.bulkDeleteSubModule.click();
        CommonMethods.selectDropDownValue(classOption, bulkDeletePage.classDropDown);
        CommonMethods.selectDropDownValue(sectionOption, bulkDeletePage.sectionDropDown);
        bulkDeletePage.searchButton.click();
        JavascriptMethods.scrollIntoView(BulkDeletePage.dynamicRecordLocateDeleter(admissionNo));
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(BulkDeletePage.dynamicRecordNameLocator(admissionNo).getText(), admissionNo);
    }

    /**
     * The user should see the specified message for the admission number uniqueness.
     *
     * @param expectedAdmissionNoUniqueValueMessage The expected message for the admission number uniqueness.
     */
    public static void the_user_should_see(String expectedAdmissionNoUniqueValueMessage) {
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(studentAdmissionPage.admissionNoUniqueValueMessage.getText(), expectedAdmissionNoUniqueValueMessage);
    }

    /**
     * Opens a student record with the given admission number.
     *
     * @param admissionNo The admission number of the student.
     */
    public static void a_ctsms_user_opens_a_student_record_with_admission_number(String admissionNo) {
        dashboardPage.studentDetailsSubModule.click();
        studentDetailsPage.searchByKeywordTextBox.sendKeys(admissionNo);
        studentDetailsPage.searchByKeywordButton.click();
        JavascriptMethods.scrollIntoView(StudentDetailsPage.dynamicAdmissionRecordNameLocator(admissionNo));
        StudentDetailsPage.dynamicAdmissionRecordNameLocator(admissionNo).click();
    }

    /**
     * Makes and saves changes to the student information with the provided email and guardian phone number.
     *
     * @param email               The email to be entered for the student.
     * @param guardianPhoneNumber The guardian phone number to be entered for the student.
     */
    public static void makes_and_saves_changes_to_the_student_information_with(String email, String
            guardianPhoneNumber) {
        studentEditPage.editButton.click();
        studentEditPage.emailTextBox.sendKeys(email);
        studentEditPage.guardianPhoneNumberTextBox.sendKeys(guardianPhoneNumber);
        CommonMethods.sleep(1000);
        studentEditPage.saveButton.click();
    }

    /**
     * Verifies that the user sees the expected save message.
     *
     * @param expectedSaveMessage The expected save message.
     */
    public static void the_user_should_see_message(String expectedSaveMessage) {
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(studentDetailsPage.successfulRecordUpdateAlert.getText(), expectedSaveMessage);
    }

    /**
     * Navigates the user to the test students account in the bulk delete submodule.
     *
     * @param classOption   The class option of the student's account.
     * @param sectionOption The section option of the student's account.
     * @param admissionNo   The admission number of the student's account.
     */
    public static void user_navigate_to_test_students_account(String classOption, String sectionOption, String
            admissionNo) {
        bulkDeletePage.bulkDeleteSubModule.click();
        CommonMethods.selectDropDownValue(classOption, bulkDeletePage.classDropDown);
        CommonMethods.selectDropDownValue(sectionOption, bulkDeletePage.sectionDropDown);
        bulkDeletePage.searchButton.click();
        JavascriptMethods.scrollIntoView(BulkDeletePage.dynamicRecordLocateDeleter(admissionNo));
    }

    /**
     * Verifies if a student with the given admission number is not an existing student.
     *
     * @param admissionNo The admission number of the student to be verified.
     */
    public static void verifies_a_student_with_is_not_an_existing_student(String admissionNo) {
        dashboardPage.studentInformationModule.click();
        bulkDeletePage.bulkDeleteSubModule.click();
        bulkDeletePage.classDropDown.click();
        bulkDeletePage.sectionDropDown.click();
        bulkDeletePage.searchButton.click();
        try {
            JavascriptMethods.scrollIntoView(BulkDeletePage.dynamicRecordLocateDeleter(admissionNo));
            if ((BulkDeletePage.dynamicRecordLocateDeleter(admissionNo).isDisplayed())) {
                BulkDeletePage.dynamicRecordLocateDeleter(admissionNo).click();
                bulkDeletePage.deleteButton.click();
                CommonMethods.acceptAlert();
            }
        } catch (NoSuchElementException e) {
        }
    }

    /**
     * Verifies if a sibling with the given admission number is not an existing student.
     *
     * @param siblingAdmissionNO The admission number of the sibling to be verified.
     */
    public static void verifies_a_sibling_with_is_not_an_existing_student(String siblingAdmissionNO) {
        try {
            JavascriptMethods.scrollIntoView(BulkDeletePage.dynamicRecordLocateDeleter(siblingAdmissionNO));
            if ((BulkDeletePage.dynamicRecordLocateDeleter(siblingAdmissionNO).isDisplayed())) {
                BulkDeletePage.dynamicRecordLocateDeleter(siblingAdmissionNO).click();
                bulkDeletePage.deleteButton.click();
                CommonMethods.acceptAlert();
            }
        } catch (NoSuchElementException e) {
        }
    }

    /**
     * Creates a test category with the provided category name.
     *
     * @param categoryName The name of the category to be created.
     */
    public static void creates_a_test_category(String categoryName) {
        CommonMethods.sleep(1000);
        categoryPage.studentCategories.click();
        categoryPage.categoryTextBox.sendKeys(categoryName);
        categoryPage.categorySaveButton.click();
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(categoryPage.categorySelenium.getText(), categoryName);
    }

    /**
     * Performs the action of navigating an admin or faculty member to the student admission page and verifies if the page URL matches the expected one.
     *
     * @param expectedAdmissionPageUrl The expected URL of the student admission page.
     */
    public static void a_ctsms_admin_or_faculty_member_is_on_the_student_admission_page(String
                                                                                                expectedAdmissionPageUrl) {
        dashboardPage.studentAdmissionSubModule.click();
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(WebDriverUtils.driver.getCurrentUrl(), expectedAdmissionPageUrl);
    }

    /**
     * Creates a test sibling with the provided admission number, class section, first name, gender, date of birth, guardian name, and guardian phone number.
     *
     * @param admissionNo         The admission number of the sibling.
     * @param classOption         The class section of the sibling.
     * @param sectionOption       The section option of the sibling.
     * @param firstName           The first name of the sibling.
     * @param genderOption        The gender option of the sibling.
     * @param dateOfBirth         The date of birth of the sibling.
     * @param guardianName        The guardian name of the sibling.
     * @param guardianPhoneNumber The guardian phone number of the sibling.
     */
    public static void creates_a_test_sibling_with_admission_number_class_section_first_name_gender_date_of_birth_guardian_name_guardian_phone_number
    (String admissionNo, String classOption, String sectionOption, String firstName, String genderOption, String
            dateOfBirth, String guardianName, String guardianPhoneNumber) {
        CommonMethods.waitForVisibility(studentAdmissionPage.admissionNoTextBox);
        studentAdmissionPage.admissionNoTextBox.sendKeys(admissionNo);
        CommonMethods.selectDropDownValue(classOption, studentAdmissionPage.classDropDown);
        CommonMethods.selectDropDownValue(sectionOption, studentAdmissionPage.sectionDropDown);
        studentAdmissionPage.firstNameTextBox.sendKeys(firstName);
        CommonMethods.selectDropDownValue(genderOption, studentAdmissionPage.genderDropDown);
        JavascriptMethods.selectDateByJS(studentAdmissionPage.dateOfBirthTextBox, dateOfBirth);
        studentAdmissionPage.fatherRadioButton.click();
        studentAdmissionPage.guardianNameTextBox.sendKeys(guardianName);
        studentAdmissionPage.guardianPhoneTextBox.sendKeys(guardianPhoneNumber);
        studentAdmissionPage.saveButton.click();
    }

    /**
     * Adds a sibling to the student admission page.
     * This method performs the following steps:
     * 1. Sleeps for 1 second.
     * 2. Clicks on the add sibling button.
     * 3. Waits for the sibling class drop-down to be visible.
     * 4. Selects a value from the sibling class drop-down.
     * 5. Selects a value from the sibling section drop-down.
     * 6. Selects a value from the sibling student ID drop-down.
     * 7. Clicks on the add sibling information button.
     */
    public static void adds_a_sibling() {
        CommonMethods.sleep(1000);
        studentAdmissionPage.addSiblingButton.click();
        CommonMethods.waitForVisibility(studentAdmissionPage.siblingClassDropDown);
        CommonMethods.selectDropDownValue("SDET", studentAdmissionPage.siblingClassDropDown);
        CommonMethods.selectDropDownValue("Cucumber Fundamentals", studentAdmissionPage.siblingSectionDropDown);
        CommonMethods.selectDropDownValue("Group Three Sibling ()", studentAdmissionPage.siblingStudentIDDropDown);
        studentAdmissionPage.addSiblingInformationButton.click();
    }

    /**
     * Fills out all the fields on the student admission page with the provided values.
     *
     * @param admissionNo      The admission number of the student.
     * @param rollNumber       The roll number of the student.
     * @param classOption      The class option of the student.
     * @param sectionOption    The section option of the student.
     * @param firstName        The first name of the student.
     * @param lastName         The last name of the student.
     * @param genderOption     The gender option of the student.
     * @param dateOfBirth      The date of birth of the student.
     * @param categoryOption   The category option of the student.
     * @param email            The email of the student.
     * @param admissionDate    The admission date of the student.
     * @param bloodGroupOption The blood group option of the student.
     * @param asOnDate         The "as-on" date of the student.
     * @param mobileNumber     The mobile number of the student.
     * @param height           The height of the student.
     * @param weight           The weight of the student.
     * @param fatherName       The father's name of the student.
     * @param fatherPhone      The father's phone number of the student.
     * @param fatherOccupation The father's occupation of the student.
     * @param motherName       The mother's name of the student.
     * @param motherPhone      The mother's phone number of the student.
     * @param motherOccupation The mother's occupation of the student.
     * @param guardianEmail    The guardian's email of the student.
     * @param guardianAddress  The guardian's address of the student.
     */
    public static void the_user_fills_out_all_fields(String admissionNo, String rollNumber, String
            classOption, String sectionOption, String firstName, String lastName, String genderOption, String
                                                             dateOfBirth, String categoryOption, String email, String admissionDate, String bloodGroupOption, String
                                                             asOnDate, String mobileNumber, String height, String weight, String fatherName, String fatherPhone, String
                                                             fatherOccupation, String motherName, String motherPhone, String motherOccupation, String guardianEmail, String
                                                             guardianAddress) {
        studentAdmissionPage.admissionNoTextBox.sendKeys(admissionNo);
        studentAdmissionPage.rollNumberTextBox.sendKeys(rollNumber);
        CommonMethods.selectDropDownValue(classOption, studentAdmissionPage.classDropDown);
        CommonMethods.selectDropDownValue(sectionOption, studentAdmissionPage.sectionDropDown);
        studentAdmissionPage.firstNameTextBox.sendKeys(firstName);
        studentAdmissionPage.lastNameTextBox.sendKeys(lastName);
        CommonMethods.selectDropDownValue(genderOption, studentAdmissionPage.genderDropDown);
        JavascriptMethods.selectDateByJS(studentAdmissionPage.dateOfBirthTextBox, dateOfBirth);
        CommonMethods.selectDropDownValue(categoryOption, studentAdmissionPage.categoryDropDown);
        studentAdmissionPage.emailTextBox.sendKeys(email);
        JavascriptMethods.selectDateByJS(studentAdmissionPage.admissionDateTextBox, admissionDate);
        CommonMethods.selectDropDownValue(bloodGroupOption, studentAdmissionPage.bloodGroupDropDown);
        JavascriptMethods.selectDateByJS(studentAdmissionPage.asOnDate, asOnDate);
        studentAdmissionPage.mobileNumberTextBox.sendKeys(mobileNumber);
        studentAdmissionPage.heightTextBox.sendKeys(height);
        studentAdmissionPage.weightTextBox.sendKeys(weight);
        studentAdmissionPage.fatherNameTextBox.sendKeys(fatherName);
        studentAdmissionPage.fatherPhoneTextBox.sendKeys(fatherPhone);
        studentAdmissionPage.fatherOccupationTextBox.sendKeys(fatherOccupation);
        studentAdmissionPage.motherNameTextBox.sendKeys(motherName);
        studentAdmissionPage.motherPhoneTextBox.sendKeys(motherPhone);
        studentAdmissionPage.motherOccupationTextBox.sendKeys(motherOccupation);
        studentAdmissionPage.motherRadioButton.click();
        studentAdmissionPage.guardianEmailTextBox.sendKeys(guardianEmail);
        studentAdmissionPage.guardianAddressTextBox.sendKeys(guardianAddress);
    }

    /**
     * Uploads family member photos.
     * This method performs the following steps:
     * 1. The student photo is selected and the photo filepath is provided.
     * 2. The father photo is selected and the photo filepath is provided.
     * 3. The mother photo is selected and the photo filepath is provided.
     * 4. The guardian photo is selected and the photo filepath is provided.
     */
    public static void uploads_family_member_photos() {
        studentAdmissionPage.studentPhoto.sendKeys(AppConstants.photoFilepath);
        studentAdmissionPage.fatherPhoto.sendKeys(AppConstants.photoFilepath);
        studentAdmissionPage.motherPhoto.sendKeys(AppConstants.photoFilepath);
        studentAdmissionPage.guardianPhoto.sendKeys(AppConstants.photoFilepath);
    }

    /**
     * Adds the address details for a student on the student admission page.
     * This method performs the following steps:
     * 1. Clicks on the guardian address checkbox.
     * 2. Logs a screenshot.
     * 3. Asserts that the guardian address textbox value is the same as the current address textbox value.
     * 4. Clicks on the permanent address checkbox.
     * 5. Logs a screenshot.
     * 6. Asserts that the permanent address textbox value is the same as the current address textbox value.
     */
    public static void adds_student_address_details() {
        studentAdmissionPage.guardianAddressCheckBox.click();
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(studentAdmissionPage.guardianAddressTextBox.getText(), studentAdmissionPage.currentAddressTextBox.getText());
        studentAdmissionPage.permanentAddressCheckBox.click();
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(studentAdmissionPage.permanentAddressTextBox.getText(), studentAdmissionPage.currentAddressTextBox.getText());
    }

    /**
     * Adds miscellaneous details to the student admission page.
     *
     * @param bankAccountNumber     The bank account number of the student.
     * @param bankName              The name of the bank.
     * @param ifscCode              The IFSC code of the bank.
     * @param nationalIDNumber      The national ID number of the student.
     * @param localIDNumber         The local ID number of the student.
     * @param previousSchoolDetails The details of the student's previous school.
     * @param note                  Additional note or comment.
     */
    public static void adds_miscellaneous_details(String bankAccountNumber, String bankName, String
            ifscCode, String nationalIDNumber, String localIDNumber, String previousSchoolDetails, String note) {
        studentAdmissionPage.bankAccountNumberTextBox.sendKeys(bankAccountNumber);
        studentAdmissionPage.bankNameTextBox.sendKeys(bankName);
        studentAdmissionPage.ifscCodeTextBox.sendKeys(ifscCode);
        studentAdmissionPage.nationalIDNumberTextBox.sendKeys(nationalIDNumber);
        studentAdmissionPage.localIDNumberTextBox.sendKeys(localIDNumber);
        studentAdmissionPage.rteYesButton.click();
        studentAdmissionPage.previousSchoolDetailsTextBox.sendKeys(previousSchoolDetails);
        studentAdmissionPage.noteTextBox.sendKeys(note);
    }

    /**
     * Uploads multiple documents for student admission.
     *
     * @param titleOne   The title of the first document.
     * @param titleTwo   The title of the second document.
     * @param titleThree The title of the third document.
     * @param titleFour  The title of the fourth document.
     */
    public static void uploads_documents(String titleOne, String titleTwo, String titleThree, String titleFour) {
        studentAdmissionPage.titleOneTextBox.sendKeys(titleOne);
        studentAdmissionPage.titleTwoTextBox.sendKeys(titleTwo);
        studentAdmissionPage.titleThreeTextBox.sendKeys(titleThree);
        studentAdmissionPage.titleFourTextBox.sendKeys(titleFour);
        studentAdmissionPage.documentOne.sendKeys(AppConstants.photoFilepath);
        studentAdmissionPage.documentTwo.sendKeys(AppConstants.photoFilepath);
        studentAdmissionPage.documentThree.sendKeys(AppConstants.photoFilepath);
        studentAdmissionPage.documentFour.sendKeys(AppConstants.photoFilepath);
    }

    /**
     * The user should be able to admit students with unique admission numbers.
     *
     * @param classOption   the class option for filtering students
     * @param sectionOption the section option for filtering students
     * @param admissionNo   the admission number of the student to admit
     */
    public static void the_user_should_be_able_to_admit_students_with_unique_admission_numbers(String classOption, String sectionOption, String admissionNo) {
        bulkDeletePage.bulkDeleteSubModule.click();
        CommonMethods.selectDropDownValue(classOption, bulkDeletePage.classDropDown);
        CommonMethods.selectDropDownValue(sectionOption, bulkDeletePage.sectionDropDown);
        bulkDeletePage.searchButton.click();
        CucumberLogUtils.logScreenShot();
        CommonMethods.assertEquals(BulkDeletePage.dynamicRecordNameLocator(admissionNo).getText(), admissionNo);
    }

    /**
     * Deletes a test account with the given admission number.
     *
     * @param admissionNo the admission number of the test account to be deleted
     */
    public static void delete_test_account_with(String admissionNo) {
        BulkDeletePage.dynamicRecordLocateDeleter(admissionNo).click();
        bulkDeletePage.deleteButton.click();
        CommonMethods.acceptAlert();
    }

    /**
     * Asserts that the following submodules are displayed on the dashboard page.
     *
     * @param classTimetable     The expected text for the class timetable submodule.
     * @param teachersTimetable  The expected text for the teachers timetable submodule.
     * @param assignClassTeacher The expected text for the assign class teacher submodule.
     * @param promoteStudent     The expected text for the promote student submodule.
     * @param subjectGroup       The expected text for the subject group submodule.
     * @param subjects           The expected text for the subjects submodule.
     * @param classClass         The expected text for the class class submodule.
     * @param sections           The expected text for the sections submodule.
     */
    public static void the_following_submodules_are_displayed(String classTimetable, String teachersTimetable, String assignClassTeacher, String promoteStudent, String subjectGroup, String subjects, String classClass, String sections) {
        assertEquals(classTimetable, dashboardPage.classTimetableSubModule.getText());
        assertEquals(teachersTimetable, dashboardPage.teachersTimetableSubModule.getText());
        assertEquals(assignClassTeacher, dashboardPage.assignClassTeacherSubModule.getText());
        assertEquals(promoteStudent, dashboardPage.promoteStudentSubModule.getText());
        assertEquals(subjectGroup, dashboardPage.subjectGroupSubModule.getText());
        assertEquals(subjects, dashboardPage.subjectsSubModule.getText());
        assertEquals(classClass, dashboardPage.classClassSubModule.getText());
        assertEquals(sections, dashboardPage.sectionsSubModule.getText());
    }

    /**
     * Asserts that the following modules are displayed on the dashboard page.
     *
     * @param studentInformation The expected text for the student information module.
     * @param feesCollection     The expected text for the fees collection module.
     * @param Income             The expected text for the income module.
     * @param expenses           The expected text for the expenses module.
     * @param academics          The expected text for the academics module.
     * @param humanResource      The expected text for the human resource module.
     * @param homework           The expected text for the homework module.
     * @param reports            The expected text for the reports module.
     */
    public static void the_following_modules_are_displayed(String studentInformation, String feesCollection, String Income, String expenses, String academics, String humanResource, String homework, String reports) {
        CommonMethods.assertEquals(dashboardPage.studentInformationModule.getText(), studentInformation);
        CommonMethods.assertEquals(dashboardPage.feesCollectionModule.getText(), feesCollection);
        CommonMethods.assertEquals(dashboardPage.incomeModule.getText(), Income);
        CommonMethods.assertEquals(dashboardPage.expensesModule.getText(), expenses);
        CommonMethods.assertEquals(dashboardPage.academicsModule.getText(), academics);
        CommonMethods.assertEquals(dashboardPage.humanResourceModule.getText(), humanResource);
        CommonMethods.assertEquals(dashboardPage.homeworkModule.getText(), homework);
        CommonMethods.assertEquals(dashboardPage.reportsModule.getText(), reports);
    }

    /**
     * Asserts that the following submodules are displayed on the dashboard page.
     *
     * @param studentDetails    The expected text for the student details submodule.
     * @param studentAdmission  The expected text for the student admission submodule.
     * @param disabledStudents  The expected text for the disabled students submodule.
     * @param bulkDelete        The expected text for the bulk delete submodule.
     * @param studentCategories The expected text for the student categories submodule.
     * @param studentHouse      The expected text for the student house submodule.
     * @param disableReason     The expected text for the disable reason submodule.
     */
    public static void the_following_submodules_are_displayed(String studentDetails, String studentAdmission, String disabledStudents, String bulkDelete, String studentCategories, String studentHouse, String disableReason) {
        assertEquals(studentDetails, dashboardPage.studentDetailsSubModule.getText());
        assertEquals(studentAdmission, dashboardPage.studentAdmissionSubModule.getText());
        assertEquals(disabledStudents, dashboardPage.disabledStudentsSubModule.getText());
        assertEquals(bulkDelete, dashboardPage.bulkDeleteSubModule.getText());
        assertEquals(studentCategories, dashboardPage.studentCategoriesSubModule.getText());
        assertEquals(studentHouse, dashboardPage.studentHouseSubModule.getText());
        assertEquals(disableReason, dashboardPage.disableReasonSubModule.getText());
    }

    /**
     * Deletes the test sibling account with the given admission number and class section.
     *
     * @param admissionNo The admission number of the test sibling account.
     */
    public static void delete_test_sibling_account_with_admission_number_with_class_section(String admissionNo) {
        CommonMethods.sleep(1000);
        JavascriptMethods.scrollIntoView(BulkDeletePage.dynamicRecordLocateDeleter(admissionNo));
        CucumberLogUtils.logScreenShot();
        CommonMethods.waitForVisibility(BulkDeletePage.dynamicRecordNameLocator(admissionNo));
        CommonMethods.waitForClickability(BulkDeletePage.dynamicRecordNameLocator(admissionNo));
        CommonMethods.assertEquals(BulkDeletePage.dynamicRecordNameLocator(admissionNo).getText(), admissionNo);
        BulkDeletePage.dynamicRecordLocateDeleter(admissionNo).click();
        bulkDeletePage.deleteButton.click();
        CommonMethods.acceptAlert();
    }

    /**
     * Deletes the test category.
     * This method deletes the test category by performing the following steps:
     * 1. Sleeps for 1000 milliseconds to allow the page to load.
     * 2. Clicks on the student categories button on the category page.
     * 3. Clicks on the group Selenium category.
     * 4. Accepts the alert dialog box that appears.
     */
    public static void delete_the_test_category() {
        CommonMethods.sleep(1000);
        categoryPage.studentCategories.click();
        categoryPage.groupSelenium.click();
        CommonMethods.acceptAlert();
    }

    /**
     * Clicks on Disable button
     * 1.Clicks disable button to disable student
     * 2.Accepts alert dialog box that appears
     * 3.Clicks on reason dropdown
     * 4.Selects "Very Loud" from dropdown when text is visible
     * 5.Clicks on submit button
     */
    public static void clicks_on_disable_student_button() {
        disabledStudentPage.disableButton.click();
        CommonMethods.acceptAlert();
        disabledStudentPage.reasonDropdown.click();
        CommonMethods.selectDropDownValue("Very Loud", disabledStudentPage.reasonDropdown);
        disabledStudentPage.submitButton.click();
    }

    /**
     * Clicks on Enable button
     * 1.Clicks on enable button to enable student
     * 2.Accepts alert dialog box that appears
     */
    public static void a_user_enables_the_student_record() {
        disabledStudentPage.enableButton.click();
        CommonMethods.acceptAlert();
    }

    public static void Ability_To_Add_And_Delete_Student_Categories_Steps() {
        dashboardPage.studentInformationModule.click();
    }
}
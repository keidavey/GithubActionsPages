package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAdmissionPage {

    public StudentAdmissionPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /* ADMISSION NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='admission_no']")
    public WebElement admissionNoTextBox;

    /* ROLL NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='roll_no']")
    public WebElement rollNumberTextBox;

    /* CLASS SELECT DROPDOWN */
    @FindBy(xpath = "//select[@id='class_id']")
    public WebElement classDropDown;

    /* SECTION DROPDOWN */
    @FindBy(xpath = "//select[@id='section_id']")
    public WebElement sectionDropDown;

    /* FIRST NAME TEXT BOX */
    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameTextBox;

    /* LAST NAME TEXT BOX */
    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameTextBox;

    /* GENDER DROPDOWN */
    @FindBy(xpath = "//select[@name='gender']")
    public WebElement genderDropDown;

    /* THE DATE OF BIRTH TEXT BOX */
    @FindBy(xpath = "//input[@id='dob']")
    public WebElement dateOfBirthTextBox;

    /* CATEGORY DROPDOWN */
    @FindBy(xpath = "//select[@id='category_id']")
    public WebElement categoryDropDown;

    /* EMAIL TEXT BOX */
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBox;

    /* ADMISSION DATE TEXT BOX */
    @FindBy(xpath = "//input[@id='admission_date']")
    public WebElement admissionDateTextBox;

    /* BLOOD GROUP DROPDOWN */
    @FindBy(xpath = "//select[@name='blood_group']")
    public WebElement bloodGroupDropDown;

    /* AS ON DATE DATEPICKER */
    @FindBy(xpath = "//input[@id='measure_date']")
    public WebElement asOnDate;

    /* MOBILE NUMBER TEXT BOX */
    @FindBy(xpath = "(//input[@type='number'])[1]")
    public WebElement mobileNumberTextBox;

    /* HEIGHT TEXT BOX */
    @FindBy(xpath = "//label[normalize-space()='Height']/following-sibling::input")
    public WebElement heightTextBox;

    /* WEIGHT TEXT BOX */
    @FindBy(xpath = "//label[normalize-space()='Weight']/following-sibling::input")
    public WebElement weightTextBox;

    /* FATHER NAME TEXT BOX */
    @FindBy(xpath = "//input[@id='father_name']")
    public WebElement fatherNameTextBox;

    /* FATHER PHONE NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='father_phone']")
    public WebElement fatherPhoneTextBox;

    /* FATHER RADIO BUTTON */
    @FindBy(xpath = "//input[@value='father']")
    public WebElement fatherRadioButton;

    /* FATHER OCCUPATION TEXT BOX */
    @FindBy(xpath = "//input[@id='father_occupation']")
    public WebElement fatherOccupationTextBox;

    /* MOTHER NAME TEXT BOX */
    @FindBy(xpath = "//input[@id='mother_name']")
    public WebElement motherNameTextBox;

    /* MOTHER PHONE NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='mother_phone']")
    public WebElement motherPhoneTextBox;

    /* MOTHER OCCUPATION TEXT BOX */
    @FindBy(xpath = "//input[@id='mother_occupation']")
    public WebElement motherOccupationTextBox;

    /* MOTHER RADIO BUTTON */
    @FindBy(xpath = "//input[@value='mother']")
    public WebElement motherRadioButton;

    /* GUARDIAN NAME TEXT BOX */
    @FindBy(xpath = "//input[@id='guardian_name']")
    public WebElement guardianNameTextBox;

    /* GUARDIAN EMAIL TEXT BOX */
    @FindBy(xpath = "//input[@id='guardian_email']")
    public WebElement guardianEmailTextBox;

    /* GUARDIAN PHONE NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='guardian_phone']")
    public WebElement guardianPhoneTextBox;

    /* GUARDIAN OCCUPATION TEXT BOX */
    @FindBy(xpath = "//input[@id='guardian_occupation']")
    public WebElement guardianOccupationTextBox;

    /* GUARDIAN ADDRESS TEXT BOX */
    @FindBy(xpath = "//textarea[@id='guardian_address']")
    public WebElement guardianAddressTextBox;

    /* STUDENT PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "(//input[@id='file'])[1]")
    public WebElement studentPhoto;

    /* FATHER PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "(//input[@id='file'])[2]")
    public WebElement fatherPhoto;

    /* MOTHER PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "(//input[@id='file'])[3]")
    public WebElement motherPhoto;

    /* GUARDIAN PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "(//input[@id='file'])[4]")
    public WebElement guardianPhoto;

    /* ADD MORE DETAILS BAR */
    @FindBy(xpath = "//a[normalize-space()='Add More Details']")
    public WebElement addMoreDetailsBox;

    /* GUARDIAN ADDRESS CHECK BOX */
    @FindBy(xpath = "//input[@id='autofill_current_address']")
    public WebElement guardianAddressCheckBox;

    /* PERMANENT ADDRESS CHECK BOX */
    @FindBy(xpath = "//input[@id='autofill_address']")
    public WebElement permanentAddressCheckBox;

    /* CURRENT ADDRESS CHECK BOX */
    @FindBy(xpath = "//textarea[@id='current_address']")
    public WebElement currentAddressTextBox;

    /* PERMANENT ADDRESS TEXT BOX */
    @FindBy(xpath = "//textarea[@id='permanent_address']")
    public WebElement permanentAddressTextBox;

    /* BANK ACCOUNT NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='bank_account_no']")
    public WebElement bankAccountNumberTextBox;

    /* BANK NAME TEXT BOX */
    @FindBy(xpath = "//input[@id='bank_name']")
    public WebElement bankNameTextBox;

    /* IFSC CODE TEXT BOX */
    @FindBy(xpath = "//input[@id='ifsc_code']")
    public WebElement ifscCodeTextBox;

    /* NATIONAL ID NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='adhar_no']")
    public WebElement nationalIDNumberTextBox;

    /* LOCAL ID NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='samagra_id']")
    public WebElement localIDNumberTextBox;

    /* RTE 'YES' RADIO BUTTON */
    @FindBy(xpath = "//input[@value='Yes']")
    public WebElement rteYesButton;

    /* PREVIOUS SCHOOL DETAILS TEXT BOX */
    @FindBy(xpath = "//textarea[@name='previous_school']")
    public WebElement previousSchoolDetailsTextBox;

    /* NOTE TEXT BOX */
    @FindBy(xpath = "//textarea[@name='note']")
    public WebElement noteTextBox;

    /* TITLE ONE TEXT BOX */
    @FindBy(xpath = "//input[@name='first_title']")
    public WebElement titleOneTextBox;

    /* TITLE ONE PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "//input[@name='first_doc']")
    public WebElement documentOne;

    /* TITLE TWO TEXT BOX */
    @FindBy(xpath = "//input[@name='second_title']")
    public WebElement titleTwoTextBox;

    /* TITLE TWO PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "//input[@name='second_doc']")
    public WebElement documentTwo;

    /* TITLE THREE TEXT BOX */
    @FindBy(xpath = "//input[@name='fourth_title']")
    public WebElement titleThreeTextBox;

    /* TITLE THREE PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "//input[@name='fourth_doc']")
    public WebElement documentThree;

    /* TITLE FOUR TEXT BOX */
    @FindBy(xpath = "//input[@name='fifth_title']")
    public WebElement titleFourTextBox;

    /* TITLE FOUR PHOTO UPLOAD ELEMENT */
    @FindBy(xpath = "//input[@name='fifth_doc']")
    public WebElement documentFour;

    /* ADD SIBLING BUTTON */
    @FindBy(xpath = "//button[normalize-space()='Add Sibling']")
    public WebElement addSiblingButton;

    /* ADD SIBLING CLASS DROPDOWN */
    @FindBy(xpath = "//select[@id='sibiling_class_id']")
    public WebElement siblingClassDropDown;

    /* ADD SIBLING SECTION DROPDOWN */
    @FindBy(xpath = "//select[@id='sibiling_section_id']")
    public WebElement siblingSectionDropDown;

    /* ADD SIBLING STUDENT ID DROPDOWN */
    @FindBy(xpath = "//select[@id='sibiling_student_id']")
    public WebElement siblingStudentIDDropDown;

    /* ADD SIBLING ADD INFORMATION BUTTON */
    @FindBy(xpath = "//button[@id='load']")
    public WebElement addSiblingInformationButton;

    /* SAVE BUTTON */
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Save']")
    public WebElement saveButton;

    /* SAVED SUCCESSFULLY ALERT */
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement studentSavedSuccessfullyAlert;

    /* ADMISSION NO UNIQUE VALUE MESSAGE */
    @FindBy(xpath = "//p[contains(text(),'The Admission No field must contain a unique value')]")
    public WebElement admissionNoUniqueValueMessage;
}
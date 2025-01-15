package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class StudentDetailsPage {

    public StudentDetailsPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /* SEARCH BY KEYWORD TEXT BOX */
    @FindBy(xpath = "(//input[@name='search_text'])[2]")
    public WebElement searchByKeywordTextBox;

    /* SEARCH BY KEYWORD BUTTON */
    @FindBy(xpath = "//button[@value='search_full']")
    public WebElement searchByKeywordButton;

    /**
     * Locates the dynamic admission record WebElement based on the given admission number.
     * The admission number is used to generate an XPath that searches for a table cell (td) containing
     * the admission number and following the parent chain to find the corresponding edit link.
     *
     * @param admission the admission number to search for
     * @return the WebElement representing the edit link for the admission record
     */
    public static WebElement dynamicAdmissionRecordNameLocator(String admission) {
        return WebDriverUtils.driver.findElement(By.xpath("//td[contains(text(),'" + admission + "')]//parent::tr//td[2]/a"));
    }

    /* SUCCESSFUL RECORD UPDATE ALERT */
    @FindBy(xpath = "//div[@class='alert alert-success']/div[contains(text(), 'Record Update Successfully')]")
    public WebElement successfulRecordUpdateAlert;

    /**
     * Locates the dynamic name record WebElement based on the given student name.
     *
     * @param studentName the student name to search for
     * @return the WebElement representing the name record
     */
    public static WebElement dynamicNameRecordLocator(String studentName) {
        return WebDriverUtils.driver.findElement(By.xpath("//h3[@class='profile-username text-center'][normalize-space()='" + studentName + "']"));
    }

    /**
     * This method is used to validate and verify the profile information in a box format.
     * It takes the admission number, roll number, class, section, RTE, and gender as input parameters.
     * The method retrieves the profile information elements from the web page and compares them with the input parameters.
     * If the values match, the assertion will pass, otherwise it will fail.
     *
     * @param admissionNo   the admission number of the student
     * @param rollNumber    the roll number of the student
     * @param classOption   the class of the student
     * @param sectionOption the section of the student
     * @param rte           the RTE (Right to Education) status of the student
     * @param gender        the gender of the student
     */
    public static void boxProfileInformation(String admissionNo, String rollNumber, String classOption, String sectionOption, String rte, String gender) {
        String[] boxProfileInformationArray = {admissionNo, rollNumber, classOption + " (2020-21)", sectionOption, rte, gender};
        List<WebElement> boxProfileInformationElements = WebDriverUtils.driver.findElements(By.xpath("//ul[@class='list-group list-group-unbordered']/li/a"));
        for (int i = 0; i < boxProfileInformationElements.size(); i++) {
            System.out.println(boxProfileInformationElements.get(i).getText());
            System.out.println(boxProfileInformationArray[i]);
            CommonMethods.assertTrue(boxProfileInformationElements.get(i).getText().equalsIgnoreCase(boxProfileInformationArray[i]));
        }
    }

    /**
     * This method validates and verifies the profile information displayed in a tab format.
     * It takes various profile information as input parameters and compares them with the corresponding elements on the web page.
     * If all the values match, the method passes the assertion and returns void.
     * Otherwise, it fails the assertion.
     *
     * @param admissionDate      the admission date of the student
     * @param dateOfBirth        the date of birth of the student
     * @param category           the category of the student
     * @param email              the email address of the student
     * @param mobileNumber       the mobile number of the student
     * @param height             the height of the student
     * @param weight             the weight of the student
     * @param fatherName         the father's name of the student
     * @param fatherPhone        the father's phone number of the student
     * @param fatherOccupation   the father's occupation of the student
     * @param motherName         the mother's name of the student
     * @param motherPhone        the mother's phone number of the student
     * @param motherOccupation   the mother's occupation of the student
     * @param guardianName       the guardian's name of the student
     * @param guardianEmail      the guardian's email address of the student
     * @param guardianRelation   the guardian's relation with the student
     * @param guardianPhone      the guardian's phone number of the student
     * @param guardianOccupation the guardian's occupation of the student
     * @param guardianAddress    the guardian's address of the student
     * @param bloodGroup         the blood group of the student
     * @param asOnDate           the date as of which the profile information is checked
     */
    public static void profileTabInformation(String admissionDate, String dateOfBirth, String category, String email, String mobileNumber, String height, String weight, String fatherName, String fatherPhone, String fatherOccupation, String motherName, String motherPhone, String motherOccupation, String guardianName, String guardianEmail, String guardianRelation, String guardianPhone, String guardianOccupation, String guardianAddress, String bloodGroup, String asOnDate) {
        String[] profileTabInformation = {admissionDate, dateOfBirth, category, email, mobileNumber, height, weight, fatherName, fatherPhone, fatherOccupation, motherName, motherPhone, motherOccupation, guardianName, guardianEmail, guardianRelation, guardianPhone, guardianOccupation, guardianAddress, bloodGroup, asOnDate};
        List<WebElement> profileTabInformationElements = WebDriverUtils.driver.findElements(By.xpath("//div[@class='tab-content']//tr/td[2][normalize-space()]"));
        for (int i = 0; i < profileTabInformationElements.size(); i++) {
            CommonMethods.assertTrue(profileTabInformationElements.get(i).getText().equalsIgnoreCase(profileTabInformation[i]));
        }
    }
}
package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentEditPage {

    public StudentEditPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /* EMAIL TEXT BOX */
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBox;

    /* GUARDIAN PHONE NUMBER TEXT BOX */
    @FindBy(xpath = "//input[@id='guardian_phone']")
    public WebElement guardianPhoneNumberTextBox;

    /* SAVE BUTTON */
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Save']")
    public WebElement saveButton;

    /* EDIT BUTTON */
    @FindBy(xpath = "//a[contains(@href, 'student/edit')]")
    public WebElement editButton;
}
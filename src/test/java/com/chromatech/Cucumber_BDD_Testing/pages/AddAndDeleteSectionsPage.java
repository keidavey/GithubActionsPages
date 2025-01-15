package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAndDeleteSectionsPage {

    public AddAndDeleteSectionsPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /**
     * sectionTextBox is a WebElement
     */
    @FindBy(xpath = "//input[@id='section']")
    public WebElement sectionTextBox;

    /**
     * Represents the save button element on the AddAndDeleteSectionsPage.
     */
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Save']")
    public WebElement clickSaveButton;

    /**
     * Represents the delete button element on the AddAndDeleteSectionsPage.
     */
    @FindBy(xpath = "//tbody/tr/td[1][contains(text(), 'TESTING MD')]")
    public WebElement deleteButton;

    /**
     * Represents the successful measure alert
     */
    @FindBy(xpath = "//div[contains(text(),'Record Saved Successfully')]")
    public WebElement successMessage;
}
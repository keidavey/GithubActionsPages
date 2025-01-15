package com.chromatech.Cucumber_BDD_Testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /**
    * Represents the username text box on the login page.
     */
    @FindBy(xpath = "//input[@id='form-username']")
    public WebElement usernameTextBox;

    /**
     * Represents the password text box on the login page.
     */
    @FindBy(xpath = "//input[@id='form-password']")
    public WebElement passwordTextBox;

    /**
     * Represents the Sign In button on the login page.
     */
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    /**
     * Represents the error message element on the login page.
     */
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement errorMessage;

    /**
     * Represents the navigation element in the web page.
     */
    @FindBy(xpath = "//nav[@role='navigation']")
    public WebElement navigation;
}
package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    public CategoryPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /* STUDENT CATEGORIES SUB MODULE  */
    @FindBy(xpath = "//a[normalize-space()='Student Categories']")
    public WebElement studentCategories;

    /* CATEGORY TEXT BOX */
    @FindBy(xpath = "//input[@id='category']")
    public WebElement categoryTextBox;

    /* CATEGORY SAVE BUTTON */
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Save']")
    public WebElement categorySaveButton;

    /* SELENIUM CATEGORY TABLE CELL */
    @FindBy(xpath = "//td[normalize-space()='Selenium']")
    public WebElement categorySelenium;

    /* SELENIUM CATEGORY DELETE BUTTON */
    @FindBy(xpath = "//td[normalize-space()='Selenium']/parent::tr/td[3]/a[2]")
    public WebElement groupSelenium;
}
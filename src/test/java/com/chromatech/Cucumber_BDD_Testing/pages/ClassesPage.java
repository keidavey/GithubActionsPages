package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClassesPage {

    public ClassesPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /* CLASSES TABLE */
    @FindBy(xpath = "//table[@role='grid']")
    public WebElement classesTable;
}

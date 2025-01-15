package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingExpensePage {
    public AddingExpensePage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /*CLICKING EXPENSE TEXT*/
    @FindBy(xpath = "//span[contains(text(),'Expenses')]")
    public WebElement expenseModuleText;

    /*CLICKING EXPENSES HEAD*/
    @FindBy(xpath = "//a[normalize-space()='Expense Head']")
    public WebElement addingExpenseHead;

    /*USER ENTERS ADDING EXPENSE HEAD*/
    @FindBy(xpath = "//input[@id='expensehead']")
    public WebElement expenseHeadBox;

    /*USER ENTERS IN THE DESCRIPTION BOX*/
    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement expenseHeadDescriptionBox;

    /*EXPENSE HEAD BUTTON*/
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Save']")
    public WebElement expenseHeadSavebutton;

    /*CLICKING ADD EXPENSE MODULE TEXT*/
    @FindBy(xpath = "(//a[normalize-space()='Add Expense'])[2]")
    public WebElement addExpenseModuleText;

    /*CLICKING ADD EXPENSE MODULE TEXT*/
    @FindBy(xpath = "//select[@id='exp_head_id']")
    public WebElement expenseHeadSelectDropdown;

    /*USER ENTERS THE NAME*/
    @FindBy(xpath = "//input[@id='name']")
    public WebElement expenseNameBox;

    /*USER ENTERS THE INVOICE NUMBER*/
    @FindBy(xpath = "//input[@id='invoice_no']")
    public WebElement expenseInvoiceNumberBox;

    /*USER ENTERS THE EXPENSE AMOUNT*/
    @FindBy(xpath = "//input[@id='amount']")
    public WebElement expenseAmount;

    /*USER ENTERS THE DESCRIPTION*/
    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement expenseDescriptionBox;

    /*USER CLICKS SAVE IN THE AD EXPENSE PAGE*/
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Save']")
    public WebElement expenseSaveButton;

    /*CLICK SEARCH PAGE*/
    @FindBy(xpath = "//a[normalize-space()='Search Expense']")
    public WebElement searchExpensePageButton;

    /*SEARCH BY NAME IN THE SEARCH BOX*/
    @FindBy(xpath = "//input[@placeholder='Search by Expense']")
    public WebElement searchExpenseBox;

    /*CLICK SEARCH BUTTON*/
    @FindBy(xpath = "//button[@value='search_full']")
    public WebElement searchExpenseSearchButton;

    /*FIND THE EXPENSE*/
    @FindBy(xpath = "//td[normalize-space()='Group 3']/ancestor::tr")
    public WebElement searchExpenseResult;

    /*DELETE EXPENSE*/
    @FindBy(xpath = "//a[normalize-space()='Group 3']/ancestor::tr/td/a[2]")
    public WebElement deleteExpense;
}
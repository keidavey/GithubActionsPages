package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }

    /**
     * Represents the Human Resource module WebElement on the login page.
     */
    @FindBy(xpath = "//span[normalize-space()='Human Resource']")
    public WebElement humanResourceModule;

    /**
     * Represents the WebElement for the Staff Directory link on the Dashboard page.
     */
    @FindBy(xpath = "//ul[contains(@class,'treeview-menu menu-open')]//a[normalize-space()='Staff Directory']")
    public WebElement staffDirectorySubModule;

    /**
     * Represents the WebElement for the Staff Attendance link on the Dashboard page.
     */
    @FindBy(xpath = "//ul[contains(@class,'treeview-menu menu-open')]//a[normalize-space()='Staff Attendance']")
    public WebElement staffAttendanceSubModule;

    /**
     * Represents the WebElement for the Payroll link on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Payroll']")
    public WebElement payrollSubModule;

    /**
     * Represents the WebElement for the ApproveLeaveRequest link on Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Approve Leave Request']")
    public WebElement approveLeaveRequestSubModule;

    /**
     * Represents the WebElement for the Apply Leave link on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Apply Leave']")
    public WebElement applyLeaveSubModule;

    /**
     * Represents the WebElement for the Leave Type link on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Leave Type']")
    public WebElement leaveTypeSubModule;

    /**
     * Represents the WebElement for the Teachers Rating link on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Teachers Rating']")
    public WebElement teachersRatingSubModule;

    /**
     * Represents the Department link WebElement in the DashboardPage class.
     */
    @FindBy(xpath = "//a[normalize-space()='Department']")
    public WebElement departmentSubModule;

    /**
     * Represents the Designation link WebElement in the DashboardPage class.
     */
    @FindBy(xpath = "//a[normalize-space()='Designation']")
    public WebElement designationSubModule;

    /**
     * Represents the WebElement for the Homework module on the Dashboard page.
     */
    @FindBy(xpath = "//span[normalize-space()='Homework']")
    public WebElement homeworkModule;

    /**
     * Represents the WebElement for the Add Homework link on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Add Homework']")
    public WebElement addHomeworkSubModule;

    /**
     * Represents the WebElement for the Student Information module on the Dashboard page
     */
    @FindBy(xpath = "//span[normalize-space()='Student Information']")
    public WebElement studentInformationModule;

    /**
     * Represents the WebElement for the Student Admission submodule on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Student Admission']")
    public WebElement studentAdmissionSubModule;

    /**
     * Represents the WebElement for the Fees Collection module on the Dashboard page.
     */
    @FindBy(xpath = "//span[normalize-space()='Fees Collection']")
    public WebElement feesCollectionModule;

    /**
     * Represents the WebElement for the "Income" module on the DashboardPage.
     */
    @FindBy(xpath = "//span[normalize-space()='Income']")
    public WebElement incomeModule;

    /**
     * Represents the WebElement for the Income module in the Dashboard page.
     */
    @FindBy(xpath = "//span[normalize-space()='Expenses']")
    public WebElement expensesModule;

    /**
     * The academicsModule variable represents
     */
    @FindBy(xpath = "//span[normalize-space()='Academics']")
    public WebElement academicsModule;

    /**
     * Represents a WebElement object for the "Reports" module on the Dashboard page.
     */
    @FindBy(xpath = "//span[normalize-space()='Reports']")
    public WebElement reportsModule;

    /**
     * This variable represents a WebElement for the class timetable sub-module link on the Dashboard page.
     */
    @FindBy(xpath = "(//a[normalize-space()='Class Timetable'])[2]")
    public WebElement classTimetableSubModule;

    /**
     * Represents the WebElement for the "Teachers Timetable" sub-module in the DashboardPage class.
     */
    @FindBy(xpath = "//a[normalize-space()='Teachers Timetable']")
    public WebElement teachersTimetableSubModule;

    /**
     * This variable represents the web element for the "Assign Class Teacher" sub-module in the Dashboard Page.
     */
    @FindBy(xpath = "//a[normalize-space()='Assign Class Teacher']")
    public WebElement assignClassTeacherSubModule;

    /**
     * Represents the web element for the "Promote Students" sub-module.
     */
    @FindBy(xpath = "//a[normalize-space()='Promote Students']")
    public WebElement promoteStudentSubModule;

    /**
     * The Subject Group sub-module is located on the Dashboard page and can be accessed by clicking on a link
     * with the text "Subject Group".
     */
    @FindBy(xpath = "//a[normalize-space()='Subject Group']")
    public WebElement subjectGroupSubModule;

    /**
     * This variable represents the WebElement for the "Subjects" sub-module in the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Subjects']")
    public WebElement subjectsSubModule;

    /**
     * Represents a WebElement for the class sub-module on a DashboardPage.
     */
    @FindBy(xpath = "//a[normalize-space()='Class']")
    public WebElement classClassSubModule;

    /**
     * This variable represents the sections submodule WebElement on the Dashboard Page.
     */
    @FindBy(xpath = "//a[normalize-space()='Sections']")
    public WebElement sectionsSubModule;

    /**
     * Represents the WebElement for the Add Expense on the Dashboard page.
     */
    @FindBy(xpath = "//ul[contains(@class,'treeview-menu menu-open')]//a[normalize-space()='Add Expense']")
    public WebElement addExpenseSubModule;

    /**
     * Represents the WebElement for the Search Expense on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Search Expense']")
    public WebElement searchExpenseSubModule;

    /**
     * Represents the WebElement for the Expense Head on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Expense Head']")
    public WebElement expenseHeadSubModule;

    /**
     * Represents the WebElement for the Student Details submodule on the Dashboard page
     */
    @FindBy(xpath = "//ul[@class='treeview-menu']//a[normalize-space()='Student Details']")
    public WebElement studentDetailsSubModule;

    /**
     * This variable represents the WebElement for the "Disabled Students" sub-module on the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Disabled Students']")
    public WebElement disabledStudentsSubModule;

    /**
     * This variable represents the WebElement for the "Bulk Delete" link in the DashboardPage class.
     */
    @FindBy(xpath = "//a[normalize-space()='Bulk Delete']")
    public WebElement bulkDeleteSubModule;

    /**
     * WebElement representing the "Student Categories" sub-module in the Dashboard page.
     */
    @FindBy(xpath = "//a[normalize-space()='Student Categories']")
    public WebElement studentCategoriesSubModule;

    /**
     * Represents the WebElement for the "Student House" sub-module on the DashboardPage
     */
    @FindBy(xpath = "//a[normalize-space()='Student House']")
    public WebElement studentHouseSubModule;

    /**
     * WebElement representing the "Disable Reason" sub module in the DashboardPage.
     */
    @FindBy(xpath = "//a[normalize-space()='Disable Reason']")
    public WebElement disableReasonSubModule;
}
package com.chromatech.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods extends WebDriverUtils {

    /**
     * Use this method in need of clicking on a WebElement by selenium WebDriver.
     *
     * @param element Pass the desired WebElement to be clicked.
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    /**
     * Use this method in need of entering value to a text box through selenium
     * WebDriver.
     *
     * @param element Pass the element to which the text needs to be entered.
     * @param value   Pass the desired text/value in the second parameter.
     */
    public static void sendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    /**
     * Use this method in need of entering keyboard keys into a WebElement by
     * selenium WebDriver.
     *
     * @param element     Pass the element to which the key needs to be entered.
     * @param keyboardKey Pass the desired keyboardKey to be entered to an element.
     */
    public static void sendKeys(WebElement element, Keys keyboardKey) {
        element.sendKeys(keyboardKey);
    }

    /**
     * Use this method in need of retrieving the text of an element through selenium
     * WebDriver.
     *
     * @param element Pass the element from which the text to be retrieved.
     * @return This method returns a string object.
     */
    public static String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Use this over loaded method in need of selecting an element of dropDown by
     * VisbleText.
     *
     * @param dropDownElement Pass the WebElement of the desired dropDown.
     * @param ValueOfDropDown Pass the Visible text of DropDown to be selected.
     */
    public static void selectDropDownValue(String VisibleTextOfDD, WebElement dropDownWebEl) {
        Select select = new Select(dropDownWebEl);
        select.selectByVisibleText(VisibleTextOfDD);
    }

    /**
     * Use this over loaded method in need of selecting an element of dropDown by
     * Value.
     *
     * @param dropDownElement Pass the value to be selected.
     * @param ValueOfDropDown Pass the WebElement of the dropDown.
     */
    public static void selectDropDownValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Use this over loaded method in need of selecting an element of dropDown by
     * index.
     *
     * @param dropDownElement      WebElement of the dropDown.
     * @param indexOfDropDownValue Pass the index
     */
    public static void selectDropDownValue(WebElement dropDownElement, int index) {
        Select select = new Select(dropDownElement);
        select.selectByIndex(index);
    }

    /**
     * Use this method to get first selected option of a select drop down
     *
     * @param dropDown
     * @return
     */
    public static String getFirstSelectedOption(WebElement dropDown) {
        Select select = new Select(dropDown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return firstSelectedOption.getText();
    }

    /**
     * Use this method to return a boolean for drop downs containing multiple
     * selections
     *
     * @param element
     * @return
     */
    public static boolean isMultiple(WebElement element) {
        Select select = new Select(element);
        return select.isMultiple();
    }

    /**
     * Use this method to retrieve all options of a Select drop down as a
     * List<String>
     *
     * @param element
     * @return
     */
    public static List<String> getOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        List<String> optionTexts = new ArrayList<>();

        for (WebElement option : allOptions) {
            optionTexts.add(option.getText());
        }
        return optionTexts;
    }

    /**
     * this method will accept the alert
     *
     * @throws will throw NoAlertExeption if alert is not present.
     */
    public static void acceptAlert() {

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert is not present");
        }
    }

    /**
     * this method will dismiss the alert
     *
     * @throws will throw NoAlertExeption if alert is not present.
     */
    public static void dismissAlert() {

        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert is not present");
        }
    }

    /**
     * this method will get the alert text
     *
     * @throws will throw NoAlertExeption if alert is not present.
     */
    public static String getAlertText() {

        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert is not present");
            return null;
        }
    }

    /**
     * This method will switch to the frame
     *
     * @param nameOrId
     */
    public static void switchToFrame(String nameOrId) {

        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            System.out.println("Frame is not present.");
        }
    }

    /**
     * use this method in need of switching to the frame
     *
     * @param element
     */
    public static void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            System.out.println("Frame is not present.");
        }
    }

    /**
     * This method will switch to the frame
     *
     * @param index
     */
    public static void switchToFrame(int index) {

        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            System.out.println("Frame is not present.");
        }
    }

    /**
     * This method will determine if element is present on ui or not.
     *
     * @param element
     * @return
     */
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method will determine if the element is enabled or disabled.
     *
     * @param element
     * @return
     */
    public static boolean isElementEnabled(WebElement element) {
        try {
            return (element.isDisplayed() && element.isEnabled());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method will block until the element corresponding to the given
     * {@code id} can be clicked in the page or {@code timeOut} whichever is
     * earlier.
     */
    public static void waitUntilElemtTobeClickableById(Duration timeOut, String id) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    /**
     * This method will block until the element corresponding to the given
     * {@code id} can be clicked in the page or {@code timeOut} whichever is
     * earlier.
     */
    public static void waitUntilElemtTobeClickableByXpath(Duration timeOut, String xpathExcpression) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExcpression)));
    }

    /**
     * Use this method in need of waiting for 30s for an element based on
     * availability of elementToBeSelected.
     *
     * @param element Pass the WebElement on which synchronization to be applied.
     * @return This method will return boolean type either True or False.
     */
    public static WebElement waitForThePresenceOfEl(String element, Duration timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(element))));
    }

    /**
     * This method will create an Object of WebDriverWait
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }

    /**
     * This method will wait until element becomes clickable
     *
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will wait until element becomes visible
     *
     * @param element
     */
    public static void waitForVisibility(WebElement element) {
        getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method will wait until element becomes invisible
     *
     * @param element
     */
    public static void waitForInvisibility(WebElement element) {
        getWaitObject().until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * This method will select the specified day from the specified calendar table
     *
     * @param table
     * @param day
     */
    public static void selectDateFromTable(WebElement table, String day) {
        List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
        List<WebElement> cells = new ArrayList<>();
        boolean daySelected = false;
        for (WebElement row : rows) {
            if (row.getText().contains(day)) {
                cells = row.findElements(By.xpath("./td/a"));
                break;
            }
        }
        for (WebElement cell : cells) {
            if (cell.getText().equals(day)) {
                JavascriptMethods.clickByJS(cell);
                daySelected = true;
                break;
            }
        }
        if (!daySelected) {
            System.out.println("The specified day could not be selected from the calendar.");
        }
    }

    /**
     * Use this method in need of removing all characters except Alphabets
     *
     * @param yourValue
     * @return Will return the updated value
     */
    public static String getAlphabiticCharactersOnly(String yourValue) {
        return yourValue.replaceAll("[^a-zA-Z]", "");
    }

    /**
     * Use this method in need of removing all characters except Numbers
     *
     * @param yourValue
     * @return Will return the updated value
     */
    public static String getNumChrtr(String yourValue) {
        return yourValue.replaceAll("[^0-9]", "");
    }

    /**
     * Use this method to select a drop down value from a bootstrap drop down menu
     * when Select class will not work NOTE: Before using, first you must click on
     * the drop down, then store elements in a list
     */
    public static void selectValueFromBootStrapDropDown(WebElement bootstrapDropDown, List<WebElement> values,
                                                        String value) {

        bootstrapDropDown.click();

        for (WebElement dropDownValues : values) {
            if (dropDownValues.getText().contentEquals(value)) {
                dropDownValues.click();
                break;
            }
        }
    }

    /**
     * Use this method to pass an email concatenated with current date and time into
     * an email text box
     */
    public static String getEmail() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String email = formatter.format(ts).toString();
        email = email.replaceAll("[^A-Za-z0-9]", "");
        email = ("test") + email + ("@email.com");
        return email;
    }

    /**
     * Use this String to pass an email concatenated with current date and time into
     * an email text box and you can pass same value (email+date+time) in another
     * steps.
     */
    public static String email = getEmail();

    /**
     * Use this method to pass date as a string. You can concatinate with any String
     * and get unique name
     */
    public static String getDateAsString() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateAsString = formatter.format(ts).toString();
        dateAsString = dateAsString.replaceAll("[^A-Za-z0-9]", "");
        return dateAsString;
    }

    public static String date = getDateAsString();

    /**
     * Use this method to select a checkbox value
     *
     * @throws InterruptedException
     */
    public static void selectCheckbox(List<WebElement> checkboxList, String attribute, String value)
            throws InterruptedException {
        for (WebElement checkbox : checkboxList) {
            if (checkbox.isEnabled()) {
                String checkboxText = checkbox.getAttribute(attribute);
                if (checkboxText.equals(value)) {
                    checkbox.click();
                    Thread.sleep(1000);
                    break;
                }
            }
        }
    }

    /**
     * Use this method to select a checkbox value & to check that checkbox is
     * displayed
     *
     * @throws InterruptedException
     */
    public static void selectCheckboxDisplayed(List<WebElement> checkboxList, String attribute, String value)
            throws InterruptedException {
        for (WebElement checkbox : checkboxList) {

            if (checkbox.isEnabled() && checkbox.isDisplayed()) {
                String checkboxText = checkbox.getAttribute(attribute);
                if (checkboxText.equals(value)) {
                    checkbox.click();
                    Thread.sleep(500);
                    break;
                }
            }
        }
    }

    /**
     * Use this method to open new tab
     */
    public static void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverUtils.driver;
        js.executeScript("window.open('about:blank','_blank');");
    }

    /**
     * Use this method to switch to the next open window
     */
    public static void switchToNextWindow() {
        Set<String> handlingAllOpenWindows = WebDriverUtils.driver.getWindowHandles();
        for (String nextWindow : handlingAllOpenWindows) {
            WebDriverUtils.driver.switchTo().window(nextWindow);
        }
    }

    /**
     * Use this method to hover over element
     *
     * @param element
     */
    public static void hoverOverElement(WebElement element) {
        try {
            Actions action = new Actions(WebDriverUtils.driver);
            action.moveToElement(element);
            action.perform();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Use below method to assert actual String value with an expected String value
     */
    public static void assertEquals(String actual, String expected) {

        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {

            e.printStackTrace();
        }
    }

    public static void sleep(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Use this method to assert a boolean condition
     *
     * @param flag
     */
    public static void assertTrue(boolean flag) {
        try {
            Assert.assertTrue(flag);
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will read a .json file and return it in a String type written in
     * json format - for passing REST payloads
     */
    public static String readJson(String fileName) {

        String jsonFile = null;
        try {
            jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonFile;
    }

    /**
     * Compares the data in a DataTable with the content of a table element identified by its tagName.
     * It verifies if the sections of each class in the table match the expected sections in the DataTable.
     *
     * @param expectedDataTable The DataTable containing the expected data.
     * @param actualTable The WebElement representing the actual table.
     * @param tagName The tag name used to locate the section elements in the actual table.
     */
    public static void dataTableVsTable(DataTable expectedDataTable, WebElement actualTable, String tagName) {
        List<Map<String, String>> expectedClassesList = expectedDataTable.asMaps(String.class, String.class);

        Map<String, List<String>> expectedSectionsMap = new HashMap<>();
        for (Map<String, String> row : expectedClassesList) {
            String className = row.get("Class");

            List<String> sections = new ArrayList<>(Arrays.asList(row.get("Sections").split(", ")));
            if (expectedSectionsMap.containsKey(className)) {
                expectedSectionsMap.get(className).addAll(sections);
            } else {
                expectedSectionsMap.put(className, sections);
            }
        }

        List<WebElement> rows = actualTable.findElements(By.xpath(".//tbody/tr"));
        Map<String, List<String>> actualClasses = new HashMap<>();
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));

            String className = cells.get(0).getText();
            List<WebElement> sectionElements = cells.get(1).findElements(By.tagName(tagName));
            List<String> sections = sectionElements.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());

            if (expectedSectionsMap.containsKey(className)) {
                actualClasses.put(className, sections);
            }
        }

        for (Map.Entry<String, List<String>> entry : expectedSectionsMap.entrySet()) {
            String className = entry.getKey();
            List<String> expectedSections = entry.getValue();

            Collections.sort(expectedSections);

            List<String> actualSections = actualClasses.get(className);
            if (actualSections != null) {
                Collections.sort(actualSections);
                Assert.assertEquals(actualSections, expectedSections, "Mismatch in sections for class: " + className);
            } else {
                System.out.println("No actual sections found for " + className);
            }
        }
    }

    /**
     * Gets the dimensions of the browser window.
     *
     * @return The dimensions of the browser window.
     */
    public static Dimension getBrowserDimensions() {
        // Get dimension of the browser
        Dimension dim = driver.manage().window().getSize();

        return dim;
    }

    /**
     * Gets the position of the browser window.
     *
     * @return The position of the browser window as a Point object.
     */
    public static Point getBrowserPosition() {
        // Get position of the browser window
        Point position = driver.manage().window().getPosition();

        return position;
    }
}
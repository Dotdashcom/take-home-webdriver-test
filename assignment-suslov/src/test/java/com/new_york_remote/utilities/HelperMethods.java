package com.new_york_remote.utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static com.interview.utilities.Driver.highlightElement;


public class HelperMethods {

    WebDriverWait wait;
    WebDriver driver = Driver.getDriver();


    public HelperMethods() {
        wait = new WebDriverWait(driver, Long.parseLong(ConfigReader.getPropertiesValue("default_timeout")));
    }

    /**
     * Create a WebDriver helper method that waits until page completely loaded.
     */
    public static void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {

        Wait<WebDriver> wait = new WebDriverWait(driver, specifiedTimeout);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    /**
     * WebDriver helper method that checks whether a text field is blank i.e. no input is given
     */
    public static boolean isBlank(WebElement element) {
        //TODO: Implement here:

        if (element.getAttribute("value").isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Wait for title to be present on the WebPage
     */
    public boolean waitForTitleToBePresent(String title) {
        wait.until(ExpectedConditions.titleIs(title));
        return true;
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page.
     *
     * @param locator
     * @return
     */
    public boolean waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return true;
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible
     *
     * @param locator
     * @return
     */
    public boolean waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
    }

    /**
     * An expectation for checking that an element is clickable on the DOM of a page and visible
     *
     * @param locator
     * @return
     */
    public boolean waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return true;
    }

    /**
     * Get title
     *
     * @return
     */
    public String getTitle() {

        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("Some exception got occurred while getting the page title.");
        }
        return null;
    }

    /**
     * This method is used to create the WebElement on the basis of locator
     *
     * @param locator
     * @return
     */
    public WebElement getElement(By locator) {

        WebElement element = null;

        try {
            element = driver.findElement(locator);

            flash(element);

        } catch (Exception e) {
            System.out.println("Some exception occurred while creating the WebElement.");
        }
        return element;
    }

    /**
     * This method is used to click the WebElement on the basis of locator
     *
     * @param locator
     */
    public void click(By locator) {

        try {
            getElement(locator).click();
        } catch (Exception e) {
            System.out.println("Some exception got occurred while clicking the WebElement.");
        }
    }

    /**
     * WebDriver helper method that performs JavascriptExecutor click operation
     */
    public static void jsClick(WebDriver driver, WebElement element) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * This method is used to send value into a text field
     *
     * @param locator
     * @param value
     */
    public void enterText(By locator, String value) {
        try {
            WebElement element = getElement(locator);
            element.clear();
            element.sendKeys(value);

        } catch (Exception e) {
            System.out.println("Some exception occurred while entering values into a text field.");
        }
    }

    /**
     * This method is used to check if element is displayed on the DOM of a page
     *
     * @param locator
     * @return
     */
    public boolean checkIfElementIsDisplayed(By locator) {

        try {
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            System.out.println("Some exception occurred using checkIfElementIsDisplayed method.");
        }
        return false;
    }

    /**
     * This method is used to check if element is enabled on the DOM of a page
     *
     * @param locator
     * @return
     */
    public boolean checkIfElementIsEnabled(By locator) {

        try {
            return getElement(locator).isEnabled();
        } catch (Exception e) {
            System.out.println("Some exception occurred using checkIfElementIsEnabled method.");
        }
        return false;
    }

    /**
     * This method is used to check if element is selected on the DOM of a page
     *
     * @param locator
     * @return
     */
    public boolean checkIfElementIsSelected(By locator) {
        try {
            return getElement(locator).isSelected();
        } catch (Exception e) {
            System.out.println("Some exception occurred while checking if element is selected.");
        }
        return false;
    }

    /**
     * This method is used to get text of an element of the DOM of a page
     *
     * @param locator
     * @return
     */
    public String getText(By locator) {
        try {
            return getElement(locator).getText();
        } catch (Exception e) {
            System.out.println("Some exception occurred while getting text of an element.");
        }
        return null;
    }

    /**
     * This method is used to perform right click on the element of a page
     *
     * @param locator
     */
    public void performContextClick(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(locator);
        actions.contextClick(elementLocator).perform();
    }

    /**
     * This method is used to handle an alert on a WebPage
     *
     * @param driver
     * @return
     */
    public String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
        return text;
    }

    /**
     * This method is used to send text onto an alert notification
     *
     * @param driver
     */
    public String sendTextAlertBox(WebDriver driver, String sendText) {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(ConfigReader.getPropertiesValue("default_timeout")));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        alert.sendKeys(sendText);
        alert.accept();
        return sendText;
    }

    /**
     * This method is used to perform drag and drop action on the DOM of a page
     *
     * @param driver
     * @param sourceLocator
     * @param destinationLocator
     */
    public void performDragAndDrop(WebDriver driver, By sourceLocator, By destinationLocator) {
        Actions action = new Actions(driver);
        WebElement elementSource = driver.findElement(sourceLocator);
        WebElement elementDestination = driver.findElement(destinationLocator);
        action.dragAndDrop(elementSource, elementDestination)
                .build()
                .perform();
    }

    /**
     * This method is used to select a dropdown by visible text on the DOM of a page
     * selectByVisibleText - It is used to select an option based on the text over the option.
     *
     * @param locator
     * @param visibleText
     */
    public void selectDropDownValueByVisibleText(By locator, String visibleText) {
        WebElement element = getElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * This method is used to select the value of a dropdown by visible text
     * selectByIndex - It is used to select an option based on its index, beginning with 0.
     *
     * @param locator
     * @param index
     */
    public void selectDropDownValueByIndex(By locator, String index) {
        WebElement element = getElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(index);
    }

    /**
     * This method is used to select the value a dropdown by value on the DOM of a page
     * selectByValue - It is used to select an option based on its 'value' attribute.
     *
     * @param locator
     * @param value
     */
    public void selectDropDownValueByValue(By locator, String value) {
        WebElement element = getElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void flash(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String backgroundColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element);// 1
            changeColor(backgroundColor, element);// 2
        }
    }

    private void changeColor(String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }

    public void drawBorder(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void generateAlert(String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }

    public void clickElementByJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);

    }

    public void refreshBrowserByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public String getTitleByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public String getPageInnerText() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public void scrollPageDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getBrowserInfo() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String uAgent = js.executeScript("return navigator.userAgent;").toString();
        return uAgent;
    }

    public void sendKeysUsingJSWithId(String id, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
    }

    public void sendKeysUsingJSWithName(String name, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
    }

    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page Is loaded.");
            return;
        }
        // This loop will rotate for 25 times to check If page Is ready after
        // every 1 second.
        // You can replace your value with 25 If you wants to Increase or
        // decrease wait time.
        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            // To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public boolean isInViewPort(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean is_displayed = (Boolean) js.executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element
        );
        return is_displayed;
    }

}

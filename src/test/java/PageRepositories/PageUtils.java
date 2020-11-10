package PageRepositories;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.openqa.selenium.interactions.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import Tests.BaseTest;


public class PageUtils extends BaseTest {
    public WebDriver driver;

    /**
     * @description The function is used for custom wait in milliseconds
     * @param millisec: the properties file name
     **/
    public void custom_wait(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description The function is used to click a web element
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     **/
    public void click_element(WebDriver driver, String xpath) {
        wait_for_element_present(driver, xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * @description The function is mimic keyboard strokes
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     * @param value: The String to Type into the Text Field
     **/
    public void type_in_field(WebDriver driver, String xpath, String value) {
        String val = value;
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();

        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            custom_wait(150);
        }
    }

    /**
     * @description This function is used for waiting for web element to appear in the UI (Document
     * is in ready state, the element is visible and clickable
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     **/
    public void wait_for_element_present(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * @description This function is used for waiting for web element to appear in the UI (Document
     * is in ready state, the element is visible and clickable
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     * @param timeout: This is a custom time out.
     **/
    public void wait_for_element_present_with_custom_time(WebDriver driver, String xpath, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * @description This function is used to verify if a text is present associated with the given web
     * locator in the UI
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     * @param expected_result: The expected Text for the WebElement
     * @param error_msg: Custom Error Message
     **/
    public void verify_text_present(WebDriver driver, String xpath, String expected_result, String error_msg) {
        String actual_result = driver.findElement(By.xpath(xpath)).getText().trim();
        Assert.assertTrue(driver.findElement(By.xpath(xpath)).getText().contains(expected_result), error_msg+ " Expected: [" + expected_result +"], Actual: [" + actual_result + "].");
    }

    /**
     * @description This function is used to verify element is present associated with the given web locator in the UI
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     **/
    public void verify_element_is_not_present(WebDriver driver, String xpath) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS); //Setting the Implicit timeout
        Assert.assertTrue(driver.findElements(By.xpath(xpath)).size() < 1, "The Element with XPATH = " + xpath + " is Present in the Page");
        driver.manage().timeouts().implicitlyWait(browser_timeout, TimeUnit.SECONDS); //Setting the Default Implicit Timeout
    }

    /**
     * @description This function is used to verify element not present associated with the given web locator in the UI
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     **/
    public void verify_element_is_present(WebDriver driver, String xpath) {
        Assert.assertTrue(driver.findElements(By.xpath(xpath)).size() > 0, "The Element with XPATH = " + xpath + " is NOT Present in the Page");
    }

    /**
     * @description This function is used to right click context menu in the UI
     * @param driver: the WebDriver
     * @param xpath: the XPath to the WebElement
     **/
    public void right_click_context_menu(WebDriver driver, String xpath) {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath(xpath))).build().perform();
    }

    /**
     * @description This function for switch to alert and verify the alert message
     * @param driver: the WebDriver
     * @param expected_result: The expected text in the Alert
     **/
    public void verify_alert_message(WebDriver driver, String expected_result) {
        Alert alert = driver.switchTo().alert();
        String actual_result = alert.getText();
        Assert.assertTrue(actual_result.contains(expected_result), "Expected Alert Text: [" + expected_result +"], Actual Alert Text: [" + actual_result + "].");
    }

    /**
     * @description This function for switch to alert and accept the alert i.e. click OK
     * @param driver: the WebDriver
     **/
    public void accept_alert_message(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    //TODO: JS Native hack for sendKeys
    /**
     * @description This function for switch to alert and verify the alert message
     * @param driver: the WebDriver
     * @param type_text: The text to type in the Alert Text Box
     **/
    public void type_in_alert(WebDriver driver, String type_text) {
        Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(type_text);
    }

    /**
     * @description This function is used to switch for iframe
     * @param driver: the WebDriver
     * @param frame_id: Iframe ID
     **/
    public void switch_iframe(WebDriver driver, String frame_id) {
        driver.switchTo().frame(frame_id);
    }

    /**
     * @description This function is used to switch tabs in the Windows
     * @param driver: the WebDriver
     * @param tab_number: Tab number to switch to. Tabs starts with index 0.
     **/
    @Step("Switch To Tab -{1}")
    public void switch_tab (WebDriver driver, int tab_number) {
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tab_number));
    }

    /**
     * @description This function is used scroll down in the web page
     * @param driver: the WebDriver
     * @param pixels: Pixel value in Y-axis to scroll down.
     **/
    public void scroll_page(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ pixels+ ")");
        custom_wait(200);
    }
}

package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import static org.junit.Assert.*;

public class JsAlertsPage {
    private WebDriver driver;
    //explicit wait
    WebDriverWait wait;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "javascript_alerts";

    //Click for JS Alert button
    @FindBy(xpath="//button[text()='Click for JS Alert']")
    private WebElement jsAlertButton;
    //Click for JS Confirm button
    @FindBy(xpath="//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;
    //Click for JS Prompt button
    @FindBy(xpath="//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;
    //Alert result
    @FindBy(id = "result")
    private WebElement resultText;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public JsAlertsPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        wait = new WebDriverWait(driver,30);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"JavaScript Alerts");
    }

    //Verify actions on JS Alert button
    public void verifyJsConfirm() {
        jsConfirmButton.click();
        //wait until alert pops up
        assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertEquals(resultText.getText(), "You clicked: Ok");
    }

    //Verify actions on JS Alert button
    public void verifyJsAlert() {
        jsAlertButton.click();
        //wait until alert pops up
        assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
    }

    //Verify actions on JS Alert button
    public void verifyJsPrompt() {
        jsPromptButton.click();
        //wait until alert pops up
        assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test Prompt");
        alert.accept();
        assertEquals(resultText.getText(), "You entered: Test Prompt");
    }
}

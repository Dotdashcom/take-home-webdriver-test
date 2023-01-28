package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DynamicControl {
    private WebDriver driver;
    private SoftAssert softAssert;

    public DynamicControl(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    private WebElement removeBtn;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    private WebElement enableBtn;

    @FindBy(xpath = "//p[@id='message']")
    private WebElement msgItsGone;

    @FindBy(id="message")
    private WebElement msgEnabled;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputText;


    public void useImplicitWaitOnDynamicControl(){
        navigateToDynamicControlPage();
        checkImplicitWaitForRemoveBtn();
        useImplicitWaiForEnableBtn();
    }

    private void useImplicitWaiForEnableBtn(){
        enableBtn.click();
        waitUntilPageLoad();
        softAssert.assertTrue(msgEnabled.isDisplayed(),"Msg (Its enabled!) is not displayed");
        softAssert.assertTrue(inputText.isEnabled(),"Input text is not enabled");

    }
    private void checkImplicitWaitForRemoveBtn(){
        checkBox.click();
        removeBtn.click();
        waitUntilPageLoad();
        softAssert.assertTrue(msgItsGone.isDisplayed(),"Msg (Its gone!) is not displayed");
        softAssert.assertTrue(removeBtn.getText().equalsIgnoreCase("Add"),"Remove btn did not change name to Add");

    }

    private void waitUntilPageLoad(){
        int pageLoadTime = Integer.parseInt(ConfigReader.getProperty("pageLoadTime"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
    }

    private void navigateToDynamicControlPage(){
        driver.get(ConfigReader.getProperty("url")+"/dynamic_controls");
    }
}

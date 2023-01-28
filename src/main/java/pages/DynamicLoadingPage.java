package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DynamicLoadingPage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public DynamicLoadingPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "button")
    private WebElement button;

    @FindBy(xpath = "//div[@id='finish']/h4")
    private WebElement textAfterLoad;

    public void verifyImplicitWaitDynamicLoadPage(){
        navigateToDynamicLoadPage();
        button.click();
        waitUntilPageLoad();
        softAssert.assertTrue(textAfterLoad.isDisplayed(),"Text (Hello Word!) is not displayed");

    }
    private void waitUntilPageLoad(){
        int pageLoadTime = Integer.parseInt(ConfigReader.getProperty("pageLoadTime"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
    }

    private void navigateToDynamicLoadPage(){
        driver.get(ConfigReader.getProperty("url")+"/dynamic_loading/2");
    }
}

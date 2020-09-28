package pageobject;

import base.EndPointPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtilities;

public class DynamicLoadingPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Start')]")
    private WebElement startBtn;

    //@FindBy(xpath = "//h4[contains(text(), 'Hello World!')]")
    //private WebElement helloLbl;
    By helloLbl = By.xpath("//h4[contains(text(), 'Hello World!')]");



    public DynamicLoadingPage(WebDriver driver) {
        super(driver, EndPointPath.DYNAMIC_LOADING);

    }

    public boolean verifyHelloWorldDisplay() {
        startBtn.click();
        return !WaitUtilities.explicitWaitByWebElementvisibilityOfElementLocated(driver, helloLbl).equals(null);
    }




}

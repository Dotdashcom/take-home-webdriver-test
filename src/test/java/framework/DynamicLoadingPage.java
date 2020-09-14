package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Start')]")
    WebElement startButton;

    @FindBy(xpath = "//div[@id = 'finish']")
    WebElement helloWorld;


    public DynamicLoadingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testDynamicLoading(WebDriver driver) {
        waitUntilElementIsVisible(driver, startButton);
        clickOnElement(driver, startButton, "Success: Clicked on Start button",
                "Failed: Unable to click on Start button");
        waitUntilElementIsVisible(driver, helloWorld);
        if (isElementPresent(driver, helloWorld)) {
            return true;
        }
        return false;
    }
}

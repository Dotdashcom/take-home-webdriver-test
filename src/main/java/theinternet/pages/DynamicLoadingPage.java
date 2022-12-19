package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage extends BasePage{
    public DynamicLoadingPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'Dynamically Loaded Page Elements')]")
    public WebElement dynamicLoadingHeader;
    @FindBy(xpath = "//a[contains(.,'Example 2: Element rendered after the fact')]")
    public WebElement dynamicLoadingExample2;
    @FindBy(xpath = "//button[contains(.,'Start')]")
    public WebElement dynamicLoadingStartButton;
    @FindBy(xpath = "//h4[contains(.,'Hello World!')]")
    public WebElement dynamicLoadingHelloWorldText;

    public Boolean validatePageLanding(){
        dynamicLoadingHeader.isDisplayed();
        dynamicLoadingExample2.isDisplayed();
        return true;
    }
    public void clickOnButton(String option){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        dynamicLoadingExample2.click();
        switch (option){
            case "Start":
                dynamicLoadingStartButton.click();
                wait.until(ExpectedConditions.visibilityOf(dynamicLoadingHelloWorldText));
                break;
        }
    }
    public Boolean hiddenTextIsDisplayed(){
        dynamicLoadingHelloWorldText.isDisplayed();
        return true;
    }
}

package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BasePage {

    WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Example 1')]")
    public WebElement firstExample;

    @FindBy(xpath = "//h4[text()='Hello World!']")
    public WebElement helloWorldText;


    public void clickOnFirstExample() {
        firstExample.click();
    }

    public void waitOnHelloWorld() {
        waitForElement(helloWorldText);
    }
}

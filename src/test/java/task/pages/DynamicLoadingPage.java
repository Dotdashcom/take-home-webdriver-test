package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {

    @FindBy (xpath = "//button")
    public WebElement startButton;

    @FindBy (xpath = "//*[text()=\"Hello World!\"]")
    public WebElement helloWorldText;

}

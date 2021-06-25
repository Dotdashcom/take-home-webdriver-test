package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {
    @FindBy(tagName = "button")
    public WebElement startButton;

    @FindBy(xpath = "//*[@id='finish']/h4")
    public WebElement finishText;

}

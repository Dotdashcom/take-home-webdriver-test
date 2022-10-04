package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowPage extends BasePage {

    @FindBy (xpath = "//a[@href='/windows/new']")
    public WebElement clickHereBtn;

    @FindBy (xpath = "//div[h3='New Window']")
    public WebElement newWindowMessage;
}

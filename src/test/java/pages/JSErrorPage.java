package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSErrorPage extends BasePage {

    @FindBy(xpath = "(//button)[1]")
    public WebElement alertButton;
}

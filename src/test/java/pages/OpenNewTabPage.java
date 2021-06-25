package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewTabPage extends BasePage {

    @FindBy(linkText = "Click Here")
    public WebElement clickHere;

    @FindBy(tagName = "h3")
    public WebElement text;

}

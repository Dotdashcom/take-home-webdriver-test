package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage {
    @FindBy (xpath = "//*[@id=\"content\"]/div[3]/div[2]")
    public WebElement dynamicContent;

}

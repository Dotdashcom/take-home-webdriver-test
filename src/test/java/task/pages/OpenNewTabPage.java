package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewTabPage extends BasePage{

    @FindBy (xpath = "//a[text()='Click Here']")
    public WebElement clickHereButton;

    @FindBy (xpath = "//h3")
    public WebElement headerNewWindown;
}

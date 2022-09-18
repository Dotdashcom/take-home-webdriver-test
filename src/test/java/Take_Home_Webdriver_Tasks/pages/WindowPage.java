package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPage extends BasePage {

    @FindBy (xpath = "//div[@id=\"content\"]/div/a")
    public WebElement clickHereBtn;


}

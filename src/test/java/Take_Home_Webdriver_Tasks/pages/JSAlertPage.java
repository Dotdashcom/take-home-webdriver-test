package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSAlertPage extends BasePage {

    @FindBy (xpath = "//div[@id=\"content\"]/div/ul/li[1]/button")
    public WebElement jsAlertBtn;

    @FindBy (xpath = "//div[@id=\"content\"]/div/ul/li[2]/button")
    public WebElement jsConfirmBtn;

    @FindBy (xpath = "//div[@id=\"content\"]/div/ul/li[3]/button")
    public WebElement jsPromptBtn;

    @FindBy (id = "result")
    public WebElement resultTxt;
}

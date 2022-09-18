package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPage extends BasePage {

    @FindBy (xpath = "//div[@id=\"content\"]/div[1]/div[2]")
    public WebElement dynContText;

    @FindBy (xpath = "//*[@id=\"checkbox-example\"]/button")
    public WebElement remove_add_Btn;

    @FindBy (xpath = "//div[@id=\"checkbox\"]/input")
    public WebElement checkBox;

    @FindBy (id = "message")
    public WebElement actionMsg;

    @FindBy (xpath = "//form[@id=\"input-example\"]/button")
    public WebElement enable_disable_Btn;

    @FindBy (xpath = "//*[@id=\"start\"]/button")
    public WebElement startBtn;

    @FindBy (id = "finish")
    public WebElement loadedText;


}

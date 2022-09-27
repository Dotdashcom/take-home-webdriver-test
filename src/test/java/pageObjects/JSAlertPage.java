package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class JSAlertPage extends BaseClass {

    public JSAlertPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement jsAlertPageHeader;

    @FindBy(xpath = "//div[@class='example']/ul/li[1]/button")
    public WebElement jsAlertButton;

    @FindBy(xpath = "//div[@class='example']/ul/li[2]/button")
    public WebElement jsConfirmButton;

    @FindBy(xpath = "//div[@class='example']/ul/li[3]/button")
    public WebElement jsPromptButton;

    @FindBy(xpath = "//*[@id='result']")
    public WebElement resultText;
}

package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class DynamicControlsPage extends BasePage{

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    public WebElement removeAddBtn;

    @FindBy(xpath = "//form[@id='checkbox-example']/p[@id='message']")
    public WebElement actualMessage;

    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement enableBTN;

    @FindBy(xpath = "//form[@id='input-example']/p")
    public WebElement actualBtnMsg;

    @FindBy(xpath = "//form[@id='input-example']/p[@id='message']")
    public WebElement enableDisableMsg;



}

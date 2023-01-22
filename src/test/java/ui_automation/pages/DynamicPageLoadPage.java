package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class DynamicPageLoadPage extends BasePage{

    public DynamicPageLoadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startBtn;

    @FindBy(xpath = "//div[@id='finish']/h4")
    public WebElement actualMsg;


}

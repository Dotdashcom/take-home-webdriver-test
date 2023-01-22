package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class OpenNewTabPage extends BasePage{

    public OpenNewTabPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Click Here']")
    public WebElement ckickhere;


}

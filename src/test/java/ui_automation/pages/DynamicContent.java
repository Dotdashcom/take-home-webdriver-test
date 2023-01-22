package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class DynamicContent extends BasePage{

    public DynamicContent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='click here']")
    public WebElement clickhere;

    @FindBy(xpath = "//div[@id='content']/div[@class='row'][3]/div[2]")
    public WebElement thirdContext;


}

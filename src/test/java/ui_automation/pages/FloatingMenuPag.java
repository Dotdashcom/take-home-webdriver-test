package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class FloatingMenuPag extends BasePage{

    public FloatingMenuPag(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id ='menu']/ul/li")
    public List<WebElement> menus;


}

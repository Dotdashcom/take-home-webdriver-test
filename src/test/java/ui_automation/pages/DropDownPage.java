package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class DropDownPage extends BasePage{

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='dropdown']")
    public WebElement dropArrow;

    @FindBy(xpath = "//select[@id='dropdown']/option[text() = 'Option 2']")
    public WebElement option2;

    @FindBy(xpath = "//select[@id='dropdown']/option[text() = 'Option 1']")
    public WebElement option1;


}

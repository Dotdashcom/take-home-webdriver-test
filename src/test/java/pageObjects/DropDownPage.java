package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class DropDownPage extends BaseClass {

    public DropDownPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='Dropdown List']")
    public WebElement dropDownPageHeader;

    @FindBy(id = "dropdown")
    public WebElement dropDown;

    @FindBy(xpath = "//option[@selected='selected']")
    public WebElement selectedOption;
}

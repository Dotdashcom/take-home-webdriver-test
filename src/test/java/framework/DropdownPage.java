package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage extends BasePage{

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectFromDropdown (WebDriver driver) {
        selectFromDropdown(driver, dropdown, "1");
    }
}

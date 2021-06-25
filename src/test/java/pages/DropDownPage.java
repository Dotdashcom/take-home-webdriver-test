package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DropDownPage extends BasePage {
    @FindBy(id = "dropdown")
    public WebElement dropdown;
}
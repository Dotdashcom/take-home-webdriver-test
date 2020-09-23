package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends BasePage {

    @FindBy (xpath = "//select")
    public WebElement dropdown;


}

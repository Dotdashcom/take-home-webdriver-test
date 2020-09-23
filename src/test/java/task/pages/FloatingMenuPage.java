package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage {

    @FindBy (xpath = "//a[text()='News']")
    public WebElement newsMenu;


}

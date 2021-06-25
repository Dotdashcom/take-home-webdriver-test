package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage {

    @FindBy(id = "menu")
    public WebElement menu;
}

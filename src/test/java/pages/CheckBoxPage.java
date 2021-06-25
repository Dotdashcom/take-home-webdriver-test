package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends BasePage {
    @FindBy(tagName = "input")
    public List<WebElement> checkboxes;
}


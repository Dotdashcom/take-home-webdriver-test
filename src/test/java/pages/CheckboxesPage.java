package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;
}

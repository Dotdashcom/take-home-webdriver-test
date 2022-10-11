package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FloatingMenuPage extends BasePage {

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='menu']//li")
    public List<WebElement> floatingMenuOptions;
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowPage extends BasePage {

    public NewWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    public static WebElement headerThree;
}

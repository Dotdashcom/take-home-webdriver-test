package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpeningNewWindowPage extends BasePage {

    public OpeningNewWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Click Here']")
    public WebElement openNewWindowLink;
}

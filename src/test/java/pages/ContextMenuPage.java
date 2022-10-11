package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage{

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='hot-spot']")
    public WebElement hotSpot;
}

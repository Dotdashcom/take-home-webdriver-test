package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class FloatingMenuPage extends BasePage{

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#menu")
    private WebElement menu;

    public boolean isMenuDisplayed() {
        return menu.isDisplayed();
    }
}

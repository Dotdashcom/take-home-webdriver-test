package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage {

    @FindBy(id = "menu")
    protected WebElement floatingMenu;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public void scrollDownTwoPages() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public boolean isFloatingMenuDisplayed() {
        return floatingMenu.isDisplayed();
    }
}

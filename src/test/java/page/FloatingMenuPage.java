package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FloatingMenuPage extends PageObject {

    @FindBy(id = "menu")
    public WebElement floatingMenu;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean floatingMenu() {
        if (ExpectedConditions.visibilityOf(floatingMenu) == null)
            return false;
        else
            return true;
    }

    public void scrollToTheBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}

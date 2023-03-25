package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FloatingMenuPage extends BasePage {
    private By menu = By.id("menu");

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public boolean menuDisplayed(){
        return getElement(menu).isDisplayed();
    }
}

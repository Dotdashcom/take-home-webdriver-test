package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FloatingMenuPage extends BasicPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menu\"]")
    WebElement floatingMenu;

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/floating_menu");
        PageFactory.initElements(this.driver, this);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
    }

    public void assertFloatingMenu() {
        Assert.assertTrue(floatingMenu.isDisplayed());
    }
}

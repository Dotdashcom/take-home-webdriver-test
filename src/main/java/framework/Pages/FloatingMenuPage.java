package framework.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FloatingMenuPage {

    WebDriver driver;

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "menu")
    WebElement floatingMenu;

    public void scrollAndCheckMenu(){
        Assert.assertTrue(floatingMenu.isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");
        Assert.assertTrue(floatingMenu.isDisplayed());
        jse.executeScript("window.scrollBy(0,-1000)");
        Assert.assertTrue(floatingMenu.isDisplayed());

    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FloatingMenuPage {
    WebDriver driver;
    String floatingMenuUrl =("http://localhost:7080/floating_menu");
    By floatingMenuId = By.id("menu");


    public FloatingMenuPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(floatingMenuUrl);
    }

    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
    }

    public boolean isFloatingMenuStill(){
        WebElement floatingMenu = driver.findElement(floatingMenuId);
        return floatingMenu.isDisplayed();
    }
}

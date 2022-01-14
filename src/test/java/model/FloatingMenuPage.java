package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FloatingMenuPage extends PageGeneral{

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement floatingMenu() {
        return this.driver.findElement(By.id("menu"));
    }

    public JavascriptExecutor javascriptExecutor() {
        return (JavascriptExecutor)driver;
    }

}

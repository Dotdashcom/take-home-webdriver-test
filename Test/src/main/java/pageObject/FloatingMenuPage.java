package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class FloatingMenuPage {
    
    WebDriver webDriver;
    String floatingMenuPageUrl = "http://localhost:7080/floating_menu";
    String floatingMenuXpath = "//h3[text()='Floating Menu']";

    public FloatingMenuPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(floatingMenuPageUrl);
    }

    public boolean isFloatingMenuDisplayed(){
        return webDriver.findElement(By.xpath(floatingMenuXpath)).isDisplayed();
    }

    public void scorllDownToTheBottom(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,10000)");
    }
}

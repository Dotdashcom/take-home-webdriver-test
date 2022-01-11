package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
    WebDriver driver;
    String dragAndDropUrl = ("http://localhost:7080/drag_and_drop");
    By elementA = By.id("column-a");
    By elementB = By.id("column-b");

    public DragDropPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(dragAndDropUrl);
    }

    public void dragAndDrop(){
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        WebElement fromA = driver.findElement(elementA);
        WebElement toB = driver.findElement(elementB);
        Actions action= new Actions(driver);
        action.dragAndDrop(fromA, toB).perform();
    }

    public String elementAtext(){
        return driver.findElement(elementA).getText();
    }

    public String elementBtext(){
        return driver.findElement(elementB).getText();
    }

}

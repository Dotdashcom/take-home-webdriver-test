package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragAndDropPage extends BasePage {

    @FindBy(id="column-a")
    WebElement columnA;

    @FindBy(id="column-b")
    WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop(){
        Actions action = new Actions(driver);
        action.dragAndDrop(columnA, columnB).perform();
    }

    public String getColumnAText(){
        return columnA.findElement(By.tagName("header")).getText();
    }

    public String getColumnBText(){
        return columnB.findElement(By.tagName("header")).getText();
    }

}

package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    
    WebDriver webDriver;
    String dragAndDropPageUrl = "http://localhost:7080/drag_and_drop";

    String boxAHeaderXpath = "//div[@id='column-a']/header";
    String boxBHeaderXpath = "//div[@id='column-b']/header";

    public DragAndDropPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(dragAndDropPageUrl);
    }

    public void dragAndDrop(){
        WebElement headerA = webDriver.findElement(By.xpath(boxAHeaderXpath));
        WebElement headerB = webDriver.findElement(By.xpath(boxBHeaderXpath));
        Actions action = new Actions(webDriver);	
        action.clickAndHold(headerA).moveToElement(headerB).release(headerB).build().perform();	
        
    }

    public String getBoxAHeader(){
        return webDriver.findElement(By.xpath(boxAHeaderXpath)).getText();
    }

    public String getBoxBHeader(){
        return webDriver.findElement(By.xpath(boxBHeaderXpath)).getText();
    }
}

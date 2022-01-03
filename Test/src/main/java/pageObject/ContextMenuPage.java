package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    
    WebDriver webDriver;
    String contextMenuPageUrl = "http://localhost:7080/context_menu";

    String contextMentXpath = "//div[@id='hot-spot']";
    String alertText;


    public ContextMenuPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(contextMenuPageUrl);
    }

    public void rightClickOnContextMenu(){
        WebElement contextMenu = webDriver.findElement(By.xpath(contextMentXpath));
        Actions actions = new Actions(webDriver);
        actions.contextClick(contextMenu).perform();
    }

    public String getAlertMessage() {
        return webDriver.switchTo().alert().getText();
        
    }
}

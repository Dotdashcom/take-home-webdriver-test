package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    WebDriver driver;
    String contextMenuUrl = ("http://localhost:7080/context_menu");
    String boxXpath ="//div[@id='hot-spot']";

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(contextMenuUrl);
    }

    public void rightClick(){
        WebElement box = driver.findElement(By.xpath(boxXpath));
        Actions action = new Actions(driver).contextClick(box);
        action.build().perform();
    }


}

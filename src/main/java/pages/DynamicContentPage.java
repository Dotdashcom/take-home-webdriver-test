package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicContentPage {
    WebDriver driver;
    String contextMenuUrl = ("http://localhost:7080/dynamic_content");
    By content = By.id("content");


    public DynamicContentPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(contextMenuUrl);
    }

    public String getContent(){
        WebElement wholeContent = driver.findElement(content);
        return wholeContent.getText();

    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
}

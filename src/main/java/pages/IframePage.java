package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class IframePage{
    WebDriver driver;
    String iframeUrl =("http://localhost:7080/iframe");

    public IframePage(WebDriver driver){
        this.driver = driver;
        this.driver.get(iframeUrl);
    }

    public void switchToIframe(){
        driver.switchTo().frame("mce_0_ifr");
    }

    public void closeAlertMessage(){
        List<WebElement> crossButton = driver.findElements(By.xpath("//button[contains(@class,'tox-button')]"));
        if(crossButton.size()>0){crossButton.get(0).click();}
    }

    public void typeInTextbox(String content){
        driver.findElement(By.id("tinymce")).sendKeys(content);
    }

    public String getContent(){
        return driver.findElement(By.id("tinymce")).getText();
    }


}

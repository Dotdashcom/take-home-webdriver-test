package webdrivertestpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class iFrame{
    WebDriver driver;

    By element = By.xpath(" //iframe[@id='mce_0_ifr']");
    // By body = By.xpath("//body[@id='tinymce']");
  //  WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));

    public iFrame(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void iFrameHandle(){
        //First,  I located the iframe then I have switched to the iframe
        driver.switchTo().frame(driver.findElement(element));
    }

    public String getMessageToBody(){
        WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
        String message = body.getText();
        return message;
    }
}

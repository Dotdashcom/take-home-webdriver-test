package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class IframePage {
    WebDriver webDriver;
    String iframePageUrl = "http://localhost:7080/iframe";
    String errormessageButtonXpath = "//button[contains(@class,'tox-button')]";
    String textBodyXpath = "//body[@id='tinymce']";

    public IframePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(iframePageUrl);
    }
    
    public void closeErrorMessageIfExist(){
        List<WebElement> errorMessageCloseButton = webDriver.findElements(By.xpath(errormessageButtonXpath));
        if (errorMessageCloseButton.size()>0){
            errorMessageCloseButton.get(0).click();
        }
    }

    public void switchToIframe(){
        webDriver.switchTo().frame("mce_0_ifr");
    }

    public void setText(String text){
        webDriver.findElement(By.xpath(textBodyXpath)).sendKeys(text);
    }

    public String getText(){
        return webDriver.findElement(By.xpath(textBodyXpath)).getText();
    }
}

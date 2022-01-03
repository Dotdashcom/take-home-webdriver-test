package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DynamicLoadingPage {
    WebDriver webDriver;
    String dynamicLoadingPageUrl = "http://localhost:7080/dynamic_loading/2";

    String startButtonXpath = "//button[text()='Start']";
    String helloWorldTextXapth = "//div[@id='finish']/h4[text()='Hello World!']";

    public DynamicLoadingPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(dynamicLoadingPageUrl);
    }
    
    public void startLoading(){
        webDriver.findElement(By.xpath(startButtonXpath)).click();
        WebDriverWait wait= new WebDriverWait(webDriver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(helloWorldTextXapth)));
    }

    public boolean isloaded(){
        return webDriver.findElements(By.xpath(helloWorldTextXapth)).size()>0;
    }
}

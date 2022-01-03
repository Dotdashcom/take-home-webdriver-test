package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenInNewTabPage {
    WebDriver webDriver;
    String openInNewTabPageUrl = "http://localhost:7080/windows";
    String newWindowlinkXpath = "//a[text()='Click Here']";

    public OpenInNewTabPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(openInNewTabPageUrl);
    }

    public void openNewTab(){
        webDriver.findElement(By.xpath(newWindowlinkXpath)).click();
    }
}

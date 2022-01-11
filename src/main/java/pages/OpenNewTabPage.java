package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OpenNewTabPage {

    WebDriver webDriver;
    String windowsPageUrl = "http://localhost:7080/windows";
    String clickHereXPath = "//a[@href='/windows/new']";
    String newWindowTextXPath = "//h3";

    public OpenNewTabPage(WebDriver driver){
        this.webDriver = driver;
        this.webDriver.get(windowsPageUrl);
        PageFactory.initElements(webDriver, this);
    }

    public void clickText() {
        WebElement textElement = webDriver.findElement(By.xpath(clickHereXPath));
        textElement.click();
    }

    public String getNewWindowText() {
        return webDriver.findElement(By.xpath(newWindowTextXPath)).getText();
    }
}

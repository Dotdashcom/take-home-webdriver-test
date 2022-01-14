package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloadPage extends PageGeneral{
//    WebDriver driver;

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement downloadComponent() {
        return this.driver.findElement(By.linkText("some-file.txt"));
    }
}

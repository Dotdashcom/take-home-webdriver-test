package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileDownloader extends Base {
    WebDriver driver;

    @Test
    public void fileDownloader(){
        driver = getDriver();
        driver.get("http://localhost:7080/download");

        /*
        * For FileDownloader what I basically did was I have located the element using xpath and
        * then i just invoked the click() method to click on the file to download.
        * */

        WebElement fileDownloader = driver.findElement(By.xpath("//a[@href='download/some-file.txt']"));
        fileDownloader.click();
    }
}

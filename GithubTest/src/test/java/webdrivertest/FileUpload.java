package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload extends Base {
    WebDriver driver;
    @Test
    public void fileUpload(){
        driver = getDriver();
        driver.get("http://localhost:7080/upload");

        /*
        * For file upload I used the sendKeys() method where I have passed the path of the file I am
        * uploading as a parameter.
        * */

        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='file-upload']"));
        fileUpload.sendKeys("/Users/miftahchowdhury/Desktop/Resume Miftah Chowdhury.docx");

        WebElement submit = driver.findElement(By.xpath("//input[@id='file-submit']"));
        submit.click();

    }

}

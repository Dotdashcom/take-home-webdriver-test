package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class iFrame extends Base {
    WebDriver driver;

    @Test
    public void iFrameHandle(){
        driver = getDriver();



        driver.get("http://localhost:7080/iframe");


        //First,  I located the iframe then I have switched to the iframe

        driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@id='mce_0_ifr']")));

        /*
            Now I located the body of the iframe and used clear() method to clear the body
            and then I used sendKeys() method by passing a string value just to check
            if I am really on iFrame
            */
        WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
        body.clear();
        body.sendKeys("MiftahChowdhury");



    }
}

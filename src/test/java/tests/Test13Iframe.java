package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test13Iframe extends GenericTest {

    @Test
    public void Test13Iframe() {
        String url = "http://localhost:7080/iframe";
        driver.get(url);

        //switch to the iframe and set the text of the textarea
        driver.switchTo().frame("mce_0_ifr");
        WebElement textArea = driver.findElement(By.xpath("//body"));
        textArea.clear();
        textArea.sendKeys("Hello World!");

        //assert that the text is what was typed in previously
        Assert.assertEquals(driver.findElement(By.xpath("//body/p")).getText(),"Hello World!");
    }

}
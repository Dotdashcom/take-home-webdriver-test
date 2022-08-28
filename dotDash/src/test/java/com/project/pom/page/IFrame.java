package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame extends Base {

    By content = By.id("content");
    By textArea = By.xpath("//*[@id=\"tinymce\"]");

    public IFrame(WebDriver driver) {
        super(driver);
    }

    public void iFrame(){
        WebElement text = driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(text);
        clear(textArea);
        sendKeys("Iframe", textArea);
    }

    public String textAreaGetText(){
        return getText(textArea);
    }
}

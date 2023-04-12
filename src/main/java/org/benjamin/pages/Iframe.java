package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Iframe extends PageBase{
    public void init() {
        super.init("http://localhost:7080/iframe");
    }

    public void typeInIframe(String text){
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement inputArea = driver.findElement(By.id("tinymce"));
        inputArea.sendKeys(text);

        System.out.println("");
    }

    public String getInputText(){
        return driver.findElement(By.id("tinymce")).getText();
    }
}

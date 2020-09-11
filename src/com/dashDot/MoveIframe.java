package com.dashDot;

import org.openqa.selenium.By;

public class MoveIframe extends Main {
    public void miFrame(){
        driver.get("http://localhost:7080/iframe");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='mce_0_ifr']")));

        driver.findElement(By.xpath("//*[@id='tinymce']/p")).sendKeys("Hello");
    }
}

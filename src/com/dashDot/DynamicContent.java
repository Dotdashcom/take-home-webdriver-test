package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicContent extends Main {

    public void dynamic(){
        driver.get("http://localhost:7080/dynamic_content");
        //usually for finding dynamic content we use some text that is stable.
        // here the div class name is stable
        driver.findElement(By.xpath("//*[@id='content']/div/p[2]/a")).click();
        WebElement content = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
        System.out.println(content.getText());
        //driver.findElement(By.linkText("click here")).click();

    }
}

package com.dotdash;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class Test7DynamicContent extends BaseMethod{

    @Test
    public void DynamicContent(){
        driver.get("http://localhost:7080/dynamic_content");
        WebElement element = driver.findElement(By.xpath("//div[@class='large-10 columns']"));

        element.getText();

    }




}

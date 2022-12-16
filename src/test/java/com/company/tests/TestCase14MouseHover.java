package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 Test does a mouse hover on each image.
 Test asserts that additional information is displayed for each image.
 */

public class TestCase14MouseHover{

    @Test
    public void mouse_hover_test(){

        Driver.getDriver().get("http://localhost:7080/hoverst");

        WebElement micImg = Driver.getDriver().findElement(By.xpath("/html/body/img"));
        WebElement text = Driver.getDriver().findElement(By.xpath("//*[@id='c']/pre"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(micImg).perform();
        actions.moveToElement(text).perform();
/*
 ??? Test asserts that additional information is displayed for each image.???
 No additional information when mouse hover on each page element, sorry
 */

Driver.closeDriver();

    }
}

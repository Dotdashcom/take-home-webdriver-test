package com.project.tests;

import com.project.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptError {

    @Test
    public void JSError(){

        Driver.getDriver().get("http://localhost:7080/javascript_error");

        Driver.getDriver().manage().window().maximize();

    WebElement errorMessage =    Driver.getDriver().findElement(By.tagName("p"));

        Assert.assertEquals(errorMessage.getText(),"This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");

    }





}

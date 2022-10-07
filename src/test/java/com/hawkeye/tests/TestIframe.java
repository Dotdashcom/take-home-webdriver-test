package com.hawkeye.tests;

import com.hawkeye.pages.IframePage;
import com.hawkeye.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIframe {

    IframePage iframe =new IframePage();

    @Test
    public void IframeTest(){

        Driver.getDriver().get("http://localhost:7080/iframe");

        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().switchTo().frame(0);

        System.out.println(iframe.text.getText());

        Assert.assertEquals(iframe.text.getText(),"Your content goes here.");

        Driver.closeDriver();

    }



}

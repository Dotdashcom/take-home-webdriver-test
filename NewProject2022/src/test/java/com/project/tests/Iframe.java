package com.project.tests;

import com.project.pages.IframePage;
import com.project.utility.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe {

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

package com.project.tests;

import com.project.pages.DynamicContentPage;
import com.project.utility.Driver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContent {

    DynamicContentPage dynamic =new DynamicContentPage();

    @Test
    public void CheckDynamicText1(){

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        Driver.getDriver().manage().window().maximize();


        String Text =  dynamic.DynamicText1.getText();


        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();



      String TextAfterRefresh =  dynamic.DynamicText1.getText();


      Assert.assertNotEquals(Text,TextAfterRefresh);

        Driver.closeDriver();

    }

    @Test
    public void CheckDynamicText2(){

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        Driver.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicText2.getText();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicText2.getText();

        Assert.assertNotEquals(Text,TextAfterRefresh);

        Driver.closeDriver();

    }

    @Test
    public void CheckDynamicText3(){

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        Driver.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicText3.getText();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicText3.getText();

        Assert.assertNotEquals(Text,TextAfterRefresh);

        Driver.closeDriver();

    }

    @Test
    public void CheckDynamicPicture1() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        Driver.getDriver().manage().window().maximize();

        Thread.sleep(3000);

        String Text =  dynamic.DynamicPicture1.getAttribute("src");

        Thread.sleep(3000);

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicPicture1.getAttribute("src");

        Assert.assertNotEquals(Text,TextAfterRefresh);

        Driver.closeDriver();

    }

    @Test
    public void CheckDynamicPicture2() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        Driver.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicPicture2.getAttribute("src");

        Thread.sleep(3000);

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicPicture2.getAttribute("src");

        Assert.assertNotEquals(Text,TextAfterRefresh);

        Driver.closeDriver();

    }

    @Test
    public void CheckDynamicPicture3() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        Driver.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicPicture3.getAttribute("src");

        Thread.sleep(3000);

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        Driver.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicPicture3.getAttribute("src");

        Assert.assertNotEquals(Text,TextAfterRefresh);

        Driver.closeDriver();
    }



}

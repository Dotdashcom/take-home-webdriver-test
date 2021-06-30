package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DynamicContentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentTest_7 extends BaseClass {
    
    @Test
    public void DynamicContentTest()  {
        driver.get(baseURL);
        DynamicContentPage dynamicContent = new DynamicContentPage(driver);

        dynamicContent.clickDynamicContentLink();

        dynamicContent.checkText1();
        WebElement dynamicContentText1 = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]"));
        String text1 = dynamicContentText1.getText();
        String text2 = dynamicContentText1.getText();
        if (!text1.equals(text2)) {
            Assert.assertTrue(true);
        } else
            Assert.assertFalse(false);


        dynamicContent.checkText2();
        WebElement dynamicContentText2 = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]"));
        String text3 = dynamicContentText2.getText();
        String text4 = dynamicContentText2.getText();
        if (!text3.equals(text4)) {
            Assert.assertTrue(true);
        } else
            Assert.assertFalse(false);


        dynamicContent.checkText3();
        WebElement dynamicContentText3 = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
        String text5 = dynamicContentText3.getText();
        String text6 = dynamicContentText3.getText();
        if (!text5.equals(text6)) {
            Assert.assertTrue(true);
        } else
            Assert.assertFalse(false);

    }

}

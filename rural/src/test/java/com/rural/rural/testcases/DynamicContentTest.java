package com.rural.rural.testcases;

import com.rural.rural.pages.DynamicContentPage;
import com.rural.rural.SeleniumTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicContentTest {
    private WebDriver driver;
    private DynamicContentPage dynamicContentPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/dynamic_content");

        dynamicContentPage = new DynamicContentPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void DynamicContent() {


        String img1A = dynamicContentPage.image1.getAttribute("src");
        String img2A = dynamicContentPage.image2.getAttribute("src");
        String img3A = dynamicContentPage.image3.getAttribute("src");

        String text1A= dynamicContentPage.text1.getText();
        String text2A= dynamicContentPage.text2.getText();
        String text3A= dynamicContentPage.text3.getText();

        dynamicContentPage.linkClickHere.click();

        String img1B = dynamicContentPage.image1.getAttribute("src");
        String img2B = dynamicContentPage.image2.getAttribute("src");
        String img3B = dynamicContentPage.image3.getAttribute("src");

        String text1B= dynamicContentPage.text1.getText();
        String text2B= dynamicContentPage.text2.getText();
        String text3B= dynamicContentPage.text3.getText();

        boolean imgFlag=false;
        boolean txtFlag=false;

        if(img1A!=img1B || img2A!=img2B || img3A!=img3B){
            imgFlag=true;
        }

        Assert.assertTrue(imgFlag==true, "the images has no changes");


        if(text1A!=text1B || text2A!=text2B || text3A!=text3B){
            txtFlag=true;
        }

        Assert.assertTrue(txtFlag==true, "the text has no changes");
        // close the browser
        driver.quit();

    }



}

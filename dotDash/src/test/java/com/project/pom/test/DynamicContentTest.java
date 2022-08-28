package com.project.pom.test;

import com.project.pom.page.DynamicContent;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class DynamicContentTest {

    private WebDriver driver;
    DynamicContent dynamicContent;

    @Before
    public void setUp(){
        dynamicContent = new DynamicContent(driver);
        driver = dynamicContent.chromeDriverConnection();
        dynamicContent.visit("/dynamic_content");
    }

    @Test
    public void DynamicContentTest(){
        String text1 = dynamicContent.getTextDinamic();
        String text2 = dynamicContent.getTextDinamic();
        if (text1 != text2){
            String text3 = dynamicContent.getTextDinamic();
            if (text3 != text2){
                System.out.println("Successful");
            }
        }else {
            System.out.println("there is an error");
        }
    }

    @After
    public void end(){ driver.quit(); }
}

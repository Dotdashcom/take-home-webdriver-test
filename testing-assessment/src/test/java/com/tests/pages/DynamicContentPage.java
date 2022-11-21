package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage{


    @FindBy(xpath = "(//div[@id='content'])[2]")
    private WebElement contentInput;



    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/dynamic_content ");
    }


    @Test
    public void refreshThePage(){
        waitForVisibilityOf(contentInput);
        int count = 0;
        while (count<= 3){
            String contentText = contentInput.getText();
            System.out.println("\n" + count + " content text is: \n" + contentText);
             DriverTest.getDriver().navigate().refresh();
             count++;
        }
    }
}

package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPage extends BasePage {


    @FindBy(xpath = "//div[@class='figure']")
    private List<WebElement> figuresInputs;



    @BeforeClass
    public static void setUp() {
        DriverTest.getDriver().get("http://localhost:7080/hovers");
    }


    @Test
    public void hoverOverTheImage() {

        figuresInputs.stream()
                .forEach(element -> {
                    actions.moveToElement(element).perform();
                    String imageTextMessage = element.getText();
                    Assert.assertFalse("!!! No text present for the image !!!", imageTextMessage.isEmpty());
                    System.out.println("\n-> image text message is: " + imageTextMessage);
                });
    }


    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}

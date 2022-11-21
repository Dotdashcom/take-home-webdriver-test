package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;


public class OpenInNewTapPage extends BasePage {

    @FindBy(xpath = "//a[.='Click Here']")
    private WebElement linkInput;

    @FindBy(xpath = "//h3[.='New Window']")
    private WebElement newTabTextInput;


    @BeforeClass
    public static void setUp() {
        DriverTest.getDriver().get("http://localhost:7080/windows");
    }

    @Test
    public void clickHereLink() throws Exception{
        waitForVisibilityOf(linkInput);
        linkInput.click();
        ArrayList<String> handles = new ArrayList<>(DriverTest.getDriver().getWindowHandles());
        DriverTest.getDriver().switchTo().window(handles.get(1));

        waitForVisibilityOf(newTabTextInput);
        String newTabText = newTabTextInput.getText();
        System.out.println("-> New tab text is: " + newTabTextInput.getText());
        Assert.assertTrue(newTabText.contains("New Window"));
    }


    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}

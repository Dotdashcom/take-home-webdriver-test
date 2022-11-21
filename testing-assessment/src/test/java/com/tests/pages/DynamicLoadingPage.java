package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BasePage{


  @FindBy(xpath = "//button")
  private WebElement startButtonInput;

  @FindBy(id = "finish")
  private WebElement successMessageInput;



    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/dynamic_loading/2 ");
    }


    @Test
    public void clickOnStartButton(){
        waitForVisibilityOf(startButtonInput);
        startButtonInput.click();
        wait.until(ExpectedConditions.invisibilityOf(startButtonInput));
        waitForVisibilityOf(successMessageInput);
         String successMessage = successMessageInput.getText();
        Assert.assertTrue(successMessage.contains("Hello World"));
        System.out.println("-> success message is: " + successMessage);

    }


    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}

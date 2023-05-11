package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.DynamicLoadingPage;
import task.utilities.BrowserUtils;
import task.utilities.Driver;

import java.time.Duration;

public class DynamicLoading {


    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    String expectedText = "Hello World!";
    String actualText;

    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");
    }


    @Test
    public void testDynamicLoading(){

        BrowserUtils.waitForVisibility(dynamicLoadingPage.startButton, 10);
        dynamicLoadingPage.startButton.click();

        BrowserUtils.waitForVisibility(dynamicLoadingPage.textMessage, 10);

        actualText = dynamicLoadingPage.textMessage.getText();
        Assertions.assertEquals(expectedText, actualText);

    }




    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }
}

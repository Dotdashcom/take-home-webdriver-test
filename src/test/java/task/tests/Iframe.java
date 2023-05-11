package task.tests;

import jdk.swing.interop.LightweightFrameWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.IframePage;
import task.utilities.Driver;


public class Iframe {


    IframePage iframePage = new IframePage();
    String expectedText = "This is the text area!";
    String actualText;


    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/iframe");
    }


    @Test
    public void testIframe(){

        Driver.getDriver().switchTo().frame(iframePage.iframe);

        iframePage.textArea.clear();
        iframePage.textArea.sendKeys(expectedText);


        actualText = iframePage.textArea.getText();

        Assertions.assertEquals(expectedText,actualText);

    }


    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }
}

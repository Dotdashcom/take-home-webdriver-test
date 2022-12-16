package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 Test switches to Iframe and types some text.
 Test asserts that the typed text is as expected.
 */

public class TestCase13Iframe {

    @Test
    public void iframeTest() {

        Driver.getDriver().get("http://localhost:7080/iframe");

        Driver.getDriver().switchTo().frame("mce_0_ifr");

        WebElement commentBody = Driver.getDriver().findElement(By.id("tinymce"));

        commentBody.clear();

        commentBody.sendKeys("Hello World");
        assertEquals(commentBody.getText(),"Hello World");

        Driver.getDriver().switchTo().parentFrame();

        WebElement headerText = Driver.getDriver().findElement(By.tagName("h3"));
        assertTrue(headerText.isDisplayed(),"Header text did not appear!");

        String actualHeader = headerText.getText();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        assertEquals(actualHeader,expectedHeader,"Header text did not appear correctly!");

        Driver.closeDriver();
    }
}

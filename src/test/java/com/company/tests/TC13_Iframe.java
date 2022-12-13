package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC13_Iframe extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {
//          2- Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

        // NOSuchElement exception comes with reasons: 1- Not locationg correctly element
        //                                              2- There is a iframe and you have switch to frame to reach this element


//          3- Clear text from comment body

        // we can use frame(id) method with id arg.
        driver.switchTo().frame("mce_0_ifr");

        // we can use frame(locator)
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        // we can use frame(index) : index starts from 0
        // we can find iframe tags from html with using xpath "//iframe"
        //driver.switchTo().frame(0);


        WebElement commentBody = driver.findElement(By.id("tinymce"));
        // clear() method delete text form comment body.
        commentBody.clear();
        //Thread.sleep(3000);

//          4- Type "Hello World" in comment body
        commentBody.sendKeys("Hello World");

//          5- Verify "Hello World" text is written in comment body
        assertEquals(commentBody.getText(),"Hello World");

        // if you have nested frame and if you want to switch 1 frame to direct parent of this frame we are using parentFrame() method
        driver.switchTo().parentFrame();

        // defaultContent() method will switch to main HTML (Parent of all HTML)
        //driver.switchTo().defaultContent();

//          6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
        WebElement headerText = driver.findElement(By.tagName("h3"));
        assertTrue(headerText.isDisplayed(),"Header text did not appear!");

        String actualHeader = headerText.getText();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";

        assertEquals(actualHeader,expectedHeader,"Header text did not appear correctly!");

    }
}

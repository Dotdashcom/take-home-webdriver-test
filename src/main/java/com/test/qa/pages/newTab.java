package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class newTab extends TestBase {

    @FindBy(linkText = "Multiple Windows")
    WebElement multipleWindowsButton;

    @FindBy(xpath = "//a[.='Click Here']")
    WebElement clickHere;

    @FindBy(tagName = "h3")
    WebElement header;

    public newTab() {
        PageFactory.initElements(driver, this);
    }

    public void windowPage() {


        String wh1 = driver.getWindowHandle();
        clickHere.click();

        Set<String> nwh = driver.getWindowHandles();
        for (String wh : nwh) {
            driver.switchTo().window(wh);
        }
        String wh2 = driver.getWindowHandle();
        String expected_title_or_message = "New Window";
        String actual_title = driver.getTitle();
        String actual_message = header.getText();
        // Assert.assertEquals(actual_title, expected_title_or_message, "wrong page");
        // Assert.assertEquals(actual_message, expected_title_or_message, "wrong message");

    }
}


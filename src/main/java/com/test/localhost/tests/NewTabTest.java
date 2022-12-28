package com.test.localhost.tests;

import com.test.localhost.pages.NewTabPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class NewTabTest extends TestBase {
    @Test
    public void windowHandleTest() {
        NewTabPage newTabPage = new NewTabPage(driver);
        newTabPage.clickButtons();
       Assert.assertEquals(newTabPage.validateNewHeader(driver),"New Window");
    }
}

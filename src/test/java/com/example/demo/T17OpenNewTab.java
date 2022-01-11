package com.example.demo;

import pages.OpenNewTabPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

public class T17OpenNewTab extends TestMain{
    public static final String NEW_WINDOW = "New Window";
    OpenNewTabPage openNewTabPage;
    String newTabUrl = "http://localhost:7080/windows/new";

    @Test
    public void testOpenNewTab(){
        openNewTabPage = new OpenNewTabPage(driver);
        openNewTabPage.clickText();
        List<String> browserTabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        String newWindowMessage = openNewTabPage.getNewWindowText();

        Assert.assertEquals(browserTabs.size(), 2);
        Assert.assertEquals(driver.getCurrentUrl(), newTabUrl);
        Assert.assertEquals(newWindowMessage, NEW_WINDOW);

    }
}
package com.web.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.ContextMenuPage;


public class ContextMenuTest extends TestBase{
    ContextMenuPage contextMenuPage;

    public ContextMenuTest(){
        super();
    }

    @BeforeMethod
    public void setUp()  {
        initialization();
        driver.get("http://localhost:7080/context_menu");
        contextMenuPage = new ContextMenuPage();
    }


    @Test()
    public void contextMenuTest () {

        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuPage.contextMenuClick()).build().perform();
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
        driver.switchTo().alert().accept();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

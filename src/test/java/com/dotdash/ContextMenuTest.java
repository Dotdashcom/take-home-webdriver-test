package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenuTest extends Util {
	
	protected ContextMenuPage contextMenuPage;

	@BeforeClass
    public void setUp(){
        driver = getDriver();
        contextMenuPage = PageFactory.initElements(driver, ContextMenuPage.class);
    }

    @Test
    public void test_Right_Click(){
        contextMenuPage.rightClickOnContextMenuBox();
        Assert.assertEquals(contextMenuPage.alertMenuText(), "You selected a context menu");
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void endTest(){
        teardown();
    }
}

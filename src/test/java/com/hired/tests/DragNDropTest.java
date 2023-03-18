package com.hired.tests;

import com.dotdash.pages.BasePage;
import com.dotdash.pages.DragNDropPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragNDropTest extends BasePage {
    public WebDriver driver;
    DragNDropPage dragNDropPage;
    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        driver.get(prop.getProperty("dragAndDropUrl"));
    }

    @Test
    public void validateDragNDrop()  {

        dragNDropPage= new DragNDropPage(driver);
        dragNDropPage.dragAndDrop(dragNDropPage.getText("a"), dragNDropPage.getText("b"));
       Assert.assertEquals(dragNDropPage.getText("a").getText(), "B");
        Assert.assertEquals(dragNDropPage.getText("b").getText(), "A");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

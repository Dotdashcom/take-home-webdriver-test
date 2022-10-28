package com.internet.Tests;

import com.internet.base.Baseclass;
import com.internet.pages.DragAndDropPage;
import com.internet.pages.TheInternetPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropPageTest extends Baseclass {

    TheInternetPage internet;
    DragAndDropPage dragAndDrop;

    @BeforeMethod
    public void startBrowserSession() {
        intialization();
        internet = new TheInternetPage(webdriver, true);
        dragAndDrop = internet.clickDragAndDrop();
    }

    @Test
    public void dragAndDropPerform() throws InterruptedException {
        //((Proxywrapper) webdriver).action.dragAndDrop(dragAndDrop.getColumnA(), dragAndDrop.getColumnB()).perform();
        dragAndDrop.dragColumnAtoColumnB();
        Assert.assertEquals(dragAndDrop.getColumnAText(), "B");
        Assert.assertEquals(dragAndDrop.getColumnBText(), "A");
    }

    @AfterMethod
    public void quitBrowserSession() {
        quitBrowser();
    }
}



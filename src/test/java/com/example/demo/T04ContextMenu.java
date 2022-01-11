package com.example.demo;

import pages.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T04ContextMenu extends TestMain{
    ContextMenuPage contextMenuPage;

    @Test
    public void testContextMenu(){
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.rightClick();
        Alert alert = driver.switchTo().alert();
        String textEdit = alert.getText();
        Assert.assertEquals(textEdit,"You selected a context menu");
    }
}

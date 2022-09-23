package com.dotdash.tests;


import com.dotdash.pages.ContextMenuPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;


public class ContextMenuTest extends TestBase {


    @Test
    public void contextMenuTest() {

        ContextMenuPage contextMenuPage = new ContextMenuPage();
        contextMenuPage.navigatePages("Context Menu");
        Actions actions = new Actions(Driver.getDriver());

        actions.contextClick(contextMenuPage.square).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        Assertions.assertEquals("You selected a context menu", alertText);

    }


}

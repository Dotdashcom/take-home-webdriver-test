package com.dotdash.tests;

import com.dotdash.pages.ContextMenuPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test04_ContextMenu {

    /**
     * Test right clicks on the context menu.
     * Test asserts the alert menu text.
     */

    @Test
    public void contextMenuTest(){

        ContextMenuPage contextMenuPage = new ContextMenuPage();

        String url = ConfigurationReader.getProperty("base.url") + "/context_menu";
        Driver.getDriver().get(url);

        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(contextMenuPage.box).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");

        Driver.closeDriver();

    }

}

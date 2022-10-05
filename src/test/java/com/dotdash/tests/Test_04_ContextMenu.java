package com.dotdash.tests;


import com.dotdash.base.TestBase;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import com.dotdash.pages.ContextMenuPage;


public class Test_04_ContextMenu extends TestBase {
    @Test
    public void context_menu_test() {
        ContextMenuPage contextMenuPage = new ContextMenuPage();
        contextMenuPage.navigatePages("Context Menu");
        Actions actions = new Actions(DriverUtils.getDriver());

        actions.contextClick(contextMenuPage.square).perform();

        Alert alert = DriverUtils.getDriver().switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        Assertions.assertEquals("You selected a context menu", alertText);

    }

}

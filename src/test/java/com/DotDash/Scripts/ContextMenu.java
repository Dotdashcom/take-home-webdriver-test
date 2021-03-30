package com.DotDash.Scripts;

import com.DotDash.Pages.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class ContextMenu extends basePage {

    @Test
    public void contextmenu() {
        driver.get(baseURL + "/context_menu");

        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);

        Actions act = new Actions(driver);
        act.contextClick(contextMenuPage.boxContext).build().perform();

        Alert alert = driver.switchTo().alert();

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(alert.getText().contains("You selected a context menu"), true, "Test Passed!!");

        assertion.assertAll();

        alert.accept();


    }

}

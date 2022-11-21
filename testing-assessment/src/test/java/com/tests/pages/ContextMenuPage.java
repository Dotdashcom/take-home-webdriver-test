package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class ContextMenuPage extends BasePage{


    @FindBy(id = "hot-spot")
    private WebElement boxInput;



    @BeforeClass
    public static void setUp() {
        DriverTest.getDriver().get("http://localhost:7080/context_menu");
    }


    @Test
    public void rightClickContextMenu(){
        waitForVisibilityOf(boxInput);
        actions.contextClick(boxInput).perform();

        Alert alert = DriverTest.getDriver().switchTo().alert();
         String alertMessage = alert.getText();
        Assume.assumeTrue(alertMessage.contains("You selected a context menu"));
        System.out.println("-> alert message is: " + alertMessage);
        alert.accept();
    }

    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}

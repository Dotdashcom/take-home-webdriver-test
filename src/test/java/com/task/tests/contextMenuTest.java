package com.task.tests;

import com.task.pages.contextMenuPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class contextMenuTest {

    contextMenuPage contextMenuPage = new contextMenuPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/context_menu");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void context_Menu() {

        Actions actions = new Actions(Driver.getDriver());

        actions.contextClick(contextMenuPage.right_Click_Box).build().perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        String alertMessage = alert.getText();
        String expectedMessage = "You selected a context menu";

        Assert.assertEquals(alertMessage, expectedMessage);

        alert.accept();
    }

}

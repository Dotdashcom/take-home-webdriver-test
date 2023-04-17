package com.rural.rural.testcases;

import com.rural.rural.pages.DragAndDropPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropTest {
    private WebDriver driver;
    private DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/drag_and_drop");

        dragAndDropPage = new DragAndDropPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void ContextMenuTest() {

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragAndDropPage.ColumnA, dragAndDropPage.ColumnB).build().perform();

        Assert.assertTrue(dragAndDropPage.ColumnB.getText().equals("B"), "Drag and Drop was successful!");


        // close the browser
        driver.quit();

    }



}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DragAndDropPage;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DragAndDropTests extends TestBase {
    String url="drag_and_drop";
    DragAndDropPage dragAndDropPage=new DragAndDropPage();
    @BeforeTest
    public void setUrl(){
        Driver.setUp(url);
    }

    @Test
    public void switchSquares() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragAndDropPage.box1).
                moveToElement(dragAndDropPage.box2).release(dragAndDropPage.box1).perform();
        Assert.assertEquals(dragAndDropPage.box1.getText(),"B");
        }


    }


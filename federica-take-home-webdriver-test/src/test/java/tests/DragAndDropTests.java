package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class DragAndDropTests extends TestBase {
    DragAndDropPage dragAndDropPage=new DragAndDropPage();
    String url="/drag_and_drop";
    //TODO finish test
    @Test
    public void switchSquares() {
        Driver.setUp(url);
        WebElement source=Driver.getDriver().findElement(By.id("column-a"));
        WebElement target=Driver.getDriver().findElement(By.id("column-b"));
        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(source).
                moveToElement(target).release().perform();
        Assert.assertTrue(source.getText().equals("B"));
    }
    }


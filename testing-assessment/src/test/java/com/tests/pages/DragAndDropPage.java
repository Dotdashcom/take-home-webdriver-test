package com.tests.pages;

import com.tests.util.DriverTest;
import io.cucumber.java.BeforeAll;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class DragAndDropPage extends BasePage{


    @FindBy(xpath = "//div[.='A']")
    private WebElement columnAInput;

    @FindBy(xpath = "//div[.='B']")
    private WebElement columnBInput;

    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get(" http://localhost:7080/drag_and_drop ");
    }

    //TODO: Drag and drop not working!!!!
    @Test
    public void dragAToB() {
    waitForVisibilityOf(columnAInput);

      int x = columnAInput.getLocation().x;
      int y = columnBInput.getLocation().y;
            //actions.dragAndDrop(columnAInput,columnBInput).build().perform();

//         Action dragAndDrop = actions.clickAndHold(columnAInput).moveToElement(columnBInput).release(columnBInput).build();
//          dragAndDrop.perform();

    //actions.moveToElement(columnAInput).clickAndHold().pause(Duration.ofSeconds(3)).moveToElement(columnBInput).release().build().perform();


    }
}

package com.project.tests;

import com.project.pages.DragAndDropPage;
import com.project.utility.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {

    DragAndDropPage dragAndDrop= new DragAndDropPage();

    @Test
    public void Switch () throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/drag_and_drop");

        Driver.getDriver().manage().window().maximize();

        Actions actions = new Actions(Driver.getDriver());



       actions.clickAndHold(dragAndDrop.FirstColumn).moveToElement(dragAndDrop.SecondColumn).release().build().perform();

               //.moveToElement(dragAndDrop.SecondColumn).pause(1000).release().build().perform();

     //  actions.dragAndDrop(dragAndDrop.FirstColumn, dragAndDrop.SecondColumn).build().perform();

        Thread.sleep(4000);

        System.out.println(dragAndDrop.FirstColumn.getText());

        Thread.sleep(4000);

        Assert.assertEquals(dragAndDrop.SecondColumn.getText(),"B");

       Assert.assertEquals(dragAndDrop.FirstColumn.getText(),"A");

        Driver.closeDriver();

    }


}

package com.task.tests;

import com.task.pages.dragAndDropPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dragAndDropTest {

    com.task.pages.dragAndDropPage dragAndDropPage = new dragAndDropPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/drag_and_drop");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void drag_And_Drop() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n"
                +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n"
                +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n"
                +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n"
                +"\n" +"function dispatchEvent(element, event,transferData) {\n"
                +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n"
                +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n"
                +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n"
                +"function simulateHTML5DragAndDrop(element, destination) {\n"
                +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n"
                +"var dropEvent = createEvent('drop');\n"
                +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                +"var dragEndEvent = createEvent('dragend');\n"
                +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n"
                +"var source = arguments[0];\n" +"var destination = arguments[1];\n"
                +"simulateHTML5DragAndDrop(source,destination);",dragAndDropPage.fromColumnA, dragAndDropPage.toColumnB);
        Thread.sleep(1500);

        String ColumnAText = dragAndDropPage.fromColumnA.getText();
        String ColumnBText = dragAndDropPage.toColumnB.getText().trim();

        String expectedTextAfterAction = "A";

        System.out.println( "from :"+ ColumnAText + "  to :" + ColumnBText );

        System.out.println(ColumnBText);
        System.out.println(expectedTextAfterAction);
        Assert.assertEquals( ColumnBText , expectedTextAfterAction );


    }






}

package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.attribute.standard.Destination;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

public class TC_005_DragAndDrop extends BaseClass
{
    @Test (priority=5) //Test Case for Drag and Drop
    public void DragAndDrop() throws InterruptedException
    {

        // Read drag_and_drop_helper.js file to the variable str
        String jsstr="";
        File jsfile = new File("C:\\Users\\shahi\\Downloads\\drag_and_drop_helper.js");
        try {
            FileInputStream in=new FileInputStream(jsfile);
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            jsstr =new String(buffer,"GB2312");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Launching Drag and Drop URL
        driver.get(BaseUrl+"drag_and_drop");

        //Javascript Executor for HTML5
        JavascriptExecutor js=(JavascriptExecutor)driver;

        //Simulate Drag and Drop to swap Col-B with Col-A
        js.executeScript(jsstr +"$('#column-a').simulateDragDrop({dropTarget: '#column-b'});");

        //Assertion to check Column-A and Column-B for correct contents
        Assert.assertTrue(driver.findElement(By.id("column-a")).getText().contains("B"));
        Assert.assertTrue(driver.findElement(By.id("column-b")).getText().contains("A"));

        //Simulate Drag and Drop to swap Col-A with Col-B
        js.executeScript(jsstr +"$('#column-b').simulateDragDrop({dropTarget: '#column-a'});");

        //Assertion to check Column-A and Column-B for correct contents
        Assert.assertTrue(driver.findElement(By.id("column-a")).getText().contains("A"));
        Assert.assertTrue(driver.findElement(By.id("column-b")).getText().contains("B"));

    }
}

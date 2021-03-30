package com.DotDash.Scripts;

import com.DotDash.Pages.DragandDropPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;

import java.util.concurrent.TimeUnit;

public class DragAndDrop extends basePage {

    @Test
    public void dragAnddrop() throws InterruptedException {

        driver.get(baseURL + "/drag_and_drop");


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        DragandDropPage dragandDropPage = new DragandDropPage(driver);

        dragAndDropSwapColumn();




        SoftAssert assertion = new SoftAssert();

        assertion.assertTrue(dragandDropPage.getheaderA().equals("B") && dragandDropPage.getheaderB().equals("A"));

        assertion.assertAll();
    }
    private void dragAndDrop(WebElement from, WebElement to) {
        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";

        ((JavascriptExecutor)driver).executeScript(java_script, from, to);
    }
    public void dragAndDropSwapColumn() {
        WebElement columnABox = driver.findElement(By.id("column-a"));
        WebElement columnBBox = driver.findElement(By.id("column-b"));
        dragAndDrop(columnABox, columnBBox);
    }
}

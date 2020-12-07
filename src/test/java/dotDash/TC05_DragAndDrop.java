package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.time.Duration;
import java.util.HashMap;

public class TC05_DragAndDrop extends BaseClass {

    @Test
    public void dragAndDrop() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "DragAndDrop");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Drag element A to element B
        Actions action = new Actions(driver);
        WebElement elemA = driver.findElement(By.xpath("//div[@id='column-a']/header"));
        WebElement elemB = driver.findElement(By.xpath("//div[@id='column-b']/header"));

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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(java_script, elemA, elemB);

        //Header Value after drag and drop
        String headerFirst = driver.findElement(By.xpath("//*[@id='column-a']/header")).getText();
        String headerSecond = driver.findElement(By.xpath("//*[@id='column-b']/header")).getText();
        //Assertion
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(headerFirst.equals("B") && headerSecond.equals("A"));
        assertion.assertAll();
    }
}

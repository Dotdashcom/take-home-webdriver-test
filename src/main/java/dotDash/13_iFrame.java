package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseClass;

import java.util.HashMap;

public class 13_iFrame extends BaseClass {

    @Test
    public void iFrame() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "iFrame");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Switch to iFrame
        driver.switchTo().frame("mce_0_ifr");
        //Clear text
        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys(testData.get("Text"));
        //Assertion
        Assert.assertEquals(editor.getText(),testData.get("Text"));
    }
}
package dotDash;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.util.HashMap;

public class TC15_JavascriptAlerts extends BaseClass {

    @Test
    public void javascriptAlerts() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "JavascriptAlert");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        SoftAssert assertion = new SoftAssert();
        //JS Alert
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertion.assertEquals(driver.findElement(By.id("result")).getText(),"You successfuly clicked an alert");
        //JS Confirm
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        alert.accept();
        assertion.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");
        //JS Prompt
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        alert.sendKeys(testData.get("Text"));
        alert.accept();
        assertion.assertEquals(driver.findElement(By.id("result")).getText(),testData.get("Text"));
    }
}

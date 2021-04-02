package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.utilities.BaseClass;

import java.util.HashMap;

public class TC108_DynamicLoading extends BaseClass {

    @Test
    public void dynamicLoading() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "DynamicLoading");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Click Start
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(),"Hello World!");
        assertion.assertAll();
    }
}
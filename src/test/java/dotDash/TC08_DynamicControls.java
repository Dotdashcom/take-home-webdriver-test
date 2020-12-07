package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.util.HashMap;

public class TC08_DynamicControls extends BaseClass {

    @Test
    public void dynamicControls() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "DynamicControls");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));

        //Remove Checkbox
        SoftAssert assertion = new SoftAssert();
        //Click Remove
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        //Wait till checkbox is removed
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //Validate checkbox is removed
        assertion.assertTrue(driver.findElements(By.id("checkbox")).size()==0);

        //Add Checkbox
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        //Wait till checkbox is added back
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //Validate checkbox is added
        assertion.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed());

        //Enable textbox
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        //Wait till textbox is enabled
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //Validate textbox is enabled
        assertion.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

        //Disable textbox
        driver.findElement(By.xpath("//button[contains(text(),'Disable')]")).click();
        //Wait till textbox is disabled
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //Validate textbox is disabled
        assertion.assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

        assertion.assertAll();
    }
}

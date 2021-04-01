package dotDash;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.util.HashMap;

public class 4_ContextMenu extends BaseClass {

    @Test
    public void contextMenu() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "ContextMenu");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Right click
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
        //Capture alert message
        Alert alert = driver.switchTo().alert();
        //Assertion
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(alert.getText().contains("You selected a context menu"),true,"Alert not displayed");
        assertion.assertAll();
        //Click Ok to close the alert
        alert.accept();
    }
}
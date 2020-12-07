package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.util.HashMap;

public class TC06_Dropdown extends BaseClass {

    @Test
    public void dropdown() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "Dropdown");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Select Option1 from dropdown
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Option 1");
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(dropDown.getText().contains("Option 1"));
        //Select Option2 from dropdown
        select.selectByVisibleText("Option 2");
        assertion.assertTrue(dropDown.getText().contains("Option 2"));
        assertion.assertAll();
    }
}

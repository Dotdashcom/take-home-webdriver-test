package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.utilities.BaseClass;

import java.util.HashMap;

public class TC102_Checkboxes extends BaseClass {

    @Test
    public void checkboxes() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "Checkboxes");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Check checkbox1
        WebElement chkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        chkbox1.click();
        //Soft assert
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(chkbox1.isSelected(),"Checkbox1 is not checked");
        //UnCheck checkbox2
        WebElement chkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        chkbox2.click();
        assertion.assertFalse(chkbox2.isSelected(),"Checkbox2 is checked");
        assertion.assertAll();
    }
}
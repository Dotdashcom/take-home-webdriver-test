package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.util.HashMap;

public class TC12_FloatingMenu extends BaseClass {

    @Test
    public void floatingMenu() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "FloatingMenu");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Assertion to test floating menu is displayed on top
        WebElement floatingmenu = driver.findElement(By.id("menu"));
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(floatingmenu.isDisplayed());
        //Scroll to end of page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        //Assertion after scrolling
        assertion.assertTrue(floatingmenu.isDisplayed());
        assertion.assertAll();
    }
}

package dotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;

import java.util.HashMap;
import java.util.List;

public class 14_MouseHover extends BaseClass {

    @Test
    public void mouseHover() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "MouseHover");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        Actions action = new Actions(driver);
        SoftAssert assertion = new SoftAssert();
        //Image 1
        action.moveToElement(driver.findElement(By.xpath("//div[@class='example']/div[1]"))).build().perform();
        assertion.assertTrue(driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).isDisplayed());
        //Image 2
        action.moveToElement(driver.findElement(By.xpath("//div[@class='example']/div[2]"))).build().perform();
        assertion.assertTrue(driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).isDisplayed());
        //Image 3
        action.moveToElement(driver.findElement(By.xpath("//div[@class='example']/div[3]"))).build().perform();
        assertion.assertTrue(driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).isDisplayed());

    }
}
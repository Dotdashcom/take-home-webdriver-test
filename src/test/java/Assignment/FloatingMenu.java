package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FloatingMenu extends TestBase {

    @Test
    public void floatingMenuTest(){


        driver.get(baseUrl + "/floating_menu");


        JavascriptExecutor js =  (JavascriptExecutor) driver;


        List<WebElement> listOfFloatingMenuOptions = driver.findElements(By.xpath("//div[@id='menu']//li"));

        js.executeScript("window.scrollBy(0,350)", "");

        try {
            for (WebElement option : listOfFloatingMenuOptions) {
                Assert.assertTrue(option.isDisplayed() , option.getText() + " menu option displayed FAILED!");
            }
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("menu options are not visible!");
        }
    }


    }


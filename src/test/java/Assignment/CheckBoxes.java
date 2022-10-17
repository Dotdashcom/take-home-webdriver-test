package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxes extends TestBase {

    @Test
    public void checkBoxesTest(){

        driver.get(baseUrl + "/checkboxes");

        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//form[@id='checkboxes']//input[@type='checkbox']"));

        try {
            for (WebElement element : allCheckBoxes) {
                if (!element.isSelected()) {
                    element.click();
                } else {
                    element.click();
                    element.click();
                }
                Assert.assertTrue(element.isSelected() , "Checkbox selection test FAILED!");
            }
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("no web elements in the list");
        }
    }

    }




package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.util.List;
@Test
public class CheckBoxesTest extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://localhost:7080/checkboxes");

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        //looping through all checkboxes
        for (WebElement cb : checkBoxes) {
            if (!cb.isSelected()) //clicking on unchecked checkboxes only
                cb.click();
            Thread.sleep(2000);

            //checking if checkboxes are selected
            Assert.assertTrue(cb.isSelected());
            System.out.println("Checkbox is selected");

            //checking if checkboxes are not selected
                cb.click();
            Assert.assertFalse(cb.isSelected());
            System.out.println("Checkbox is unchecked");
        }
        tearDown();
    }
}







package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;


import java.util.concurrent.TimeUnit;

public class Checkboxes {

        public Checkboxes() {
        }

        @BeforeMethod
        public void setUp() {
            Driver.get().get(ConfigurationReader.get("baseUrl") + "checkboxes");
            Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        }



        @Test
        public void checkAndUncheckBoxesTest() {
            WebElement firstCheckbox = Driver.get().findElement(By.xpath("//input[1]"));
            WebElement secondCheckbox = Driver.get().findElement(By.xpath("//input[2]"));

            System.out.println("firstCheckbox.isSelected() = " + firstCheckbox.isSelected());
            System.out.println("secondCheckbox.isSelected() = " + secondCheckbox.isSelected());

            Assert.assertFalse(firstCheckbox.isSelected(), "Verify firstCheckbox isn't selected");
            Assert.assertTrue(secondCheckbox.isSelected(), "Verify secondCheckbox is selected");

            firstCheckbox.click();
            secondCheckbox.click();

            Assert.assertTrue(firstCheckbox.isSelected(), "Verify firstCheckbox is selected");
            Assert.assertFalse(secondCheckbox.isSelected(), "Verify secondCheckbox is selected");

            System.out.println("firstCheckbox.isSelected() = " + firstCheckbox.isSelected());
            System.out.println("secondCheckbox.isSelected() = " + secondCheckbox.isSelected());
        }
    }



package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Constants;

public class Checkboxes extends Constants {

    static String url = "http://localhost:7080/checkboxes";


    @Test
    public static void testCheckbox() {
        driver.get(url);

        WebElement firstCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        firstCheckbox.click();
        boolean isChecked = firstCheckbox.isSelected();
        sa.assertEquals(isChecked, true);

        WebElement secondCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        secondCheckbox.click();
        isChecked = secondCheckbox.isSelected();
        sa.assertEquals(isChecked, false);

        sa.assertAll();

    }
}

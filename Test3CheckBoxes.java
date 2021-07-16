package com.dotdash;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test3CheckBoxes extends BasePage {
    @Test
    public void selectCheckboxes() {
        driver.get("http://localhost:7080/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']//input[2]"));
        //Verifying that checkbox1 is selected  and checkbox2 is not selected
        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        //Verifying that checkbox1 is not selected  and checkbox2 is selected (Opposite of what we did above)
        checkbox1.click();
        checkbox2.click();
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());
    }
}


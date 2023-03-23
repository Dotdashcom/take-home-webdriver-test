package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.Constants;

public class Dropdown extends Constants {
    @Test
    public void automateDropdown() {
        driver.get("http://localhost:7080/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        select.selectByIndex(1);
        String value = dropdown.getAttribute("value");
        sa.assertEquals(value, "1");

        select.selectByIndex(2);
        value = dropdown.getAttribute("value");
        sa.assertEquals(value, "2");
        sa.assertAll();
    }
}

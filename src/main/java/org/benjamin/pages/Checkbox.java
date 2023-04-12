package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Checkbox extends PageBase {
    public void init() {
        super.init("http://localhost:7080/checkboxes");
    }

    public String click(int boxNumber){
        List<WebElement> checkboxs = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement checkbox = checkboxs.get(boxNumber - 1);
        checkbox.click();

        String checked = checkbox.getAttribute("checked");

        return checked;
    }
}

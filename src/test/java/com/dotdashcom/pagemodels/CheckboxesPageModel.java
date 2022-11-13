package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPageModel extends PageObject {

    public static final String PAGE_URL = "/checkboxes";

    public CheckboxesPageModel(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> findCheckboxes() {
        return driver.findElements(By.xpath("//input[@type='checkbox']"));
    }
}

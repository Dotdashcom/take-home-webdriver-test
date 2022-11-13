package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPageModel extends PageObject {

    public static final String PAGE_URL = "/dropdown";

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public Select getDropdown() {
        return new Select(dropdown);
    }

    public DropdownPageModel(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> compileDropdownOptions(Select select) {
        return select.getOptions();
    }
}

package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownListPage extends BasePageObject{

    private final By drop_down = By.id("dropdown");
    private WebElement first_selected_option = null;

    public DropDownListPage(WebDriver driver) {
        this.driver = driver;
        open_page("dropdown");
    }

    public DropDownListPage select_option(String option) {
        WebElement dropdown_elem = driver.findElement(drop_down);
        Select select = new Select(dropdown_elem);
        select.selectByVisibleText(option);
        first_selected_option = select.getFirstSelectedOption();
        return this;
    }

    public DropDownListPage verify_selected_option(String option) {
        String actual_selected_option = first_selected_option.getText();
        Assert.assertEquals(actual_selected_option, option, "[ERR] Selected option is incorrect!");
        return this;
    }

}

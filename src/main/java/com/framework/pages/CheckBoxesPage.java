package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends PageObjectBase {

    @FindBy(xpath = "//form[@id='checkboxes']/input[@type='checkbox'][1]")
    WebElement checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[@type='checkbox'][2]")
    WebElement checkbox2;

    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxesPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/checkboxes");
        return this;
    }

    public WebElement getCheckBox1() {
        return checkbox1;
    }

    public WebElement getCheckBox2() {
        return checkbox2;
    }

}

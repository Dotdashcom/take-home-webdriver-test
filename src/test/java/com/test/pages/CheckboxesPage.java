package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.util.Config;

public class CheckboxesPage {

    private WebDriver driver;
    private By checkbox1 = By.cssSelector("input[type='checkbox']:nth-of-type(1)");
    private By checkbox2 = By.cssSelector("input[type='checkbox']:nth-of-type(2)");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("checkboxes"));
    }

    public void clickCheckbox1() {
        driver.findElement(checkbox1).click();
    }

    public void clickCheckbox2() {
        driver.findElement(checkbox2).click();
    }

    public boolean isCheckbox1Checked() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Checked() {
        return driver.findElement(checkbox2).isSelected();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}

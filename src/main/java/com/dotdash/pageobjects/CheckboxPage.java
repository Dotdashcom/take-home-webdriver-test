package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckboxPage extends BasePage {

    @FindBy(how = How.CSS, using = "[type=\"checkbox\"]:first-child")
    private WebElement firstCheckBox;

    @FindBy(how = How.CSS, using = "[type=\"checkbox\"]:last-child")
    private WebElement secondCheckBox;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public CheckboxPage goToCheckboxPage() {
        driver.get(BASEURL + "/checkboxes");
        return this;
    }

    public CheckboxPage clickCheckbox(String checkbox) {
        if (checkbox.equals("first checkbox")) {
            firstCheckBox.click();
        } else {
            secondCheckBox.click();
        }
        return this;
    }

    public WebElement getCheckbox(String checkbox) {
        return checkbox.equals("first checkbox") ? firstCheckBox : secondCheckBox;
    }

}

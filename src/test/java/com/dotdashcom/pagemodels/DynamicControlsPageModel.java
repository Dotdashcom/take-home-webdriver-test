package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicControlsPageModel extends PageObject {

    public static final String PAGE_URL = "/dynamic_controls";

    @FindBy(id = "checkbox")
    private WebElement checkbox;

    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//button[text()='Enable']")
    private WebElement enableButton;

    @FindBy(xpath = "//button[text()='Disable']")
    private WebElement disableButton;

    @FindBy(css = "#input-example > input[type=text]")
    private WebElement textField;

    @FindBy(id = "message")
    private WebElement message;

    public WebElement getCheckbox() {
        return checkbox;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getEnableButton() {
        return enableButton;
    }

    public WebElement getDisableButton() {
        return disableButton;
    }

    public WebElement getTextField() {
        return textField;
    }

    public WebElement getMessage() {
        return message;
    }

    public DynamicControlsPageModel(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> findAllElementsWithId(String id) {
        // if HTML is written correctly, we expect a list of 0 or 1 items returned
        // because ids should be unique
        return driver.findElements(By.id("checkbox"));
    }
}

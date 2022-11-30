package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DynamicControlPage extends BasePage {

    @FindBy(how = How.CSS, using = "[onclick=\"swapCheckbox()\"]")
    private WebElement checkboxSwapButton;

    @FindBy(how = How.CSS, using = "[onclick=\"swapInput()\"]")
    private WebElement textFieldSwapButton;

    @FindBy(how = How.CSS, using = "#checkbox")
    private WebElement checkbox;

    @FindBy(how = How.CSS, using = "[type=\"text\"]")
    private WebElement inputField;

    @FindBy(how = How.CSS, using = "#message")
    private WebElement messageElement;

    public DynamicControlPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlPage goToDynamicControlPage() {
        driver.get(BASEURL + "/dynamic_controls");
        return this;
    }

    public DynamicControlPage clickCheckboxSwapButton() {
        waitForClickabilityOf(checkboxSwapButton).click();
        return this;
    }

    public DynamicControlPage clickTextFieldSwapButton() {
        waitForClickabilityOf(textFieldSwapButton).click();
        return this;
    }

    public boolean isCheckboxNotPresent() {
        return waitForInvisibilityOf(checkbox);
    }

    public boolean isCheckboxPresent() {
        return waitForVisibilityOf(checkbox).isDisplayed();
    }

    public boolean isTextFieldEnabled(String condition) {
        waitForCondition(messageElement, condition);
        return waitForVisibilityOf(inputField).getAttribute("disabled") == null;
    }
}

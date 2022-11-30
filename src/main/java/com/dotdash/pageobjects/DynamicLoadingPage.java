package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DynamicLoadingPage extends BasePage {

    @FindBy(how = How.CSS, using = "#start>button")
    private WebElement startButton;

    @FindBy(how = How.CSS, using = "#finish")
    private WebElement finishElement;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage goToDynamicLoadingPage() {
        driver.get(BASEURL + "/dynamic_loading/2");
        return this;
    }

    public DynamicLoadingPage clickStartButton() {
        waitForClickabilityOf(startButton).click();
        return this;
    }

    public String getText() {
        return waitForVisibilityOf(finishElement).getText();
    }
}

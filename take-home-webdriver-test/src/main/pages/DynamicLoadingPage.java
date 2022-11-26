package com.framework.pages;

import com.framework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends PageObjectBase {
    @FindBy(xpath = "//div[@id='start']/button")
    WebElement startButton;

    @FindBy(xpath = "//*[@id='finish']")
    WebElement message;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/dynamic_loading/2");
        return this;
    }

    public void clickStart() {
        startButton.click();
    }

    public String getMessage() {
        Utils.explicitWait(driver, "//*[@id='finish']", 15);
        return message.getText();
    }

}

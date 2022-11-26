package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends PageObjectBase {
    @FindBy(id = "content")
    WebElement dynamicContentDiv;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public DynamicContentPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/dynamic_content");
        return this;
    }

    public String getCurrentContent() {
        return dynamicContentDiv.getAttribute("innerHTML");
    }

}

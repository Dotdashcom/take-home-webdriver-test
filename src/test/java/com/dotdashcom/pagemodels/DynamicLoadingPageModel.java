package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPageModel extends PageObject {

    public static final String PAGE_URL = "/dynamic_loading/2";

    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement finishDiv;

    public WebElement getStartButton() {
        return startButton;
    }

    public WebElement getFinishDiv() {
        return finishDiv;
    }

    public DynamicLoadingPageModel(WebDriver driver) {
        super(driver);
    }
}

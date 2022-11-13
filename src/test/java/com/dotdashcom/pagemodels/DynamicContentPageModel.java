package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPageModel extends PageObject {

    public static final String PAGE_URL = "/dynamic_content";

    @FindBy(id = "content")
    private WebElement content;

    public WebElement getContent() {
        return content;
    }

    public DynamicContentPageModel(WebDriver driver) {
        super(driver);
    }
}

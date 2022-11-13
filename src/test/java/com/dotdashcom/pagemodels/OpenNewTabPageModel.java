package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewTabPageModel extends PageObject {

    public static final String PAGE_URL = "/windows";
    public static final String NEW_PAGE_URL = "/windows/new";

    @FindBy(id = "content")
    private WebElement contentDiv;

    @FindBy(tagName = "h3")
    private WebElement newTabH3Element;

    public OpenNewTabPageModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getContentDiv() {
        return contentDiv;
    }

    public WebElement getNewTabH3Element() {
        return newTabH3Element;
    }
}

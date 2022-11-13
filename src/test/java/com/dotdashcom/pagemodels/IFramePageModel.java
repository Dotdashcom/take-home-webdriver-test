package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePageModel extends PageObject {

    public static final String PAGE_URL = "/iframe";

    @FindBy(id = "mce_0_ifr")
    private WebElement iFrame;

    @FindBy(id = "tinymce")
    private WebElement editor;

    public IFramePageModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getIFrame() {
        return iFrame;
    }

    public WebElement getEditor() {
        return editor;
    }
}

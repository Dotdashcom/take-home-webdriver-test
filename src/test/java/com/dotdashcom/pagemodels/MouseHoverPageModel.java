package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPageModel extends PageObject {

    public static final String PAGE_URL = "/hovers";

    @FindBy(id = "content")
    private WebElement contentDiv;

    public MouseHoverPageModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getContentDiv() {
        return contentDiv;
    }

    public List<WebElement> findFigures() {
        return getContentDiv().findElements(By.className("figure"));
    }
}

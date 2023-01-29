package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class DynamicContentPage extends WebPage {

    @FindBy(css = "#content > div.row > div.large-10.columns")
    List<WebElement> paragraphTexts;

    public DynamicContentPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public String getParagraphText(int paragraphNo) {
        return paragraphTexts.get(paragraphNo).getText();
    }
}

package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class DynamicContentPage extends BasePage {

    @FindBy(css = "#content.large-10.columns.large-centered > div > div:last-child")
    private List<WebElement> profileParasList;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentPara(int index) {
        return profileParasList.get(index).getText();
    }
}

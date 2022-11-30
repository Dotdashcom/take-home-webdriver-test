package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

public class DynamicContentPage extends BasePage {
    @FindBy(how = How.CSS, using = "[class=\"large-10 columns\"]")
    private List<WebElement> textElementList;

    @FindBy(how = How.CSS, using = "[class=\"large-2 columns\"]>img")
    private List<WebElement> imageElementList;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public DynamicContentPage goToDynamicContentPage() {
        driver.get(BASEURL + "/dynamic_content");
        return this;
    }

    public List<String> getDynamicTexts() {
        return waitForClickabilityOf(textElementList)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getImageLinks() {
        return waitForClickabilityOf(imageElementList)
                .stream()
                .map(webElement -> webElement.getAttribute("src"))
                .collect(Collectors.toList());
    }

}

package com.dotdash.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

public class MouseHoverPage extends BasePage {

    @FindBy(how = How.CSS, using = "[class=\"figure\"]")
    private List<WebElement> userAvatarList;

    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    public MouseHoverPage goToMouseHoverPage() {
        driver.get(BASEURL + "/hovers");
        return this;
    }

    public List<Boolean> areElementsDisplayed() {
        return userAvatarList.stream().map(element -> {
            actions.moveToElement(element).perform();
            return waitForVisibilityOf(element, By.cssSelector("[class=\"figcaption\"]")).isDisplayed();
        }).collect(Collectors.toList());
    }
}

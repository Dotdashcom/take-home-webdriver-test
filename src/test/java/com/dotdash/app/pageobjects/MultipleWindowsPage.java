package com.dotdash.app.pageobjects;

import com.dotdash.core.helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleWindowsPage extends BasePage {
    @FindBy(css="a[href*=\"new\"]")
    WebElement clickHereLink;

    @FindBy(css="h3")
    WebElement message;

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOpenNewTabLink(){
        clickHereLink.click();
    }

    public void switchToNewTab(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String getNewTabMessage(){
        return message.getText();
    }
}

package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WindowsPage extends BasePage {

    @FindBy(css = "div#content > div.example > a")
    private WebElement clickHereLink;

    @FindBy(css = "div.example > h3")
    private WebElement newWindowText;

    private String parentWindowHandle;
    private String childWindowHandle;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public void openNewWindow() {
        parentWindowHandle = getDriver().getWindowHandle();

        clickHereLink.click();

        for(String current: getDriver().getWindowHandles()) {
            if(!current.equals(parentWindowHandle)) {
                childWindowHandle = current;
                break;
            }
        }
    }

    public void switchToNewWindow() {
        getDriver().switchTo().window(childWindowHandle);
    }

    public void switchToParentWindow() {
        getDriver().switchTo().window(parentWindowHandle);
    }

    public String getNewWindowText() {
        return newWindowText.getText();
    }
}

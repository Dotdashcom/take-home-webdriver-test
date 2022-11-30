package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OpenInNewTabPage extends BasePage {

    @FindBy(how = How.CSS, using = "[href=\"/windows/new\"]")
    private WebElement newTabButton;

    @FindBy(how = How.CSS, using = "h3")
    private WebElement switchedTabElement;

    public OpenInNewTabPage(WebDriver driver) {
        super(driver);
    }

    public OpenInNewTabPage goToOpenInNewTabPage() {
        driver.get(BASEURL + "/windows");
        return this;
    }

    public OpenInNewTabPage switchTabs() {
        waitForClickabilityOf(newTabButton).click();
        String[] handles = driver.getWindowHandles().toArray(new String[]{});
        driver.switchTo().window(handles[1]);
        return this;
    }

    public String getSwitchedTabText() {
        return waitForVisibilityOf(switchedTabElement).getText();
    }
}

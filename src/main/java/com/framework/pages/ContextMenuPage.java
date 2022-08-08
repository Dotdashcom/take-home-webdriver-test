package com.framework.pages;

import com.framework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends PageObjectBase {
    @FindBy(xpath = "//div[@id='hot-spot']")
    WebElement hotSpotBox;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public ContextMenuPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/context_menu");
        return this;
    }

    public ContextMenuPage rightClickHotSpotBox() {
        Utils.contextClick(driver, hotSpotBox);
        return this;
    }

    public String getAlertMessage() {
        return Utils.getAlertMessage(driver);
    }

}

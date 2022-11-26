package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends PageObjectBase {
    @FindBy(xpath = "//div[@id='menu']")
    WebElement floatingMenu;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public FloatingMenuPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/floating_menu");
        return this;
    }

    public Boolean isFloatingMenuDisplayed() {
        return floatingMenu.isDisplayed();
    }


}

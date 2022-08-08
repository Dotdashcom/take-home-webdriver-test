package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends PageObjectBase {

    @FindBy(xpath = "//h4[contains(text(),'Welcome')]")
    private WebElement welcomeArea;

    @FindBy(xpath = "//div[@id='flash' and @class='flash success']")
    private WebElement successFlash;

    @FindBy(xpath = "//i[contains(text(),'Logout')]")
    private WebElement logoutButton;


    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public SecurePage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL" + "/secure"));
        return this;
    }

    public Boolean validateSuccessMessage() {
        return successFlash.isDisplayed();
    }

    public boolean validateWelcomeArea() {
        return welcomeArea.isDisplayed();
    }

    public void logout() {
        logoutButton.click();
    }

}

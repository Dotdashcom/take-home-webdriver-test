package com.nparede.project.pagefactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends BasePage{

    @FindBy(xpath = "//*[contains(@href,'logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[contains(text(),'Your password is invalid!')]")
    private WebElement wrongPasswordSign;

    @FindBy(xpath = "//*[contains(text(),'Your username is invalid!')]")
    private WebElement wrongUserNameSign;

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {
        try {
            super.explicitWaitForVisibilityElement(this.logoutButton);
            return true;
        }
        catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean isWrongPasswordSignShown() {
        try {
            super.explicitWaitForVisibilityElement(this.wrongPasswordSign);
            return true;
        }
        catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean isWrongUserNameSignShown() {
        try {
            super.explicitWaitForVisibilityElement(this.wrongUserNameSign);
            return true;
        }
        catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }


}

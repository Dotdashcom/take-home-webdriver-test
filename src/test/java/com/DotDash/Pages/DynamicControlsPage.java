package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {

    public WebDriver ldriver;

    public DynamicControlsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    WebElement btnRemove;

    @FindBy(xpath = "//p[@id='message']")
    WebElement txtmsg;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement btnAdd;

    @FindBy(id = "checkbox")
    WebElement chkbox;

    @FindBy(xpath = "//button[contains(text(),'Enable')]")
    WebElement btnEnable;

    @FindBy(xpath = "//form[@id='input-example']/input")
    WebElement txtbox;

    @FindBy(xpath = "//button[contains(text(),'Disable')]")
    WebElement btnDisable;



    public void clkbtnRemove() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnRemove));
        wait.until(ExpectedConditions.elementToBeClickable(btnRemove));
        btnRemove.click();
    }

    public String gettxtmsg() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtmsg));
        return txtmsg.getText();
    }

    public void clkbtnAdd() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnAdd));
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
    }

    public boolean chkboxisDisplayed() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(chkbox));
        return chkbox.isDisplayed();
    }

    public void clkbtnEnable() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnEnable));
        wait.until(ExpectedConditions.elementToBeClickable(btnEnable));
        btnEnable.click();
    }

    public boolean txtboxisEnabled() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtbox));
        return txtbox.isEnabled();
    }

    public boolean txtboxisNowEnabled() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtbox));
        wait.until(ExpectedConditions.elementToBeClickable(txtbox));
        return txtbox.isEnabled();
    }

    public void clkbtnDisable() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnDisable));
        wait.until(ExpectedConditions.elementToBeClickable(btnDisable));
        btnDisable.click();
    }
}
package com.trudova.getInProj.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(linkText = "Checkboxes")
    public WebElement checkboxes;
    @FindBy(linkText = "Context Menu")
    public WebElement contextMenu;

    @FindBy(linkText = "Drag and Drop")
    public WebElement dragAndDrop;
    @FindBy(xpath = "//a[@href='/dropdown']")
    public WebElement dropdownLink;

    @FindBy(linkText = "Dynamic Content")
    public WebElement dynamicContent;
    @FindBy(linkText = "Dynamic Controls")
    public WebElement dynamicControls;
    @FindBy(linkText = "File Download")
    public WebElement fileDownload;
    @FindBy(linkText = "File Upload")
    public WebElement fileUpload;
    @FindBy(linkText = "Floating Menu")
    public WebElement floatingMenu;
    @FindBy(linkText = "Hovers")
    public WebElement hovers;
    @FindBy(linkText = "JavaScript Alerts")
    public WebElement javaScriptAlerts;
    @FindBy(linkText = "JavaScript onload event error")
    public WebElement javaScriptError;
    @FindBy(linkText = "Multiple Windows")
    public WebElement multipleWindows;
    @FindBy(linkText = "Notification Messages")
    public WebElement notificationMessages;

}

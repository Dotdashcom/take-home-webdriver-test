package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css="a[href*=\"login\"]")
    WebElement formAuthLink;

    @FindBy(css="a[href*=\"checkboxes\"]")
    WebElement checkboxesLink;

    @FindBy(css="a[href*=\"context\"]")
    WebElement contextMenuLink;

    @FindBy(css="a[href*=\"drag\"]")
    WebElement dragAndDropLink;

    @FindBy(css="a[href*=\"dropdown\"]")
    WebElement dropdownLink;

    @FindBy(css="a[href*=\"dynamic_content\"]")
    WebElement dynamicContentLink;

    @FindBy(css="a[href*=\"dynamic_controls\"]")
    WebElement dynamicControlsLink;

    @FindBy(css="a[href*=\"dynamic_loading\"]")
    WebElement dynamicLoadingLink;

    @FindBy(css="a[href=\"/download\"]")
    WebElement fileDownloadLink;

    @FindBy(css="a[href*=\"upload\"]")
    WebElement fileUploadLink;

    @FindBy(css="a[href*=\"floating_menu\"]")
    WebElement floatingMenuLink;

    @FindBy(css="a[href*=\"frames\"]")
    WebElement framesLink;

    @FindBy(css="a[href*=\"hovers\"]")
    WebElement hoversLink;

    @FindBy(css="a[href*=\"javascript_alerts\"]")
    WebElement jsAlertsLink;

    @FindBy(css="a[href*=\"javascript_error\"]")
    WebElement jsErrorsLink;

    @FindBy(css="a[href*=\"windows\"]")
    WebElement multipleWindowsLink;

    @FindBy(css="a[href*=\"message\"]")
    WebElement notificationMessageLink;
    //endregion

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFormAuthLink() {this.click(formAuthLink);}
    public void clickCheckboxesLink() {this.click(checkboxesLink);}
    public void clickContextMenuLink() {this.click(contextMenuLink);}
    public void clickDragAndDropLink() {this.click(dragAndDropLink);}
    public void clickDropdownLink() {this.click(dropdownLink);}
    public void clickDynamicContentLink() {this.click(dynamicContentLink);}
    public void clickDynamicControlsLink() {this.click(dynamicControlsLink);}
    public void clickDynamicLoadingLink() {this.click(dynamicLoadingLink);}
    public void clickFileDownloadLink() {this.click(fileDownloadLink);}
    public void clickFileUploadLink() {this.click(fileUploadLink);}
    public void clickFloatingMenuLink() {this.click(floatingMenuLink);}
    public void clickFramesLink() {this.click(framesLink);}
    public void clickHoversLink() {this.click(hoversLink);}
    public void clickJsAlertsLink() {this.click(jsAlertsLink);}
    public void clickJsErrorsLink() {this.click(jsErrorsLink);}
    public void clickMultipleWindowsLink() {this.click(multipleWindowsLink);}
    public void clickNotificationMessageLink() {this.click(notificationMessageLink);}

}
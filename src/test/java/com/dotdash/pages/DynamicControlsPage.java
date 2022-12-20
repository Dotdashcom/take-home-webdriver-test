package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage{
    @FindBy (xpath = "//button[contains(text(),'Remove')]")
    public WebElement removeButton;

    @FindBy (xpath = "//button[contains(text(),'Add')]")
    public WebElement addButton;

    @FindBy (xpath = "//button[contains(text(),'Disable')]")
    public WebElement disableButton;

    @FindBy (xpath = "//button[contains(text(),'Enable')]")
    public WebElement enableButton;

    @FindBy (xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

}

package theinternet.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePage{
    public DynamicControlsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h4[contains(.,'Dynamic Controls')]")
    public WebElement dynamicControlsPageHeader;
    @FindBy(xpath = "//button[contains(.,'Remove')]")
    public WebElement dynamicControlsRemoveButton;
    @FindBy(xpath = "//button[contains(.,'Add')]")
    public WebElement dynamicControlsAddButton;
    @FindBy(xpath = "//input[contains(@type,'checkbox')]")
    public WebElement dynamicControlsCheckBox;
    @FindBy(xpath = "//button[contains(.,'Enable')]")
    public WebElement dynamicControlsEnableButton;
    @FindBy(xpath = "//button[contains(.,'Disable')]")
    public WebElement dynamicControlsDisableButton;
    @FindBy(xpath = "//input[contains(@type,'text')]")
    public WebElement dynamicControlsTextBox;

    public Boolean validatePageLanding(){
        dynamicControlsPageHeader.isDisplayed();
        dynamicControlsCheckBox.isDisplayed();
        dynamicControlsRemoveButton.isDisplayed();
        dynamicControlsEnableButton.isDisplayed();
        dynamicControlsTextBox.isDisplayed();
        return true;
    }
    public void clickOnButton(String option){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        switch (option){
            case "Remove":
                dynamicControlsRemoveButton.click();
                wait.until(ExpectedConditions.visibilityOf(dynamicControlsAddButton));
                break;
            case "Add":
                dynamicControlsAddButton.click();
                wait.until(ExpectedConditions.visibilityOf(dynamicControlsRemoveButton));
                break;
            case "Enable":
                dynamicControlsEnableButton.click();
                wait.until(ExpectedConditions.visibilityOf(dynamicControlsDisableButton));
                break;
            case "Disable":
                dynamicControlsDisableButton.click();
                wait.until(ExpectedConditions.visibilityOf(dynamicControlsEnableButton));
                break;
        }
    }

    public Boolean checkBoxIsDisplayed(){
        try{
            dynamicControlsCheckBox.isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public Boolean textBoxIsEnabled(){
            return dynamicControlsTextBox.isEnabled();
    }
}

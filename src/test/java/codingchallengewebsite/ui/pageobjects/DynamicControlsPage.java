package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicControlsPage {

    @FindBy(how = How.XPATH, using = "//h4[normalize-space()='Dynamic Controls']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    public WebElement textBox;
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    public WebElement checkBox;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Enable']")
    public WebElement enableButton;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Disable']")
    public WebElement disableButton;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Add']")
    public WebElement addButton;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Remove']")
    public WebElement removeButton;
    private final WebDriverWait genericWait;
    private final UITest caller;
    private final String pageUrl;

    public DynamicControlsPage(UITest caller) {
        this.caller = caller;
        this.genericWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        this.pageUrl = this.caller.getBaseUrl() + "/dynamic_controls";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void reloadPage() { UITest.reloadPage(caller.getDriver()) ;}

    public void enableTextBox() {
        enableButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(disableButton));
        this.genericWait.until(ExpectedConditions.elementToBeClickable(textBox)).isEnabled();
    }

    public void disableTextBox() {
        disableButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(enableButton));
        this.genericWait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textBox)));
    }

    public void addCheckboxButton() {
        addButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(removeButton));
        this.genericWait.until(ExpectedConditions.visibilityOf(checkBox));
    }

    public void removeCheckboxButton() {
        removeButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(addButton));
        this.genericWait.until(ExpectedConditions.invisibilityOf(checkBox));
    }

    public void clickCheckbox() {
        Boolean currentState = this.isCheckboxSelected();
        checkBox.click();
        this.genericWait.until(ExpectedConditions.elementSelectionStateToBe(checkBox, !currentState));
    }

    public Boolean isCheckboxSelected() {
        return checkBox.isSelected();
    }

    public Boolean isCheckboxEnabled() {
        return !caller.getDriver().findElements(By.xpath("//input[@type='checkbox']")).isEmpty(); }

    public Boolean isTextboxEnabled() {
        return textBox.isEnabled();
    }
}
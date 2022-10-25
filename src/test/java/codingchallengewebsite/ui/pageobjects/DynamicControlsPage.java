package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicControlsPage {

    @FindBy(how = How.XPATH, using = "//h4[normalize-space()='Dynamic Controls']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement textBox;
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private WebElement checkBox;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Enable']")
    private WebElement enableButton;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Disable']")
    private WebElement disableButton;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Add']")
    private WebElement addButton;
    @FindBy(how = How.XPATH, using = "//button[text()= 'Remove']")
    private WebElement removeButton;
    private final UITest caller;
    private final String pageUrl;

    public DynamicControlsPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/dynamic_controls";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() { // Check that the page loaded
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().contains("Dynamic Controls"); }

    public void reloadPage() { UITest.reloadPage(caller.getDriver()) ;}

    public void enableTextBox() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(disableButton));
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).isEnabled();
    }

    public void disableTextBox() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        disableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textBox)));
    }

    public void addCheckboxButton() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        wait.until(ExpectedConditions.visibilityOf(checkBox));
    }

    public void removeCheckboxButton() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        removeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
    }

    public void clickCheckbox() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        boolean currentState = this.isCheckboxSelected();
        checkBox.click();
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox, !currentState));
    }

    public boolean isCheckboxSelected() {
        return checkBox.isSelected();
    }

    public boolean isCheckboxEnabled() {
        return !caller.getDriver().findElements(By.xpath("//input[@type='checkbox']")).isEmpty(); }

    public boolean isTextboxEnabled() {
        return textBox.isEnabled();
    }
}
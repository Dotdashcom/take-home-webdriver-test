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

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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

    public DynamicControlsPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(3));
        this.genericWait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/dynamic_controls";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle),presenceOfAllElementsLocatedBy(By.xpath("//input[@type='checkbox']"))));

    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void reloadPage() { UITest.reloadPage(caller.getDriver()) ;}

    public void enableTextBox() {
        //WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        enableButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(disableButton));
        this.genericWait.until(ExpectedConditions.elementToBeClickable(textBox)).isEnabled();
    }

    public void disableTextBox() {
        //WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        disableButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(enableButton));
        this.genericWait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textBox)));
    }

    public void addCheckboxButton() {
        //WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        addButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(removeButton));
        this.genericWait.until(ExpectedConditions.visibilityOf(checkBox));
    }

    public void removeCheckboxButton() {
        //WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        removeButton.click();
        this.genericWait.until(ExpectedConditions.elementToBeClickable(addButton));
        this.genericWait.until(ExpectedConditions.invisibilityOf(checkBox));
    }

    public void clickCheckbox() {
        //WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
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
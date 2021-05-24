package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import static org.junit.Assert.*;

public class DynamicControlsPage {
    private WebDriver driver;
    //explicit wait
    WebDriverWait wait;

    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "dynamic_controls";

    //Checkbox
    @FindBy(id = "checkbox")
    private WebElement checkBox;
    //Remove button
    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;
    //Add button
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;
    //Text box
    @FindBy(css = "form#input-example input")
    private WebElement textBox;
    //Enable button
    @FindBy(xpath = "//button[text()='Enable']")
    private WebElement enableButton;
    //Disable button
    @FindBy(xpath = "//button[text()='Disable']")
    private WebElement disableButton;
    //Message
    @FindBy(id = "message")
    private WebElement successText;

    //Constructor
    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Verify Default DOM elements are present
    public void verifyDefaultOptions() {
        assertTrue(removeButton.isDisplayed());
        assertTrue(enableButton.isDisplayed());
        assertTrue(checkBox.isDisplayed());
        assertTrue(textBox.isDisplayed());
    }

    //Verify removing checkbox
    public void verifyRemove() {
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOf(successText));
        assertEquals(successText.getText(), "It's gone!");
        assertTrue(addButton.isDisplayed());
    }

    //Verify adding checkbox
    public void verifyAdd() {
        addButton.click();
        wait.until(ExpectedConditions.visibilityOf(successText));
        assertEquals(successText.getText(), "It's back!");
        assertTrue(removeButton.isDisplayed());
        assertTrue(checkBox.isDisplayed());
    }

    //Verify enabling textbox
    public void verifyEnable() {
        enableButton.click();
        wait.until(ExpectedConditions.visibilityOf(successText));
        assertEquals(successText.getText(), "It's enabled!");
        assertNull(textBox.getAttribute("disabled"));
    }

    //Verify disabling textbox
    public void verifyDisable() {
        disableButton.click();
        wait.until(ExpectedConditions.visibilityOf(successText));
        assertEquals(successText.getText(), "It's disabled!");
        assertNotNull(textBox.getAttribute("disabled"));
    }
}

package DotDashPages;

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

    //Capture Remove button
    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    WebElement btnRemove;

    //Capture message after clicking on Remove button
    @FindBy(xpath = "//p[@id='message']")
    WebElement txtmsg;

    //Capture the Add button
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement btnAdd;

    //Capture the check box after clicking Add message
    @FindBy(id = "checkbox")
    WebElement chkbox;

    //Capture the Enable button
    @FindBy(xpath = "//button[contains(text(),'Enable')]")
    WebElement btnEnable;

    //Capture the text box
    @FindBy(xpath = "//form[@id='input-example']/input")
    WebElement txtbox;

    //Capture the Enable button
    @FindBy(xpath = "//button[contains(text(),'Disable')]")
    WebElement btnDisable;


    //=================ACTION METHODS===========================//

    //Click on Remove button
    public void clkbtnRemove() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnRemove));
        wait.until(ExpectedConditions.elementToBeClickable(btnRemove));
        btnRemove.click();
    }

    //Get the message after clicking on Remove button
    public String gettxtmsg() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtmsg));
        return txtmsg.getText();
    }

    //Click on Add button
    public void clkbtnAdd() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnAdd));
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
    }

    //Check whether checkbox is displayed after clicking on add button
    public boolean chkboxisDisplayed() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(chkbox));
        return chkbox.isDisplayed();
    }

    //Click on Enable button
    public void clkbtnEnable() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnEnable));
        wait.until(ExpectedConditions.elementToBeClickable(btnEnable));
        btnEnable.click();
    }

    //Check whether textbox is displayed before clicking on Enable button
    public boolean txtboxisEnabled() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtbox));
        return txtbox.isEnabled();
    }

    //Check whether textbox is displayed after clicking on Enable button
    public boolean txtboxisNowEnabled() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtbox));
        wait.until(ExpectedConditions.elementToBeClickable(txtbox));
        return txtbox.isEnabled();
    }

    //Click on Disable button
    public void clkbtnDisable() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnDisable));
        wait.until(ExpectedConditions.elementToBeClickable(btnDisable));
        btnDisable.click();
    }
}

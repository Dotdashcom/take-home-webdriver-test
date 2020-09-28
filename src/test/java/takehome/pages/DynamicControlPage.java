package takehome.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.Driver;

public class DynamicControlPage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    @FindBy(css = "form#checkbox-example > button[type='button']")
    private WebElement removeButton;
    @FindBy(css = "form#checkbox-example > div:nth-of-type(1)")
    protected WebElement checkboxA;
    @FindBy(css = "p#message")
    private WebElement itIsBackText;
    @FindBy(linkText = "Dynamic Controls")
    private WebElement dynamicControlLink;
    @FindBy(css = "form#checkbox-example > button[type='button']")
    private  WebElement addButton;
    @FindBy(css = "form#input-example > button[type='button']")
    private WebElement enableButton;
    @FindBy(css = "form#input-example > button[type='button']")
    private WebElement disableButton;
    @FindBy(css = "p#message")
    private  WebElement buttonText;






















    public void clickOnRemoveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();

    }



    public DynamicControlPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void clickOnDynamicControlLink (){
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlLink));
        dynamicControlLink.click();
    }

    public boolean confirmCheckboxExisting(){
        BrowserUtilities.wait(5);

        if (!checkboxA.isDisplayed()){
            return true;
        }
        return false;
    }
    public void clickOnAddButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

    }
    public void clickEnableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));
        enableButton.click();


    }
    public void clickDisableButton(){
    wait.until(ExpectedConditions.elementToBeClickable(disableButton));
        disableButton.click();
    }

    public  String getButtonText(){
        wait.until(ExpectedConditions.visibilityOf(buttonText));

        return buttonText.getText();
    }


}

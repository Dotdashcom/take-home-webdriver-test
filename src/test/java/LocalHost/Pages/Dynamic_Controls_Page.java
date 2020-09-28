package LocalHost.Pages;

import LocalHost.Utilities.Driver;
import org.openqa.selenium.By;
import static LocalHost.Utilities.BrowserUtils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Dynamic_Controls_Page {
   public Dynamic_Controls_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="checkbox")
    private WebElement checkbox;

    @FindBy(xpath = "//*[@onclick='swapCheckbox()']")
    private WebElement CheckButton;

    @FindBy(xpath ="//*[@style='width: 30%;']")
    private WebElement DisableArea;

    @FindBy(xpath = "//*[@onclick='swapInput()']")
    private WebElement InputButton;

    @FindBy(id = "message")
    private WebElement message;

    public void WaitForCheckbox() {

        CheckButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.elementToBeClickable(CheckButton));
    }

    public void WaitForInputBox() {

        InputButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.elementToBeClickable(InputButton));
    }
    public void ConfirmAdditionInput(){
        try{
            DisableArea.sendKeys("This Works!!!");
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.fail();
        }
    }

    public void ConfirmRemovalInput(){
        try{
            DisableArea.sendKeys("This Works!!!");
            Assert.fail();
        }catch (Exception e){
            Assert.assertTrue(true);
        }

    }

    public void ConfirmAdditionCheckbox(){
        try{
            checkbox.click();
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.fail();
        }
    }

    public void ConfirmRemovalCheckbox(){
        try{
            checkbox.click();
            Assert.fail();
        }catch (Exception e){
            Assert.assertTrue(true);
        }

    }

}

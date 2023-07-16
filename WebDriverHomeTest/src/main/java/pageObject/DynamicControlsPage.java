package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends CommonApi {
    WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[text()='Remove']")
    WebElement removeButton;
    @FindBy(xpath = "//*[text()='Add']")
    WebElement addButton;
    @FindBy(xpath = "//*[@id='message']")
    WebElement message;

    @FindBy(xpath = "//*[text()='Enable']")
    WebElement enableButton;

    @FindBy(xpath = "//*[text()='Disable']")
    WebElement disableButton;

    @FindBy(xpath = "//*[@id='checkbox']//parent::div")
    WebElement checkbox;
    @FindBy(xpath = "//*[@type='text']")
    WebElement textBar;


    public void clickOnRemove(){
        removeButton.click();
       waitForWebElementToAppear(message);
    }
    public void cilckAdd(){
        addButton.click();
        waitForWebElementToAppear(message);
    }
    public boolean checkboxDisplay(){
        return  checkbox.isDisplayed();

     }
      public void clickEnable(){
        enableButton.click();
        waitForWebElementToAppear(message);
      }
      public void clickDisable(){
        disableButton.click();
        waitForWebElementToAppear(message);
      }
       public boolean bar(){
           return textBar.isEnabled();

       }

       public void goTo(){
        driver.get("http://localhost:7080/dynamic_controls");
       }








}

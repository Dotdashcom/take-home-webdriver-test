package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

@FixMethodOrder(MethodSorters.DEFAULT)
public class DynamicControlsPage extends BasePage{


    @FindBy(xpath = "//button[.='Remove']")
    private WebElement removeButtonInput;

    @FindBy(id = "checkbox")
    private WebElement checkboxInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//button[.='Add']")
    private WebElement addButtonInput;

    @FindBy(xpath = "//button[.='Enable']")
    private WebElement enableButtonInput;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement textBoxInput;

    @FindBy(xpath = "//button[.='Disable']")
    private WebElement disableButtonInput;



    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/dynamic_controls");
    }


    @Test
    public void firstClickOnRemoveButton(){
        waitForVisibilityOf(removeButtonInput);
        removeButtonInput.click();
        wait.until(ExpectedConditions.invisibilityOf(removeButtonInput));

        try{
            Assert.assertTrue("!!! Checkbox is still present !!!",!checkboxInput.isDisplayed());
        }catch (Exception e){e.printStackTrace();}
        System.out.println("-> Remove button success message is: " + messageInput.getText());
    }

    @Test
    public void secondClickOnAddButton(){
        waitForVisibilityOf(addButtonInput);
        addButtonInput.click();
        wait.until(ExpectedConditions.invisibilityOf(addButtonInput));
        waitForVisibilityOf(checkboxInput);
       try {
           Assert.assertTrue("!!! Checkbox is not present !!!", checkboxInput.isDisplayed());
       }catch (Exception e){e.printStackTrace();}
        System.out.println("-> Add button success message is: " + messageInput.getText());
    }


    @Test
    public void thirdClickOnEnabledButton(){
        waitForVisibilityOf(enableButtonInput);
        enableButtonInput.click();
        wait.until(ExpectedConditions.invisibilityOf(enableButtonInput));
        try {
            Assert.assertTrue("!!! Text box is not enabled !!!", textBoxInput.isEnabled());
        }catch (Exception e){e.printStackTrace();}
        System.out.println("-> Enable button success message is: " + messageInput.getText());
    }

    @Test
    public void fourthClickOnDisableButton(){
        waitForVisibilityOf(disableButtonInput);
        disableButtonInput.click();
        wait.until(ExpectedConditions.invisibilityOf(disableButtonInput));
        try {
            Assert.assertTrue("!!! Text box is not disabled !!!", !textBoxInput.isEnabled());
        }catch (Exception e){e.printStackTrace();}
        System.out.println("-> Disable button success message is: " + messageInput.getText());
    }


    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }

}

package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class DynamicControlsPage extends BasePage {
    public DynamicControlsPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy (xpath = "//button[@onclick='swapCheckbox()']")
    private WebElement addRemoveBtn;

    @FindBy (xpath = "//form[@id='checkbox-example']//div[@id='loading']")
    private WebElement addRemoveBtnLoadingBlock;

    @FindBy (xpath = "//button[@onclick='swapInput()']")
    private WebElement enableDisableBtn;

    @FindBy (xpath = "//form[@id='input-example']//div")
    private WebElement enableDisableBtnLoadingBlock;

    @FindBy (xpath = "//input[@type='checkbox']")
    private WebElement checkBox;

    @FindBy (xpath = "//input[@type='text']")
    private WebElement textInput;

    @FindBy (xpath = "//p[@id='message']")
    private WebElement checkboxMsg;


    public void verifyDynamicControls(){
        softAssert.assertTrue(addRemoveBtn.isEnabled(),"Add/Remove button is not enabled");
        softAssert.assertTrue(enableDisableBtn.isEnabled(),"Enable/Disable button is not enabled");
        softAssert.assertTrue(checkBox.isEnabled(),"Checkbox is not enabled");
        softAssert.assertTrue(!textInput.isEnabled(),"Text input is enable");

        btnClick(addRemoveBtn);
        verifyWebElementIsGone(addRemoveBtnLoadingBlock);
        softAssert.assertTrue(checkboxMsg.isDisplayed(),"Checkbox message is not displayed");
      //  softAssert.assertFalse(checkBox.isDisplayed(), "Checkbox is displayed");
      //  softAssert.assertTrue(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated((By) checkBox)).apply(driver), "Checkbox is displayed");
                                                                                                        //how check that checkbox is not enabled/displayed?
        btnClick(addRemoveBtn);
        verifyWebElementIsGone(addRemoveBtnLoadingBlock);
        softAssert.assertTrue(checkBox.isEnabled(),"Checkbox is not enabled after it appears");

        btnClick(enableDisableBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textInput));
        softAssert.assertTrue(textInput.isEnabled(),"Text input is not enable");

        btnClick(enableDisableBtn);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textInput)));
        softAssert.assertTrue(!textInput.isEnabled(),"Text input is enable");
    }

}

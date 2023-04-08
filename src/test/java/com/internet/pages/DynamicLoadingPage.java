package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BasePage{


    @FindBy(xpath="//button")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement helloWorld;

    public void clickStart(){
        waitforVisibilityandClickable(startButton);
        startButton.click();
    }

    public boolean checkIfHelloWorldAppeared(){
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        return helloWorld.isDisplayed();
    }


}

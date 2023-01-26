package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class dynamicControl extends TestBase{


    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")
    WebElement Remov_add_Button;
    @FindBy(xpath = "//*[@id=\"checkbox\"]")
    WebElement check_box;
    @FindBy(xpath = "//*[@id=\"message\"]")
    WebElement msg;
    @FindBy(xpath = "//*[@id=\"input-example\"]/button")
    WebElement Enable_disablee_Button;

//
//	@FindBy(css = "div#start button")
//	WebElement startButton ;
//
//	@FindBy(css = "div#finish")
//	WebElement finiButton;
//

    public dynamicControl () {
        PageFactory.initElements(driver, this);
    }

    public void dynaControl() {

        //Test clicks on the Remove Button and uses explicit wait.
//		Test asserts that the checkbox is gone.
        Remov_add_Button.click();

        wait.until(ExpectedConditions.elementSelectionStateToBe(check_box, false));
        //  WaitFor_state(driver, Duration.ofSeconds(2), check_box, false);
        Assert.assertEquals(msg.getText(),"It's gone!","wrong");

//		Test clicks on Add Button and uses explicit wait.
//		Test asserts that the checkbox is present.
        Remov_add_Button.click();

        wait.until(ExpectedConditions.visibilityOf(check_box));
        // WaitFor_visibility(driver, Duration.ofSeconds(2), check_box);
        Assert.assertEquals(msg.getText(),"It's back!","wrong");

//		Test clicks on the Enable Button and uses explicit wait.
//		Test asserts that the text box is enabled.
        Enable_disablee_Button.click();

        wait.until(ExpectedConditions.elementSelectionStateToBe(Enable_disablee_Button, false));
        //WaitFor_state(driver, Duration.ofSeconds(2), Enable_disablee_Button,false );
        Assert.assertEquals(msg.getText(),"It's enabled!","wrong");

//		Test clicks on the Disable Button and uses explicit wait.
//		Test asserts that the text box is disabled.
        Enable_disablee_Button.click();

        //  wait.until(ExpectedConditions.elementToBeSelected(Enable_disablee_Button));

        //  WaitFor_attribute_To_Be_Not_Empty(driver, Duration.ofSeconds(2), Enable_disablee_Button, "disabled");
        Assert.assertEquals(msg.getText(),"It's disabled!","wrong");
    }
}


package Dynamics;

import Pages.DynamicContentPage;
import Pages.DynamicControlsPge;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class DynamicControlsTest extends TestBase {


    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/dynamic_controls"));
    }
    WebDriverWait wait;

    @Test
    public void DynamicContenttest_removeboxtest() {
        DynamicControlsPge dc=new DynamicControlsPge();
        dc.removebutton.click();
        wait=new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(dc.checkBoxMessage));
        Assert.assertEquals(dc.checkBoxMessage.getText(),"It's gone!");
        dc.removebutton.click();
        wait.until(ExpectedConditions.visibilityOf(dc.checkBoxMessage));
        Assert.assertEquals(dc.checkBoxMessage.getText(),"It's back!");

    }




    @Test
    public void enableButton_test(){
        DynamicControlsPge dc=new DynamicControlsPge();
        dc.enableButton.click();
        wait=new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.elementToBeClickable(dc.textbox));
        Assert.assertEquals(dc.textMessage.getText(),"It's enabled!");
        dc.enableButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(dc.textbox)));
        Assert.assertEquals(dc.textMessage.getText(),"It's disabled!");


    }
}

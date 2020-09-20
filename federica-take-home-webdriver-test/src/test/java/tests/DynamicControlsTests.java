package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import utils.Driver;
import utils.TestBase;

public class DynamicControlsTests extends TestBase {

    String url="dynamic_controls";
    DynamicControlsPage dynamicControlsPage=new DynamicControlsPage();
    WebDriverWait wait;
    @BeforeTest
    public void setUrl(){
        Driver.setUp(url);
    }


    @Test
    public void removeTest(){
        dynamicControlsPage.removeButton.click();
        wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.checkBoxMessage));
        Assert.assertEquals(dynamicControlsPage.checkBoxMessage.getText(),"It's gone!");
        dynamicControlsPage.removeButton.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.checkBoxMessage));
        Assert.assertEquals(dynamicControlsPage.checkBoxMessage.getText(),"It's back!");
    }

    @Test
    public void enableButton(){
        dynamicControlsPage.enableButton.click();
        wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.textBox));
        Assert.assertEquals(dynamicControlsPage.textBoxMessage.getText(),"It's enabled!");
        dynamicControlsPage.enableButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(dynamicControlsPage.textBox)));
        Assert.assertEquals(dynamicControlsPage.textBoxMessage.getText(),"It's disabled!");
    }
}

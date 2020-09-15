package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class ContextMenuPage extends PageBase {

    @FindBy(xpath = "//*[@id='hot-spot']")
    protected WebElement hotSpot;



    public void clickOnWindow(){
        BrowserUtils.rightClick(hotSpot);
        BrowserUtils.wait(2);
    }
    public void getText(){

        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        String expectedResult = "You selected a context menu";
        Assert.assertEquals(expectedResult,alertMessage);

    }
}

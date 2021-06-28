package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;


public class FloatingMenuPage extends PageBase {

    @FindBy(xpath = "//*[@id='menu']")
    protected WebElement menu;

    @FindBy(xpath = "//*[@style='text-align: center;']")
    protected WebElement targetPoint;

    public void scrollAndCheck(){
        BrowserUtils.scrollToElement(targetPoint);
        BrowserUtils.wait(3);
        Assert.assertTrue(menu.isDisplayed());
    }
}

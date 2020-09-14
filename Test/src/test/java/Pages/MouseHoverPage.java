package Pages;

import Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MouseHoverPage extends PageBase {

    @FindBy(xpath = "//a[@href='/users/1']//ancestor::div[@class='figure']")
    WebElement fistUser;

    @FindBy(xpath = "//a[@href='/users/1']")
    WebElement user1;

    @FindBy(xpath = "//a[@href='/users/2']")
    WebElement user2;

    @FindBy(xpath = "//a[@href='/users/3']")
    WebElement user3;

    public void hover(){
        BrowserUtils.hoverOver(fistUser);
        Assert.assertTrue(user1.isDisplayed());
        Assert.assertFalse(user2.isDisplayed());
        Assert.assertFalse(user3.isDisplayed());
    }
}

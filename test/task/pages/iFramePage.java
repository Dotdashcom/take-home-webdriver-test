package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class iFramePage extends PageBase{
    @FindBy(xpath = "//iframe")
    protected WebElement iFrame;

    @FindBy(xpath = "//*[@id='tinymce']")
    protected WebElement text;

    public void checkFrame(){
        driver.switchTo().frame(iFrame);
        text.clear();
        String expectedText = "Hallo World";
        BrowserUtils.waitForVisibility(text,5);
        text.sendKeys(expectedText);
        String actualText =text.getText() ;
        Assert.assertEquals(expectedText,actualText);
        driver.switchTo().defaultContent();
    }

}

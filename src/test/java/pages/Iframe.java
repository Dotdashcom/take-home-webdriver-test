package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Iframe extends POBase {
    public void verifyIframe(){
        BrowserUtil.GetDriver().switchTo().frame("mce_0_ifr");
        String text = "some text";
        getElement(By.id("tinymce")).clear();
        getElement(By.id("tinymce")).sendKeys(text);
        Assert.assertEquals(getElement(By.id("tinymce")).getText(), text);
    }
}

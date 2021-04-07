package Iframe;

import Pages.FloatingMenuPage;
import Pages.IframePages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class IframeTest extends TestBase {
    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/iframe"));
    }
    @Test
    public void IframePagestest() {
        String text="enter some text here";
        IframePages f=new IframePages();
        Driver.getDriver().switchTo().frame(f.iframe);
        f.textbox.clear();
        f.textbox.sendKeys(text);
        Assert.assertEquals(f.textbox.getText(),text);

    }
}

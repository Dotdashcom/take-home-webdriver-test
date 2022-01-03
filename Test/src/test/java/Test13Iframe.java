
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.IframePage;
public class Test13Iframe extends TestBase{

    @Test
    public void test13Iframe() throws InterruptedException{
        IframePage iframePage = new IframePage(webDriver);
        Thread.sleep(1000);
        // close error message first if it exists
        iframePage.closeErrorMessageIfExist();
        iframePage.switchToIframe();
        String text = iframePage.getText();
        iframePage.setText("prefix --- ");
        Assert.assertEquals(iframePage.getText(), "prefix --- "+text);
    }
}

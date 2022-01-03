import pageObject.OpenInNewTabPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class Test17OpenInNewTab extends TestBase{
    
    @Test
    public void test17OpenInNewTab() throws InterruptedException{
        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(webDriver);
        openInNewTabPage.openNewTab();
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
        Assert.assertEquals(tabs.size(), 2);
        webDriver.switchTo().window(tabs.get(1));
        Assert.assertEquals(webDriver.getCurrentUrl(), "http://localhost:7080/windows/new");
    }
}

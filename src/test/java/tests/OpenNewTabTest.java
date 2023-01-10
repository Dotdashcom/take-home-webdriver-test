package tests;

import model.OpenNewTabPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class OpenNewTabTest extends BaseTest {

    @Test
    public void testNewTabOpen() {
        OpenNewTabPage openNewTabPage = new OpenNewTabPage(getDriver())
                .getOpenNewTabPage();
        String initialTabHandle = getDriver().getWindowHandle();

        List<String> allTabList = openNewTabPage
                .clickHereLink()
                .getTabHandlesList();
        for(String tab : allTabList) {
            if(!tab.equals(initialTabHandle)) {
                getDriver().switchTo().window(tab);
            }
        }

        String newWindowHandle = getDriver().getWindowHandle();
        Assert.assertFalse(initialTabHandle.equals(newWindowHandle));
    }

    @Test
    public void testNewTabOpenByURL() {
        OpenNewTabPage openNewTabPage = new OpenNewTabPage(getDriver())
                .getOpenNewTabPage();
        String initialTabHandle = getDriver().getWindowHandle();
        String initialURL = getDriver().getCurrentUrl();

        List<String> allTabList = openNewTabPage
                .clickHereLink()
                .getTabHandlesList();
        for(String tab : allTabList) {
            if(!tab.equals(initialTabHandle)) {
                getDriver().switchTo().window(tab);
            }
        }

        String newURL = getDriver().getCurrentUrl();
        Assert.assertFalse(initialURL.equals(newURL));
    }

    @Test
    public void testNewTabOpenByContentsPageSource() {
        OpenNewTabPage openNewTabPage = new OpenNewTabPage(getDriver())
                .getOpenNewTabPage();
        String initialTabHandle = getDriver().getWindowHandle();
        String initialPageSource = getDriver().getPageSource();

        List<String> allTabList = openNewTabPage
                .clickHereLink()
                .getTabHandlesList();
        for(String tab : allTabList) {
            if(!tab.equals(initialTabHandle)) {
                getDriver().switchTo().window(tab);
            }
        }

        String newPageSource = getDriver().getCurrentUrl();
        Assert.assertFalse(initialPageSource.equals(newPageSource));
    }
}
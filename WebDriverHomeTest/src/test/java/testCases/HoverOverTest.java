package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HoverOverPage;
import testComponents.BaseTest;

public class HoverOverTest extends BaseTest {


    @Test
    public void hoverOver() throws InterruptedException {
        HoverOverPage hoverOverPage=new HoverOverPage(driver);
        hoverOverPage.goTo();
        hoverOverPage.hoverover();
        Assert.assertEquals(hoverOverPage.getText(), new String[]{"name: user1\n" +
                "View profile\n" +
                "name: user2\n" +
                "View profile\n" +
                "name: user3\n" +
                "View profile\n"});


    }
}

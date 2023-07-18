package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FloatingMenuPage;
import testComponents.BaseTest;

public class FloatingMenuTest extends BaseTest {


    @Test
    public void flotingMenu(){
        FloatingMenuPage floatingMenuPage=new FloatingMenuPage(driver);
        floatingMenuPage.goTo();
        floatingMenuPage.menuBar();
        String text=floatingMenuPage.getText();
        Assert.assertEquals(text,"Home\n" +
                "News\n" +
                "Contact\n" +
                "About");
    }
}

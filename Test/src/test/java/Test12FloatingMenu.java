
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FloatingMenuPage;
public class Test12FloatingMenu extends TestBase{

    @Test
    public void test12FloatingMenu () throws InterruptedException{
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(webDriver);
        // check floating menu is display before scroll
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());

        floatingMenuPage.scorllDownToTheBottom();
        Thread.sleep(2000);
        // check floating menu is display after scroll
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
        
    }
}

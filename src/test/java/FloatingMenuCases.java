import org.testng.Assert;
import org.testng.annotations.Test;


public class FloatingMenuCases extends Hooks {

    @Test
    public  void FloatingMenu() throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.FloatingMenu.getOption());
        Assert.assertTrue(App.floatingMenuPage.scrollToBottonValidateMenu());


    }
}

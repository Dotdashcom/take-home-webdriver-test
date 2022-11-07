import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class JSLoadCases extends Hooks {




    @Test(dataProvider = "JSLoadError")
    public  void JSLoad(String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.JSErrorLoad.getOption());

        Assert.assertTrue(App.jsLoadPage.validateTextPage(text));
    }
}

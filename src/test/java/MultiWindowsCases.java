import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiWindowsCases extends Hooks {



    @Test(dataProvider = "MultiWindows")
    public  void NewWindows(int index,String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.MultipleWindows.getOption());
        App.multiWindowsPage.clickNewWindow();
        Assert.assertTrue(App.multiWindowsPage.validateTextPage(index,text));
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuCases extends Hooks {

    @Test(dataProvider = "Contextmenu")
    public  void Checkbox(String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.ContextMenu.getOption());
        App.contextMenuPage.contextClickSquareContex();
        Assert.assertTrue(App.driver.switchTo().alert().getText().contains(text));
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;


public class MouseHoverCases extends Hooks {

    @Test
    public  void DynamicControl() throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.Hover.getOption());

        Assert.assertTrue(App.hoverPage.validateInfoDiplayEachUserHover());


    }
}

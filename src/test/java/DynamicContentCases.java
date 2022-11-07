import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicContentCases extends Hooks {

    @Test(dataProvider = "DynamicContent")
    public  void DynamicContent(int loop) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.DynamicContent.getOption());

        for (int i =0;i<loop;i++){
            String page =App.driver.getPageSource();
            App.driver.navigate().refresh();
            Thread.sleep(1000);
            Assert.assertNotEquals(App.driver.getPageSource(),page);

        }

    }
}

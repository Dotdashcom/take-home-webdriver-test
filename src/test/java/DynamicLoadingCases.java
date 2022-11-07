import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DynamicLoadingCases extends Hooks {



    @Test(dataProvider = "DynamicLoading")
    public  void DynamicLoadingExaple1(String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.DynamicLoading.getOption());

        App.dynamicLoadingPage.clickButtonHidden();
        App.dynamicLoadingPage.clickButtonStart();


        Assert.assertTrue(App.dynamicLoadingPage.validateTitleValue(text));

    }

    @Test(dataProvider = "DynamicLoading")
    public  void DynamicLoadingExaple2(String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.DynamicLoading.getOption());

        App.dynamicLoadingPage.clickButtonRendered();
        App.dynamicLoadingPage.clickButtonStart();


        Assert.assertTrue(App.dynamicLoadingPage.validateTitleValue(text));

    }
}

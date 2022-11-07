import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DropDownCases extends Hooks {



    @Test(dataProvider = "DropDown")
    public  void Dropdown(String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.DropDown.getOption());
        App.dropDownPage.selectOptionByText(text);
        Assert.assertTrue(App.dropDownPage.validateOptionText(text));
    }
}

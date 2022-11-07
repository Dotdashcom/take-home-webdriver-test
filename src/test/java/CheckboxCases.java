import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxCases extends Hooks {

    @Test(dataProvider = "Checkbox")
    public  void Checkbox(int index,boolean result) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.CheckBox.getOption());
        Assert.assertEquals(App.checkboxPage.ValidateCheckbox(index).isSelected(),result);
    }
}

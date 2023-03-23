package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.DropdownPages;

public class DropdownSteps {

    DropdownPages dropdownPages = new DropdownPages();

    public void selectOption(String text){
        dropdownPages.selectElementFromDropdown(text);
    }

    @Step("Check if option was selected")
    public void checkSelectedOption(String text){
        Assert.assertEquals(dropdownPages.getSelectedOption(), text);
    }
}

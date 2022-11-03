package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class DropDownPage {

    private static DropDownPage _instance = null;
    private final By dropdownMenu = By.id("dropdown");

    public static DropDownPage getInstance() {
        if (_instance == null)
            _instance = new DropDownPage();
        return _instance;
    }

    public void selectFromDropDown(String option) {
        ActionHelper.selectFromDD(dropdownMenu, option);
    }

    public String getSelectedOption() {
        return ActionHelper.getSelectedOption(dropdownMenu);
    }
}
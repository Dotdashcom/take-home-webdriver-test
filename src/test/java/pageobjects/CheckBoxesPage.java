package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class CheckBoxesPage {

    private final By checkBox1 = By.cssSelector("#checkboxes input:first-of-type");
    private final By checkBox2 = By.cssSelector("#checkboxes input:last-of-type");

    private static CheckBoxesPage _instance = null;

    public static CheckBoxesPage getInstance() {
        if (_instance == null)
            _instance = new CheckBoxesPage();
        return _instance;
    }

    public void selectCheckBox1() {
        ActionHelper.click(checkBox1);
    }

    public void selectCheckBox2() {
        ActionHelper.click(checkBox2);
    }

    public boolean isCheckBox1Selected() {
        return ActionHelper.isSelected(checkBox1);
    }

    public boolean isCheckBox2Selected() {
        return ActionHelper.isSelected(checkBox2);
    }

    public boolean isCheckBoxesSelected() {
        return isCheckBox1Selected() && isCheckBox2Selected();
    }

}
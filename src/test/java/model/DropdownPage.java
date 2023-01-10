package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import model.base.BasePage;
import runner.BaseUtils;

public class DropdownPage extends BasePage {

    private static final String DROPDOWN_ENDPOINT = "dropdown";

    @FindBy(css = "h3")
    private WebElement header;

    @FindBy(css = "#dropdown")
    private WebElement dropdownMenu;

    @FindBy(css = "[value='']")
    private WebElement dropdownOptionPlaceholder;

    @FindBy(css = "[value='1']")
    private WebElement dropdownOptionOne;

    @FindBy(css = "[value='2']")
    private WebElement dropdownOptionTwo;

    @FindBy(css = "[selected='selected']")
    private WebElement dropdownMenuSelectedItem;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {

        return header.getText();
    }

    public DropdownPage getDropdownPage() {
        getDriver(DROPDOWN_ENDPOINT);

        return this;
    }

    public DropdownPage dropdownMenuOptions() {
        dropdownMenu.click();

        return this;
    }

    public DropdownPage selectDropdownMenuPlaceholderOption() {
        try {
            new Select(dropdownMenu).selectByIndex(0);
        } catch (UnsupportedOperationException e) {
            BaseUtils.log("Placeholder element is not selectable. You may not select a disabled option");
        }
        return this;
    }

    public DropdownPage selectDropdownMenuOptionOne() {
        new Select(dropdownMenu).selectByIndex(1);

        return this;
    }

    public DropdownPage selectDropdownMenuOptionTwo() {
        new Select(dropdownMenu).selectByIndex(2);

        return this;
    }

    public String getDropdownMenuPlaceholderOptionText() {

        return dropdownOptionPlaceholder.getText();
    }

    public String getDropdownMenuOptionOneText() {

        return dropdownOptionOne.getText();
    }

    public String getDropdownMenuOptionTwoText() {

        return dropdownOptionTwo.getText();
    }

    public String getDropdownMenuSelectedOptionText() {

        return dropdownMenuSelectedItem.getText();
    }

    public boolean isPlaceholderOptionSelected() {

        return dropdownOptionPlaceholder.isSelected();
    }
}
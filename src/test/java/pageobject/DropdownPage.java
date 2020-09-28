package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver, EndPointPath.DROPDOWN);
    }

    public void selectDropDownByNameDisplay(String name) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(name);

    }

    public void selectDropDownByValue(String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);

    }

    public boolean verifyDropdownSelectedByNameDisplay(String name) {
        Select select = new Select(dropdown);
        String selected = select.getFirstSelectedOption().getText();
        return selected.equals(name);
    }

    public boolean verifyDropdownSelectedByValue(String value) {
        Select select = new Select(dropdown);
        String selected = select.getFirstSelectedOption().getAttribute("value");
        return selected.equals(value);
    }


}

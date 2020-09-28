package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends BasePage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxes;

    public CheckboxPage(WebDriver driver) {
        super(driver, EndPointPath.CHECKBOX);
    }

    public void checkCheckBox(String checkboxName) {
        checkboxes.click();
    }

    public boolean isCheck() {
        return checkboxes.isSelected();
    }

    public boolean isNotCheck() {
        return !checkboxes.isSelected();
    }

}

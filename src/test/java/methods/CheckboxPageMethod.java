package methods;

import model.CheckboxPage;
import org.openqa.selenium.WebElement;

public class CheckboxPageMethod extends GeneralTestMethod{

    private final String checkboxURL = "http://localhost:7080/checkboxes";
    CheckboxPage checkboxPage;
    WebElement checkbox;

    public void startCheckboxTest(String i) {
        driver.get(checkboxURL);
        checkboxPage = new CheckboxPage(driver);
        checkbox = checkboxPage.checkboxButtonComponent(i);
        checkbox.click();
    }

    public boolean isBoxChecked() {
        return checkbox.isSelected();
    }

}

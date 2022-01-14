package methods;

import model.DropdownPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownMethod extends GeneralTestMethod{

    private final String dropdownURL = "http://localhost:7080/dropdown";
    protected String selection = new String();
    DropdownPage dropdownPage;

    public void startDropdownTest(String selection) {
        driver.get(dropdownURL);
        dropdownPage = new DropdownPage(driver);
        makeSelection(dropdownPage.dropdownComponent(), selection);
    }

    public void makeSelection(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByValue(value);
        selection = select.getFirstSelectedOption().getText();
    }
}

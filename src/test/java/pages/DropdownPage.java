package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    public DropdownPage() {
        url = "http://localhost:7080/dropdown";
    }

    @FindBy(xpath = "//select[@id='dropdown']")
    private WebElement dropdownElement;

    public void selectOption(String option) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(option);
    }

    public String getSelectedOption() {
        Select dropdown = new Select (dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        return selectedOption;
    }
}

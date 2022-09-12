package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends BasePage {
    public CheckboxesPage() {
        url = "http://localhost:7080/checkboxes";
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    public void selectAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void unselectAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public boolean areAllCheckboxesChecked() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
}

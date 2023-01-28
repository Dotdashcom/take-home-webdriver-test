package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends BasePage {
    @FindBy(tagName = "h3")
    private WebElement checkBoxPageTitle;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    public void uncheckAllCheckBoxes() {
        checkBoxes.forEach(checkBox -> {
            if (isChecked(checkBox)) {
                checkBox.click();
                // Verify that current checkbox is unchecked now
                Assertions.assertFalse(isChecked(checkBox));
            }
        });

    }

    public void clickOnCheckBoxAndVerify(int index, boolean deselect) {
        WebElement checkBox = checkBoxes.get(index);
        checkBox.click();
        if (deselect) {
            Assertions.assertFalse(isChecked(checkBox));
        } else {
            Assertions.assertTrue(isChecked(checkBox));
        }
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, checkBoxPageTitle.getText());
    }

    @Override
    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(checkBoxPageTitle.isDisplayed());
        Assertions.assertFalse(checkBoxes.isEmpty());
    }

    private boolean isChecked(WebElement checkBox) {
        return Boolean.parseBoolean(checkBox.getAttribute("checked"));
    }

    public CheckBoxPage(WebDriver webDriver) {
        super(webDriver);
    }
}

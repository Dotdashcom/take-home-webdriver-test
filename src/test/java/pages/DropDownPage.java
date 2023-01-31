package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage extends BasePage {
    @FindBy(tagName = "h3")
    private WebElement dropDownPageTitle;

    @FindBy(id = "dropdown")
    private WebElement dropDownList;

    @FindBy(tagName = "option")
    private List<WebElement> options;

    public DropDownPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void assertOptionIsDeselected(String value) {
        WebElement option = getOptionByValue(value);
        Assertions.assertNotNull(option);
        Assertions.assertFalse(option.isSelected());
    }

    public void assertOptionIsSelected(String value) {
        WebElement option = getOptionByValue(value);
        Assertions.assertNotNull(option);
        Assertions.assertTrue(option.isSelected());
    }

    public void deselectOptionByValue(String value) {
        Select select = new Select(dropDownList);
        select.deselectByValue(value);
    }

    public void selectOptionByValue(String value) {
        Select select = new Select(dropDownList);
        select.selectByValue(value);
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, dropDownPageTitle.getText());
    }

    @Override
    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(dropDownList.isDisplayed());
        Assertions.assertTrue(dropDownPageTitle.isDisplayed());
        Assertions.assertFalse(options.isEmpty());
    }

    private WebElement getOptionByValue(String value) {
        for (WebElement option : options) {
            if (option.getAttribute("value").equals(value))
                return option;
        }
        return null;
    }
}

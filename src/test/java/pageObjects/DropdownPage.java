package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends Page {
    private static final By DROPDOWN_LIST = By.id("dropdown");
    private Select dropdownListElement;

    public DropdownPage(ChromeDriver driver) {
        super(driver);
    }

    public DropdownPage selectOption(String option) {
        dropdownListElement = getSelect(DROPDOWN_LIST, BasePage.TIMEOUT);
        dropdownListElement.selectByVisibleText(option);
        return this;
    }

    public String getSelectedOptionText() {
        return dropdownListElement.getFirstSelectedOption().getText();
    }
}

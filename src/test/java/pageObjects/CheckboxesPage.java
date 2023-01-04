package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxesPage extends Page {
    private static final String CHECKBOX = "(//input[@type='checkbox'])[%s]";

    public CheckboxesPage(ChromeDriver driver) {
        super(driver);
    }

    public CheckboxesPage clickCheckbox(int number) {
        click(By.xpath(String.format(CHECKBOX, number)), BasePage.TIMEOUT);
        return this;
    }

    public boolean isCheckboxChecked(int number) {
        return isElementSelected(By.xpath(String.format(CHECKBOX, number)), BasePage.TIMEOUT);
    }
}

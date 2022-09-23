package pages;

import core.AbstractWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends AbstractWebPage {

    protected WebElement dropDownElm;
    protected Select dropdownSelect;

    public DropdownPage(WebDriver driver) {
        super(driver);
        dropDownElm = driver.findElement(By.id("dropdown"));
        dropdownSelect = new Select(dropDownElm);
    }

    public String getSelectedOption() {
        return dropdownSelect.getAllSelectedOptions().get(0).getText();
    }

    public void selectOptionByVisibleText(String text) {
        dropdownSelect.selectByVisibleText(text);
    }

    public void selectOptionByValue(String value) {
        dropdownSelect.selectByVisibleText(value);
    }

    public void selectOptionByVIndex(int index) {
        dropdownSelect.selectByIndex(index);
    }
}


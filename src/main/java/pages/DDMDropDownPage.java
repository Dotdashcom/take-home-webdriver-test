package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DDMDropDownPage extends DDMBasePage  {
    @FindBy(id = "dropdown")
    protected WebElement dropDown;

    public DDMDropDownPage(WebDriver driver)  {
        super(driver);
    }

    public void selectOption(String optionName)  {
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(optionName);
    }

    public String getSelectedOption()  {
        Select dropdown = new Select(dropDown);
        return dropdown.getFirstSelectedOption().getText();
    }
}
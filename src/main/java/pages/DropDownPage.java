package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {

    @FindBy(id = "dropdown")
    protected WebElement dropDownElm;

    protected Select dropdown;

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    public void selectOption(String optionName){
        pauseInSeconds(1);
        dropdown = new Select(dropDownElm);
        dropdown.selectByVisibleText(optionName);
    }

    public String currentSelectedOption() {
        List<WebElement> allValues = dropdown.getAllSelectedOptions();
        return allValues.get(0).getText();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    private By dropDownMenu = By.id("dropdown");

    public DropdownPage (WebDriver driver){
        super(driver);
    }

    public void selectOption(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownMenu));
        Select select = new Select(getElement(dropDownMenu));
        select.selectByVisibleText(option);
    }

    public String getSelectedOptionText(){
        return new Select(getElement(dropDownMenu)).getFirstSelectedOption().getText();
    }
}

package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    @FindBy(id="dropdown")
    WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void select(String text){
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public String getOptionSelected(){
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

}

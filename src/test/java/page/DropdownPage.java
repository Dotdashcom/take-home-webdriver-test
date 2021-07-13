package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends PageObject {

    @FindBy(how = How.ID, using = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectOption(String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public String getSelectedValue() {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }
}

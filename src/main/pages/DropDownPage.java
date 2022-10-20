package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage extends BasePage{


    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    private WebElement dropdownList;

     public void select(String option) {
        Select select = new Select(dropdownList);
        List<WebElement> allOptions = select.getOptions();

        for (WebElement temp: allOptions) {
            if (temp.getText().equals(option)) {
                temp.click();
                break;
            }
        }
    }

    public String getSelectedOption() {
        Select select = new Select(dropdownList);

        return select.getFirstSelectedOption().getText();
    }
}

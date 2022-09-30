package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxPage extends BasePage {

    @FindBy(css="input[type='checkbox']")
    List<WebElement> checkboxes;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void click(int position){
        // position is index+1 (index starts at 0)
        checkboxes.get(position-1).click();
    }

    public boolean isCheckboxSelected(int position){
        return checkboxes.get(position-1).isSelected();
    }

}

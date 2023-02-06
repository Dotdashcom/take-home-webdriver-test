package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DDMCheckBoxPage extends DDMBasePage  {
    @FindBy(css = "[id='checkboxes'] > input")
    protected List<WebElement> checkBoxes;

    public DDMCheckBoxPage(WebDriver driver)  {
        super(driver);
    }

    public void selectCheckBox(int index)  {
        checkBoxes.get(index).click();
    }

    public boolean isCheckBoxSelected(int index)  {
        return checkBoxes.get(index).isSelected();
    }
}
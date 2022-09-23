package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

    @FindBy(css = "#checkboxes>input")
    protected List<WebElement> checkBoxList;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean selectCheckBox(int index){
        checkBoxList.get(index).click();
        return checkBoxList.get(index).isSelected();
    }
}

package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends AbstractWebPage {

    @FindBy(css = "#checkboxes > input")
    List<WebElement> checkBoxList;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChecked(int index) {
        return checkBoxList.get(index).isSelected();
    }

    public void selectCheckbox(int index) {
        if(!isChecked(index)) {
            checkBoxList.get(index).click();
        }
    }

    public void unSelectCheckbox(int index) {
        if(isChecked(index)) {
            checkBoxList.get(index).click();
        }
    }



}

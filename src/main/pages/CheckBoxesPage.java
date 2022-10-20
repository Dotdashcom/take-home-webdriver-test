package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CheckBoxesPage extends  BasePage {

    @FindBy(css = "form[id='checkboxes'] > input")
    private List<WebElement> checkBoxList;


    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    public void selectCheckBoxOne() {
        checkBoxList.get(0).click();
    }

    public void selectCheckBoxTwo() {
        checkBoxList.get(1).click();
    }

    public boolean isCheckboxOneSelected() {
        return checkBoxList.get(0).isSelected();
    }

    public boolean isCheckboxTwoSelected() {
        return checkBoxList.get(1).isSelected();
    }
}


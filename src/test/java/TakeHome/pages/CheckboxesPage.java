package TakeHome.pages;


import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends BasePage{

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkBoxes;

    public void clickCheckBoxes() {
        checkBoxLink.click();
    }


    }


package page_object_model.drop_down_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends Base {
    public DropDownPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dropdown")
    private WebElement selectDropDownButton;
    @FindBy(xpath = "//select[@id='dropdown']//option[text()='Option 1']")
    public static WebElement optionOne;
    @FindBy(xpath = "//select[@id='dropdown']//option[text()='Option 2']")
    public static WebElement optionTwo;

    public void selectOptions(String option) {
        Select select = new Select(selectDropDownButton);
        select.selectByVisibleText(option);
    }

}

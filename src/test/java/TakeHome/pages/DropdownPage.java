package TakeHome.pages;

import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{
    public DropdownPage() {

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="dropdown")
    private WebElement dropdown;

    Select dropOptions = new Select(dropdown);

    public void selectOption1(){
        dropOptions.selectByIndex(1);
    }

    public void selectOption2(){
        dropOptions.selectByIndex(2);
    }

    public String getSelectedOptionText(){
        return dropOptions.getFirstSelectedOption().getText();
    }

}

package LocalHost.Pages;

import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    public DropDownPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="dropdown")
    private WebElement dropdown;



    public void SelectOption1(){
        Select dropOptions = new Select(dropdown);
        dropOptions.selectByIndex(1);
    }
    public void SelectOption2(){
        Select dropOptions = new Select(dropdown);
        dropOptions.selectByIndex(2);
    }
    public void Select_By_Option_Number(int x){
        Select dropOptions = new Select(dropdown);
        dropOptions.selectByIndex(x);
    }
    public boolean Verify_Selection(String str){
        Select dropOptions = new Select(dropdown);
        String option=dropOptions.getFirstSelectedOption().getText();
         if(option.equals(str))
             return true;
         else
             return false;

    }

}

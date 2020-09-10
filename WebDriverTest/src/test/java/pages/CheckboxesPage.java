package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends Functions {

    @FindBy(css="input[type='checkbox']")
    public List<WebElement> checkboxes;

    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public CheckboxesPage(){

        PageFactory.initElements(driver, this);

    }

    /**
     * Method implements login to the application
     */
    public void clickCheckbox(){
        for(WebElement checkbox: checkboxes){
            if(!checkbox.isSelected()) {
                click(checkbox);
            }
        }
    }

    public boolean checkAllSelected(){
        for(WebElement checkbox: checkboxes){
            if(!checkbox.isSelected()){
                return false;
            }
        }
        return true;
    }

    public void clickUnCheckbox(){
        for(WebElement checkbox: checkboxes){
            if(checkbox.isSelected()) {
                click(checkbox);
            }
        }
    }

}

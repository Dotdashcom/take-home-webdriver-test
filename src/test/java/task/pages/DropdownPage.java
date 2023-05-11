package task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import task.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class DropdownPage {

    public DropdownPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "dropdown")
    public WebElement dropDown;

    public boolean isSelected(String option) {


        Select select = new Select(dropDown);

        List<WebElement> dropDown = select.getOptions();

        for (WebElement eachOption : dropDown) {
            if (eachOption.getText().equals(option)) { //if the desired option and each are equal
                select.selectByVisibleText(option);
                eachOption.isSelected();
                return true;
            }



        }
        return false;
    }
}

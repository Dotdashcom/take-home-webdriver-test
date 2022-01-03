package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckBoxesPage{
    WebDriver webDriver;
    String checkBoxesPageUrl = "http://localhost:7080/checkboxes";

    public CheckBoxesPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(checkBoxesPageUrl);
    }
    
    public boolean ischecked(WebElement checkbox){
        return checkbox.isSelected();
    }

    public void check(WebElement checkbox){
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }

    public void uncheck(WebElement checkbox){
        if (checkbox.isSelected()){
            checkbox.click();
        }
    }

}
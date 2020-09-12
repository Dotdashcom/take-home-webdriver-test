package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends  PageBase{

    @FindBy(xpath =  "//form[@id='checkboxes']/input[1]")
    WebElement checkbox1;

    @FindBy(xpath =  "//form[@id='checkboxes']/input[2]")
    WebElement checkbox2;

    public void checkbox(int checkboxNumber){
        switch (checkboxNumber) {
            case 1:
                BrowserUtils.click(checkbox1);
                break;
            case 2:
                BrowserUtils.click(checkbox2);
                break;
            default:
                BrowserUtils.click(checkbox1);
                BrowserUtils.click(checkbox2);
        }
    }

    public boolean checkBoxesStatus(){
        return checkbox1.isSelected() && checkbox2.isSelected();
    }


}

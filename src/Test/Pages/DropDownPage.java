package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    public DropDownPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(id = "dropdown")
    private WebElement dropDown;

    public void selectFromDropDown(String text){
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String selectVerification(String text){
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
        String result = select.getFirstSelectedOption().getText();
        return result;
    }
}

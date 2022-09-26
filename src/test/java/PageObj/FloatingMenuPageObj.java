package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class FloatingMenuPageObj extends CommonMethods {

    public FloatingMenuPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//ul/child::li")
    private List<WebElement> menuBar;

    public List<WebElement> menuBar(){
        return menuBar;
    }

}

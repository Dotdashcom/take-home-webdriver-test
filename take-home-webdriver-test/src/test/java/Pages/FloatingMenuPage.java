package Pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FloatingMenuPage {
    public FloatingMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

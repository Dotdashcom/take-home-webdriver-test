package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {

    public FloatingMenuPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "menu")
    public WebElement floatingMenu;


}

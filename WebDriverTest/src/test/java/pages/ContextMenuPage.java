package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends Functions {

    @FindBy(id="hot-spot")
    public WebElement box;

    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public ContextMenuPage(){

        PageFactory.initElements(driver, this);

    }

}

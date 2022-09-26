package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPageObj extends CommonMethods {

    public ContextMenuPageObj() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "hot-spot")
    private WebElement box;
    @FindBy(xpath = "//h3")
    private WebElement header;

    public WebElement getHeader(){
        return header;
    }

    public WebElement getBox(){
        return box;
    }

}

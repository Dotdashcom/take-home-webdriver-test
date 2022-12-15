package Main;


import Utilities.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextPage {

    @FindBy(id = "hot-spot")
    public WebElement Context;

    public ContextPage() {

        PageFactory.initElements(DriverHelper.getDriver(), this);
    }
}
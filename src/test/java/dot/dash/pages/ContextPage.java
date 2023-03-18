package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextPage {
    public ContextPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "hot-spot")
    public WebElement box;


}

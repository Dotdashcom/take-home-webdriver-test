package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {

    @FindBy(id = "hot-spot")
    public WebElement Context;

    public ContextMenuPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
}

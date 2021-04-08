package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ContextMenuPage {
   public ContextMenuPage() {
       PageFactory.initElements(Driver.getDriver(), this);
   }
    @FindBy(id = "hot-spot")
    public WebElement box;

}

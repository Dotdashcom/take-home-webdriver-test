package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicContentPage {
    public DynamicContentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "content")
    public WebElement contentext;
}

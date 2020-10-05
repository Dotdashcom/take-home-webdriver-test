package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {
    public WebDriver ldriver;
    public ContextMenuPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the box
    @FindBy(xpath = "//div[@id='hot-spot']")
    public WebElement boxContext;





}

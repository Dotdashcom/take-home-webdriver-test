package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_05_DragDrop_Page {
    public TC_05_DragDrop_Page() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(partialLinkText =  "Drag and Drop")
    public WebElement dragDropLink;
    @FindBy(xpath = "//div[@id='column-a']")
    public WebElement boxA;

    @FindBy(xpath = "//div[@id='column-b']")
    public WebElement boxB;

}

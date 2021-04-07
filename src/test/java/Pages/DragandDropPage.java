package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DragandDropPage {
    public DragandDropPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id='column-a']")
    public WebElement box1;

    @FindBy(xpath = "//div[@id='column-b']")
    public WebElement box2;
}



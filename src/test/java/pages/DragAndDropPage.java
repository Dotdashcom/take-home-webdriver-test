package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DragAndDropPage {
    public DragAndDropPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='column-a']//header")
    public WebElement headerA;

    @FindBy(xpath = "//div[@id='column-b']//header")
    public WebElement headerB;

}

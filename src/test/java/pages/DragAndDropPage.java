package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DragAndDropPage {

    public DragAndDropPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement header;

    @FindBy(id = "column-a")
    public WebElement columnA;

    @FindBy(id = "column-b")
    public WebElement columnB;

}


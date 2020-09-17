package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DragAndDropPage {
    public DragAndDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "column-a")
    public WebElement box1;

    @FindBy(id = "column-b")
    public WebElement box2;
}

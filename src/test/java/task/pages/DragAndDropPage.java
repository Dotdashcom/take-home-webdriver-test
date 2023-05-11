package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class DragAndDropPage {

    public DragAndDropPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "column-a")
    public WebElement firstColumn;


    @FindBy(id = "column-b")
    public WebElement secondColumn;
}

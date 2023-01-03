package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends SeleniumLibrary
{

    public DragAndDropPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID , using = "column-a")
    WebElement columnA;

    @FindBy(how = How.ID , using = "column-b")
    WebElement columnB;

    public void DragDropActions()
    {
        dragAndDropActions(columnA , columnB);
    }
}

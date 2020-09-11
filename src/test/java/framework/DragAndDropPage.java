package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "column-a")
    WebElement columnA;

    @FindBy (id = "column-b")
    WebElement columnB;


    public DragAndDropPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void dragAndDropAction(WebDriver driver) {
        dragAndDrop(driver, columnA, columnB);
    }
}

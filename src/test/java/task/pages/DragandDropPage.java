package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragandDropPage extends BasePage {

    @FindBy (id = "column-a")
    public WebElement squareA;


    @FindBy (id="column-b")
    public WebElement squareB;
}

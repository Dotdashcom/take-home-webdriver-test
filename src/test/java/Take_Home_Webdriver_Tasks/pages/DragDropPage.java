package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragDropPage extends BasePage{

    @FindBy(id="column-a")
    public WebElement elementA;

    @FindBy (id="column-b")
    public WebElement elementB;
}

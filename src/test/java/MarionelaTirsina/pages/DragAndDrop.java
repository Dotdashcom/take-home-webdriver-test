package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDrop extends BasePage {
    @FindBy(id="column-a")
    public WebElement columnA;
    @FindBy(id="column-b")
    public WebElement columnB;
}

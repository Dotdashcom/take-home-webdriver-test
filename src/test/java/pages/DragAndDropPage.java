package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "column-a")
    public WebElement a;

    @FindBy(id = "column-b")
    public WebElement b;
}

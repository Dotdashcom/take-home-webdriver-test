package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPageObj extends CommonMethods {
    public DragAndDropPageObj() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "column-a")
    private WebElement a;

    @FindBy(id = "column-b")
    private WebElement b;

    public WebElement getBoxA() {
        return a;
    }

    public WebElement getBoxB() {
        return b;
    }

}

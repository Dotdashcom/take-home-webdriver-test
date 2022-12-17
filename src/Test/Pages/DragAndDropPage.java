package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
    public DragAndDropPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(xpath = "//div[@id ='column-a']")
    private WebElement elementA;

    @FindBy(xpath = "//div[@id ='column-b']")
    private WebElement elementB;

    public void DragAndDrop(){
        Actions actions = new Actions(Driver.GetDriver());
        actions.dragAndDrop(elementA,elementB).perform();
    }
}

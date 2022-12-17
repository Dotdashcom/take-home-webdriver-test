package Pages;

import Utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {
    public ContextMenuPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(id = "hot-spot")
    private WebElement boxInput;

    public void ClickContextMenu(){
        Actions actions = new Actions(Driver.GetDriver());
        actions.contextClick(boxInput).perform();
    }
    public String AlertMessage(){
        Alert alert = Driver.GetDriver().switchTo().alert();
        return alert.getText();
    }
    public void AcceptAlert(){
        Alert alert = Driver.GetDriver().switchTo().alert();
        alert.accept();
    }

}

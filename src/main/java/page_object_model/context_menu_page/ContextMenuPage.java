package page_object_model.context_menu_page;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends Base {

    public ContextMenuPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "hot-spot")
    private WebElement box;

    public void rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    public void rightClickWithJavascriptExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = ("var evt = document.createEvent('MouseEvents');" +
                "evt.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 2, null);" +
                "arguments[0].dispatchEvent(evt);");
        js.executeScript(script, box);
    }

}

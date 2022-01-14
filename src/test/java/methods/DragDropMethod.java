package methods;

import model.DragDropPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropMethod extends GeneralTestMethod {

    private final String dragDropURL = "http://localhost:7080/drag_and_drop";
    protected String originalA;
    protected String originalB;
    protected String afterA;
    protected String afterB;

    DragDropPage dragDropPage;

    public void startDragDropTest() {
        driver.get(dragDropURL);
        dragDropPage = new DragDropPage(driver);
        WebElement elementA = dragDropPage.elementA();
        WebElement elementB = dragDropPage.elementB();
        originalA = elementA.getText();
        originalB = elementB.getText();
        dragDrop(elementA,elementB);
        afterA = elementA.getText();
        afterB = elementB.getText();
    }

    public void dragDrop(WebElement source, WebElement target) {
        Actions action = new Actions(driver);
        action.clickAndHold(source).moveToElement(target).release().build().perform();
    }
}

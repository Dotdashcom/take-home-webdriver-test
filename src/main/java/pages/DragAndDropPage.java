package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends AbstractWebPage {

    @FindBy(id = "column-a")
    protected WebElement leftBoxElm;

    @FindBy(css = "#column-a > header")
    protected WebElement leftBoxHeaderElm;

    @FindBy(id = "column-b")
    protected WebElement rightBoxElm;

    @FindBy(css = "#column-b > header")
    protected WebElement rightBoxHeaderElm;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public String getLeftBoxHeader() {
        return leftBoxHeaderElm.getText();
    }

    public String getRightBoxHeader() {
        return rightBoxHeaderElm.getText();
    }

    public WebElement getLeftBoxElm() {
        return leftBoxElm;
    }

    public WebElement getRightBoxElm() {
        return rightBoxElm;
    }

    public void swapBoxes(WebElement from, WebElement to) {
        dragAndDropJS(from, to);
    }
}

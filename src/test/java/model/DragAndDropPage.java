package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import model.base.BasePage;

public class DragAndDropPage extends BasePage {

    @FindBy(xpath = "//div[@id='column-a']/header[text() = 'A']")
    private WebElement draggableElementA;

    @FindBy(xpath = "//div[@id='column-a']/header[text() = 'A']")
    private WebElement draggableElementB;

    @FindBy(css = "#column-a")
    private WebElement draggableElementOnTheLeft;

    @FindBy(css = "#column-b")
    private WebElement draggableElementOnTheRight;

    private static final String DRAG_AND_DROP_ENDPOINT = "drag_and_drop";

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage getDragAndDropPage() {
        getDriver(DRAG_AND_DROP_ENDPOINT);

        return new DragAndDropPage(getDriver());
    }

    public DragAndDropPage dragAndDropLeftElementOnRightElement() {
        dragAndDrop(draggableElementOnTheLeft, draggableElementOnTheRight);

        return this;
    }

    public DragAndDropPage dragAndDropRightElementOnLeftElement() {
        dragAndDrop(draggableElementOnTheRight, draggableElementOnTheLeft);

        return this;
    }

    public String getDraggabelElementAId() {

        return draggableElementA.getAttribute("id");
    }

    public String getDraggabelElementBId() {

        return draggableElementB.getAttribute("id");
    }

    public String getDraggableElementOnLeftText() {

        return draggableElementOnTheLeft.getText();
    }

    public String getDraggableElementOnRightText() {

        return draggableElementOnTheRight.getText();
    }
}
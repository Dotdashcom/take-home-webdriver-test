package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class DragAndDropPage {

    private static DragAndDropPage _instance = null;
    private final By fromElement = By.id("column-a");
    private final By toElement = By.id("column-b");

    public static DragAndDropPage getInstance() {
        if (_instance == null)
            _instance = new DragAndDropPage();
        return _instance;
    }

    public void performDragAndDrop() {
        ActionHelper.dragAndDrop(fromElement, toElement);
    }

    public String getTextFromElement() {
        return ActionHelper.getText(fromElement);
    }

    public String getTextToElement() {
        return ActionHelper.getText(toElement);
    }

    public boolean isTextChanged() {
        return getTextFromElement().equals("B") && getTextToElement().equals("A");
    }
}
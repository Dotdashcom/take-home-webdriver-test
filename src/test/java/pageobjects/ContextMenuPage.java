package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class ContextMenuPage {

    private static ContextMenuPage _instance = null;
    private final By contextMenu = By.id("hot-spot");

    public static ContextMenuPage getInstance() {
        if (_instance == null)
            _instance = new ContextMenuPage();
        return _instance;
    }

    public void rightClickContextMenu() {
        ActionHelper.contextClick(contextMenu);
    }

}
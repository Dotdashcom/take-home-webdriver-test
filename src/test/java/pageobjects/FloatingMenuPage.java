package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class FloatingMenuPage {

    private static FloatingMenuPage _instance = null;
    private final By floatingMenu = By.cssSelector("div.example #menu");

    public static FloatingMenuPage getInstance() {
        if (_instance == null)
            _instance = new FloatingMenuPage();
        return _instance;
    }

    public boolean isFloatingMenuDisplayed() {
        return ActionHelper.isPresent(floatingMenu);
    }

    public void scrollToBottom() {
        ActionHelper.scrollPageToBottom();
    }
}
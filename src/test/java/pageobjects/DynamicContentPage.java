package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class DynamicContentPage {

    private final By content = By.cssSelector("#content div.row #content div.row:nth-of-type(2) div.large-10");
    private static DynamicContentPage _instance = null;

    public static DynamicContentPage getInstance() {
        if (_instance == null)
            _instance = new DynamicContentPage();
        return _instance;
    }

    public String getTextOfContent() {
        return ActionHelper.getText(content);
    }
}
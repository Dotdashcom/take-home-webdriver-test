package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class SecurePage {
    private static SecurePage _instance = null;
    private final By message = By.cssSelector("#flash");
    private final By header = By.cssSelector("#content h2");


    public static SecurePage getInstance() {
        if (_instance == null) _instance = new SecurePage();
        return _instance;
    }


    public String getMessageText() {
        return ActionHelper.getText(message);
    }

    public String getHeaderText() {
        return ActionHelper.getText(header);
    }
}
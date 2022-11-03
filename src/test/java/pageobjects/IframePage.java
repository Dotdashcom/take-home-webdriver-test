package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class IframePage {

    private static IframePage _instance = null;
    private final By textBox = By.cssSelector("#tinymce");
    private final String iFrameID = "mce_0_ifr";

    public static IframePage getInstance() {
        if (_instance == null)
            _instance = new IframePage();
        return _instance;
    }

    public void switchToFrame() {
        ActionHelper.switchToFrame(iFrameID);
    }

    public String getText_TextBox() {
        return ActionHelper.getText(textBox);
    }
}
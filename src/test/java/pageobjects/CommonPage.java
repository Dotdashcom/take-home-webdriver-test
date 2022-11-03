package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class CommonPage {
    private final By loader = By.id("loading");

    public void waitForLoader() {
        ActionHelper.waitUntilElementInVisible(loader);
    }
}

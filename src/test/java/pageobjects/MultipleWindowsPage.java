package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class MultipleWindowsPage {
    private static MultipleWindowsPage _instance = null;
    private final By link = By.xpath("//a[text()='Click Here']");
    private final By header = By.cssSelector(" div.example h3");

    public static MultipleWindowsPage getInstance() {
        if (_instance == null)
            _instance = new MultipleWindowsPage();
        return _instance;
    }

    public void clickLink() {
        ActionHelper.click(link);
    }

    public String getTextHeader() {
        return ActionHelper.getText(header);
    }

}
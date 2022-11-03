package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class FileDownloadPage {

    private static FileDownloadPage _instance = null;
    private final By link = By.cssSelector("#content div.example a");

    public static FileDownloadPage getInstance() {
        if (_instance == null)
            _instance = new FileDownloadPage();
        return _instance;
    }

    public void clickLink() {
        ActionHelper.click(link);
    }
}

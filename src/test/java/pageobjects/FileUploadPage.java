package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class FileUploadPage {
    private static FileUploadPage _instance = null;
    private final By upload = By.cssSelector("#file-submit");
    private final By header = By.cssSelector("#content div.example h3");
    private final By chooseFile = By.cssSelector("#file-upload");

    public static FileUploadPage getInstance() {
        if (_instance == null)
            _instance = new FileUploadPage();
        return _instance;
    }

    public void clickUpload() {
        ActionHelper.click(upload);
    }

    public void chooseFileSendKeys(String path) {
        ActionHelper.fill(chooseFile, path);
    }

    public String getHeaderText() {
        return ActionHelper.getText(header);
    }

}
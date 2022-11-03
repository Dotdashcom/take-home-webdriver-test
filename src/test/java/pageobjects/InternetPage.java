package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class InternetPage {

    private static InternetPage _instance = null;
    private final By formAuthentication = By.xpath("//a[contains(text(),'Form Authentication')]");
    private final By checkBoxes = By.cssSelector("a[href='/checkboxes']");
    private final By contextMenu = By.cssSelector("a[href='/context_menu']");
    private final By drapAndDrop = By.cssSelector("a[href='/drag_and_drop']");
    private final By dropDown = By.cssSelector("a[href='/dropdown']");
    private final By dynamicContent = By.cssSelector("a[href='/dynamic_content']");
    private final By dynamicControls = By.cssSelector("a[href='/dynamic_controls']");
    private final By dynamicLoading = By.cssSelector("a[href='/dynamic_loading']");
    private final By fileDownload = By.cssSelector("a[href='/download']");
    private final By fileUpload = By.cssSelector("a[href='/upload']");
    private final By floatingMenu = By.cssSelector("a[href='/floating_menu']");
    private final By iframe = By.cssSelector("a[href='/frames']");
    private final By hover = By.cssSelector("a[href='/hovers']");
    private final By javascriptalert = By.cssSelector("a[href='/javascript_alerts']");
    private final By javascripterror = By.cssSelector("a[href='/javascript_error']");
    private final By windows = By.cssSelector("a[href='/windows']");
    private final By notification = By.cssSelector("a[href='/notification_message']");

    public static InternetPage getInstance() {
        if (_instance == null)
            _instance = new InternetPage();
        return _instance;
    }


    public void clickFormAuthentication() {
        ActionHelper.click(formAuthentication);
    }

    public void clickCheckBoxes() {
        ActionHelper.click(checkBoxes);
    }

    public void clickContextMenu() {
        ActionHelper.click(contextMenu);
    }

    public void clickDragAndDrop() {
        ActionHelper.click(drapAndDrop);
    }

    public void clickDropDown() {
        ActionHelper.click(dropDown);
    }

    public void clickDynamicContent() {
        ActionHelper.click(dynamicContent);
    }

    public void clickDynamicControls() {
        ActionHelper.click(dynamicControls);
    }

    public void clickDynamicLoading() {
        ActionHelper.click(dynamicLoading);
    }

    public void clickFileDownload() {
        ActionHelper.click(fileDownload);
    }

    public void clickFileUpload() {
        ActionHelper.click(fileUpload);
    }

    public void clickFloatingMenu() {
        ActionHelper.click(floatingMenu);
    }

    public void clickFrames() {
        ActionHelper.click(iframe);
    }

    public void clickHovers() {
        ActionHelper.click(hover);
    }

    public void clickAlert() {
        ActionHelper.click(javascriptalert);
    }

    public void clickError() {
        ActionHelper.click(javascripterror);
    }

    public void clickWindows() {
        ActionHelper.click(windows);
    }

    public void clickNotification() {
        ActionHelper.click(notification);
    }
}
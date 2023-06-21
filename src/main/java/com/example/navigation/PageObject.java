package com.example.navigation;

import com.example.cucumber.page.dropDown.DropDownPage;
import com.example.cucumber.page.home.HomePage;
import com.example.cucumber.page.checkbox.CheckBoxPage;
import com.example.cucumber.page.contextMenu.ContextMenuPage;
import com.example.cucumber.page.dragAndDrop.DragAndDropPage;
import com.example.cucumber.page.dynamicContent.DynamicContentPage;
import com.example.cucumber.page.dynamicControls.DynamicControlsPage;
import com.example.cucumber.page.dynamicLoading.DynamicLoadingPage;
import com.example.cucumber.page.fileDownload.FileDownloadPage;
import com.example.cucumber.page.fileUpload.FileUploadPage;
import com.example.cucumber.page.floatingMenu.FloatingMenuPage;
import com.example.cucumber.page.iframe.IframePage;
import com.example.cucumber.page.javaScriptAlerts.JavaScriptAlertsPage;
import com.example.cucumber.page.javaScriptError.JavaScriptErrorPage;
import com.example.cucumber.page.login.LoginPage;
import com.example.cucumber.page.mouseHover.MouseHoverPage;
import com.example.cucumber.page.notificationMessage.NotificationMessagePage;
import com.example.cucumber.page.openInNewTab.OpenInNewTabPage;
import org.openqa.selenium.WebDriver;

public class PageObject {
    private final WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private CheckBoxPage checkBoxPage;
    private ContextMenuPage contextMenuPage;
    private DragAndDropPage dragAndDropPage;
    private DropDownPage dropDownPage;
    private DynamicContentPage dynamicContentPage;
    private DynamicControlsPage dynamicControlsPage;
    private DynamicLoadingPage dynamicLoadingPage;
    private FileDownloadPage fileDownloadPage;
    private FileUploadPage fileUploadPage;
    private FloatingMenuPage floatingMenuPage;
    private IframePage iframePage;
    private MouseHoverPage mouseHoverPage;
    private JavaScriptErrorPage javaScriptErrorPage;
    private JavaScriptAlertsPage javaScriptAlertsPage;
    private OpenInNewTabPage openInNewTabPage;
    private NotificationMessagePage notificationMessagePage;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public LoginPage loginPage(){
        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public CheckBoxPage checkBoxPage(){
        if(checkBoxPage == null){
            checkBoxPage = new CheckBoxPage(driver);
        }
        return checkBoxPage;
    }

    public ContextMenuPage contextMenuPage(){
        if(contextMenuPage == null){
            contextMenuPage = new ContextMenuPage(driver);
        }
        return contextMenuPage;
    }

    public DragAndDropPage dragAndDropPage(){
        if(dragAndDropPage == null){
            dragAndDropPage = new DragAndDropPage(driver);
        }
        return dragAndDropPage;
    }

    public DropDownPage dropDownPage(){
        if(dropDownPage == null){
            dropDownPage = new DropDownPage(driver);
        }
        return dropDownPage;
    }

    public DynamicContentPage dynamicContentPage(){
        if(dynamicContentPage == null){
            dynamicContentPage = new DynamicContentPage(driver);
        }
        return dynamicContentPage;
    }

    public DynamicControlsPage dynamicControlsPage(){
        if(dynamicControlsPage == null){
            dynamicControlsPage = new DynamicControlsPage(driver);
        }
        return dynamicControlsPage;
    }
    public DynamicLoadingPage dynamicLoadingPage(){
        if(dynamicLoadingPage == null){
            dynamicLoadingPage = new DynamicLoadingPage(driver);
        }
        return dynamicLoadingPage;
    }

    public FileDownloadPage fileDownloadPage(){
        if(fileDownloadPage == null){
            fileDownloadPage = new FileDownloadPage(driver);
        }
        return fileDownloadPage;
    }

    public FileUploadPage fileUploadPage(){
        if(fileUploadPage == null){
            fileUploadPage = new FileUploadPage(driver);
        }
        return fileUploadPage;
    }

    public FloatingMenuPage floatingMenuPage(){
        if(floatingMenuPage == null){
            floatingMenuPage = new FloatingMenuPage(driver);
        }
        return floatingMenuPage;
    }

    public IframePage iframePage(){
        if (iframePage == null){
            iframePage = new IframePage(driver);
        }
        return iframePage;
    }

    public MouseHoverPage mouseHoverPage(){
        if (mouseHoverPage == null){
            mouseHoverPage = new MouseHoverPage(driver);
        }
        return mouseHoverPage;
    }

    public JavaScriptErrorPage javaScriptErrorPage(){
        if (javaScriptErrorPage == null){
            javaScriptErrorPage = new JavaScriptErrorPage(driver);
        }
        return javaScriptErrorPage;
    }

    public JavaScriptAlertsPage javaScriptAlertsPage(){
        if (javaScriptAlertsPage == null){
            javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        }
        return javaScriptAlertsPage;
    }

    public OpenInNewTabPage openInNewTabPage(){
        if (openInNewTabPage == null){
            openInNewTabPage = new OpenInNewTabPage(driver);
        }
        return openInNewTabPage;
    }

    public NotificationMessagePage notificationMessagePage(){
        if (notificationMessagePage == null){
            notificationMessagePage = new NotificationMessagePage(driver);
        }
        return notificationMessagePage;
    }
}

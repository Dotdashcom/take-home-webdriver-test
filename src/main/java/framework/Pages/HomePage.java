package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Level;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text() ='Checkboxes']")
    WebElement checkBoxes;

    @FindBy(xpath = "//a[text() ='Context Menu']")
    WebElement contextMenu;

    @FindBy(xpath = "//a[text() ='Drag and Drop']")
    WebElement dragAndDrop;

    @FindBy(xpath = "//a[text() ='Dropdown']")
    WebElement dropDown;

    @FindBy(xpath = "//a[text() ='Dynamic Content']")
    WebElement dynamicContent;

    @FindBy(xpath = "//a[text() ='Dynamic Controls']")
    WebElement dynamicControls;

    @FindBy(xpath = "//a[text() ='Dynamic Loading']")
    WebElement dynamicLoading;

    @FindBy(xpath = "//a[text() ='File Download']")
    WebElement fileDownload;

    @FindBy(xpath = "//a[text() ='File Upload']")
    WebElement fileUpload;

    @FindBy(xpath = "//a[text() ='Floating Menu']")
    WebElement floatingMenu;

    @FindBy(xpath = "//a[text() ='Hovers']")
    WebElement hover;

    //fix
    @FindBy(xpath = "//a[text() ='Frames']")
    WebElement frame;

    @FindBy(xpath = "//a[text() ='JavaScript onload event error']")
    WebElement javaScriptError;

    @FindBy(xpath = "//a[text() ='JavaScript Alerts']")
    WebElement javaScriptAlert;

    @FindBy(xpath = "//a[text() ='Form Authentication']")
    WebElement login;

    @FindBy(xpath = "//a[text() ='Notification Messages']")
    WebElement notificationMessage;

    @FindBy(xpath = "//a[text() ='Multiple Windows']")
    WebElement multipleWindows;

    public void clickCheckboxes(){ checkBoxes.click(); }

    public void clickContextMenu(){ contextMenu.click();}

    public void clickDragAndDrop(){dragAndDrop.click();}

    public void clickDropDown(){dropDown.click();}

    public void clickDynamicContent(){dynamicContent.click(); }

    public void clickDynamicControls(){dynamicControls.click();}

    public void clickDynamicLoading(){dynamicLoading.click();}

    public void clickFileDownload(){ fileDownload.click(); }

    public void clickFileUpload(){fileUpload.click(); }

    public void clickFloatingMenu(){floatingMenu.click();}

    public void clickHover(){ hover.click(); }

    public void clickFrame(){ frame.click();}

    public void clickJavaScriptAlert(){javaScriptAlert.click();}

    public void clickLogin(){login.click();}

    public void clickNotification(){notificationMessage.click();}

    public void clickMultipleWindow(){multipleWindows.click();}

    public void captureJavaScriptErrorLog(String errorMessage){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.filter(Level.SEVERE);
        for (LogEntry logEntry : logs) {
            if (logEntry.getMessage().contains(errorMessage)){
                break;
            } else {
                Assert.fail("Did not find " + errorMessage);
            }

        }

    }

    public void clickJavaScriptError(){javaScriptError.click();}
}

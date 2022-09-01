package Tests;

import Pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.bonigarcia.wdm.online.Downloader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.util.concurrent.TimeUnit;


public class Tests {
    String baseURL="http://localhost:7080";

    @AfterEach
    public void tearDown(){
        Driver.getDriver().quit();
    }

    @Test
    public void loginValid(){
        LoginPage loginPage=new LoginPage();

        Driver.getDriver().get(baseURL+"/login");

        loginPage.username.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.submit.click();
        assertTrue(loginPage.validLoginMessage.isDisplayed());

    }
    @Test
    public void loginInvalid(){
        LoginPage loginPage=new LoginPage();

        Driver.getDriver().get(baseURL+"/login");

        loginPage.username.sendKeys("wrong");
        loginPage.password.sendKeys("wrong");
        loginPage.submit.click();
        assertTrue(loginPage.invalidLoginMessage.isDisplayed());

    }
    @Test
    public void checkBox(){
        CheckBoxPage checkBoxPage=new CheckBoxPage();


        Driver.getDriver().get(baseURL+"/checkboxes");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        checkBoxPage.checkBox.click();
        assertTrue(checkBoxPage.checkBox.isSelected());


    }
    @Test
    public void contextMenu(){
        ContextMenuPage contextMenuPage=new ContextMenuPage();
        Driver.getDriver().get(baseURL+"/context_menu");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Actions actions=new Actions(Driver.getDriver());
        actions.contextClick(contextMenuPage.context);

        Alert alert=Driver.getDriver().switchTo().alert();
        String alertMessage=alert.getText();
        assertEquals("You selected a context menu", alertMessage);
    }
    @Test
    public void dragAndDrop(){
        DragAndDropPage dragAndDropPage=new DragAndDropPage();
        Driver.getDriver().get(baseURL+"/drag_and_drop");
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(dragAndDropPage.WindowA,dragAndDropPage.WindowB);
    }
    @Test
    public void dropdown(){
        DropdownPage dropdownPage=new DropdownPage();

        Driver.getDriver().get(baseURL+"/dropdown");
        Select select=new Select(dropdownPage.select);
        select.selectByValue("1");
    }
    @Test
    public void DynamicContent(){
        Driver.getDriver().get(baseURL+"/dynamic_content");
////////////////////////////////////////////////////////////////

        Driver.getDriver().navigate().refresh();
    }
    @Test
    public void DynamicControl(){
        DynamicControl dynamicControl=new DynamicControl();
        Driver.getDriver().get(baseURL+"/dynamic_controls");
///////////////////////////////////////////////////////////////
        dynamicControl.enableDisableButton.click();
        assertTrue(dynamicControl.enabledMessage.isDisplayed());

    }
    @Test
    public void DynamicLoading(){
    DynamicLoadPage dynamicLoadPage=new DynamicLoadPage();
    Driver.getDriver().get(baseURL+"/dynamic_loading/2");
    dynamicLoadPage.startButton.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadPage.helloMessage));
        assertTrue(dynamicLoadPage.helloMessage.isDisplayed());
    }
    @Test
    public void fileDownload(){
        ////////////////////////////////////////////////////////////
        FileDownloadPage fileDownloadPage=new FileDownloadPage();
        Driver.getDriver().get(baseURL+"/download");
        fileDownloadPage.textDownload.click();
        }

     @Test
     public void fileUpload(){
        ///////////////////////////////////////////////////
        FileUploadPage fileUploadPage=new FileUploadPage();
        Driver.getDriver().get(baseURL+"/upload");
        fileUploadPage.fileUploadButton.sendKeys("");
     }
     @Test
    public void floatingMenu(){

        Driver.getDriver().get("http://localhost:7080/floating_menu");
    }
    @Test
    public void iframeTest(){
        IframePage iframePage=new IframePage();
        Driver.getDriver().get(baseURL+"/iframe");
        Driver.getDriver().switchTo().frame(iframePage.iframe);
        assertTrue(iframePage.iframeMessage.isDisplayed());
    }
    @Test
    public void hoverTest(){
    HoverPage hoverPage=new HoverPage();
    Driver.getDriver().get(baseURL+"/hovers");
    Actions actions=new Actions(Driver.getDriver());
    actions.moveToElement(hoverPage.firstWindow).perform();
    assertTrue(hoverPage.message.isDisplayed());
    }
    @Test
    public void jsAlertsTest(){
    JSAlertPage jsAlertPage=new JSAlertPage();
    Driver.getDriver().get(baseURL+"/javascript_alerts");
    jsAlertPage.JSAlertButton.click();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
    wait.until(ExpectedConditions.alertIsPresent());
    Alert alert=Driver.getDriver().switchTo().alert();
    String text=alert.getText();
        assertEquals("I am a JS Alert", text);
    }

    @Test
    public void JSError(){
    JSError jsError=new JSError();
    Driver.getDriver().get(baseURL+"/javascript_error");
    assertTrue(jsError.errorMessage.isDisplayed());
    }

    @Test
    public void linkOpen(){
        OpenLinkPage openLinkPage=new OpenLinkPage();
        Driver.getDriver().get(baseURL+"/windows");

        openLinkPage.clickHereButton.click();

        for(String winHandle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(winHandle);
            if(Driver.getDriver().getWindowHandle().equals("New Window")){
                break;
            }
        }
        assertEquals("New Window", Driver.getDriver().getTitle());

    }

    @Test
    public void notificationMessage(){
    NotificationPage notificationPage=new NotificationPage();
    Driver.getDriver().get(baseURL+"/notification_message_rendered");

    assertTrue(notificationPage.notificationMessage.isDisplayed());

    }
}

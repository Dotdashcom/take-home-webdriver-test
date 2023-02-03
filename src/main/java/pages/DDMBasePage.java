package pages;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DDMBasePage  {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public DDMBasePage(WebDriver driver)  {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementToBeClickableCSS(String cssSelector)  {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    public void waitForElementToBeVisibleCSS(String cssSelector)  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
    }

    public void waitForInvisibilityOfElement(WebElement element)  {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForVisibilityOfElement(WebElement element)  {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitInMilliSeconds(int milliSeconds)  {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e)  {
            System.out.println("Interrupted exception.");
        }
    }
    public void refreshPage()  {
        driver.navigate().refresh();
    }

    public <T> T getPageObject(Class<T> pageClassToProxy)  {
        String testPageURL = ConfigReader.getProperty("testPageURL");
        String requiredPageName = "";

        if(pageClassToProxy.getName().contains("DDMLoginPage"))  {
            requiredPageName = "login";
        } else if(pageClassToProxy.getName().contains("DDMCheckBoxPage"))  {
            requiredPageName = "checkboxes";
        } else if(pageClassToProxy.getName().contains("DDMContextMenuPage"))  {
            requiredPageName = "context_menu";
        } else if(pageClassToProxy.getName().contains("DDMDragAndDropPage"))  {
            requiredPageName = "drag_and_drop";
        } else if(pageClassToProxy.getName().contains("DDMDropDownPage"))  {
            requiredPageName = "dropdown";
        } else if(pageClassToProxy.getName().contains("DDMDynamicContentPage"))  {
            requiredPageName = "dynamic_content";
        } else if(pageClassToProxy.getName().contains("DDMDynamicControlsPage"))  {
            requiredPageName = "dynamic_controls";
        } else if(pageClassToProxy.getName().contains("DDMDynamicLoadingPage"))  {
            requiredPageName = "dynamic_loading/1";
        } else if(pageClassToProxy.getName().contains("DDMFileDownloadPage"))  {
            requiredPageName = "download";
        } else if(pageClassToProxy.getName().contains("DDMFileUploadPage"))  {
            requiredPageName = "upload";
        } else if(pageClassToProxy.getName().contains("DDMFloatingMenuPage"))  {
            requiredPageName = "floating_menu";
        } else  if(pageClassToProxy.getName().contains("DDMIframePage"))  {
            requiredPageName = "iframe";
        } else  if(pageClassToProxy.getName().contains("DDMMouseHoverPage"))  {
            requiredPageName = "hovers";
        } else if(pageClassToProxy.getName().contains("DDMJavaScriptAlertPage"))  {
            requiredPageName = "javascript_alerts";
        } else if(pageClassToProxy.getName().contains("DDMJavaScriptErrorPage"))  {
            requiredPageName = "javascript_error";
        } else if(pageClassToProxy.getName().contains("DDMNewTabPage"))  {
            requiredPageName = "windows";
        } else if(pageClassToProxy.getName().contains("DDMNotificationMessagePage"))  {
            requiredPageName = "notification_message_rendered";
        }

        String fullPageURL = testPageURL + requiredPageName;
        driver.get(fullPageURL);
        waitInMilliSeconds(500);

        return PageFactory.initElements(driver, pageClassToProxy);
    }
}
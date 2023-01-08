package model.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import runner.BaseModel;
import runner.BaseUtils;

import java.util.List;

public abstract class BasePage extends BaseModel {

    @FindBy(css = "a>img")
    private WebElement forkMeOnGithubImage;

    @FindBy(xpath = "//a[contains(@href, 'github')]")
    private List<WebElement> githubLink;

    @FindBy(css = ".large-centered a")
    private WebElement footerLink;

    @FindBy(css = "#page-footer .large-centered>div")
    private WebElement footerText;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {

        return getDriver().getCurrentUrl();
    }

    public String getCurrentUrlEndPoint() {
        String[] urlPartsList = getDriver().getCurrentUrl().split("/");

        return urlPartsList[urlPartsList.length - 1];
    }

    public String getDefaultDownloadFolder() {
        String platform = ((RemoteWebDriver) getDriver())
                .getCapabilities()
                .getPlatformName()
                .toString().toLowerCase();
        String defaultDownloadLocation;

        switch (platform) {
            case "windows" -> defaultDownloadLocation = System.getProperty("user.home") + "\\Downloads\\";
            case "mac", "linux" -> defaultDownloadLocation = System.getProperty("user.home") + "/Downloads/";
            default -> {
                BaseUtils.log("Unknown system detected. Attempting default location...");
                defaultDownloadLocation = System.getProperty("user.home") + "\\Downloads\\";
            }
        }

        return defaultDownloadLocation;
    }
    public Keys getPlatformSpecificControlKey() {
        String platform = ((RemoteWebDriver) getDriver())
                .getCapabilities()
                .getPlatformName()
                .toString().toLowerCase();
        Keys controlKey = switch (platform) {
            case "windows", "linux" -> Keys.CONTROL;
            case "mac" -> Keys.COMMAND;
            default -> Keys.CONTROL;
        };

        return controlKey;
    }

    public void dragAndDrop(WebElement elementToDrop, WebElement destinationElement) {
        String jsDragAndDrop =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";
        ((JavascriptExecutor)getDriver()).executeScript(jsDragAndDrop, elementToDrop, destinationElement);
    }
}
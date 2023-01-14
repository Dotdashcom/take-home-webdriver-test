package com.anaris.pages;

import com.anaris.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestPage extends BasePage {

    @FindBy(xpath = "//a[text()='Checkboxes']")
    public WebElement linkCheckboxes;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement firstCheckbox;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement secondCheckbox;

    @FindBy(xpath = ("//input[@type='checkbox']"))
    public List<WebElement> checkBoxesList;

    public void checkBoxes() {
        for (WebElement each : checkBoxesList) {
            if (!each.isSelected()) {
                each.click();
            }
        }
    }

    // Context Menu

    @FindBy(xpath = "//a[text()='Context Menu']")
    public WebElement linkContextMenu;

    @FindBy(id = "hot-spot")
    public WebElement rightClickContext;

    // Drag and Drop

    @FindBy(xpath = "//a[text()='Drag and Drop']")
    public WebElement linkDragDrop;

    @FindBy(xpath = "//div[@id='columns']/div[@id='column-a']")
    public WebElement columnA;

    @FindBy(xpath = "//div[@id='columns']/div[@id='column-b']")
    public WebElement columnB;

    // Dropdown

    @FindBy(xpath = "//a[text()='Dropdown']")
    public WebElement linkDropdown;

    @FindBy(id = "dropdown")
    public WebElement selectDropdown;

    public List<String> dropdownVerify(WebElement element) {
        Select select = new Select(element);
        List<String> actualDropdowns = new ArrayList<>();
        List<WebElement> getDropdowns = select.getOptions();
        for (WebElement each : getDropdowns) {
            actualDropdowns.add(each.getText());
        }
        return actualDropdowns;
    }

    // Dynamic Content

    @FindBy(xpath = "//a[text()='Dynamic Content']")
    public WebElement linkDynCont;

    @FindBy(xpath = "//div[@id='content']//div[3]")
    public WebElement lastContent;


    //   Dynamic Controls

    @FindBy(xpath = "//a[text()='Dynamic Controls']")
    public WebElement linkDynControls;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement goneMsg;

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeBtn;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement addBtn;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableBtn;

    @FindBy(xpath = "//button[.='Disable']")
    public WebElement disableBtn;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement textBox;


    // Dynamic Loading

    @FindBy(xpath = "//a[text()='Dynamic Loading']")
    public WebElement linkDynLoading;

    @FindBy(xpath = "//a[.='Example 1: Element on page that is hidden']")
    public WebElement firstExample;

    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startBtn;

    @FindBy(xpath = "//div[@id='finish']")
    public WebElement finishMsg;


    //   File Download

    @FindBy(xpath = "//a[text()='File Download']")
    public WebElement linkFileDownload;

    @FindBy(xpath = "//a[.='some-file.txt']")
    public WebElement downloadFile;

    public String verifyDownloadedFile(String fileName) {
        File fileLocation = new File("C:\\Users\\TRIADA\\Downloads");
        File[] files = fileLocation.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file.getName();
            }
        }
        return null;
    }


    //   File Upload
    @FindBy(xpath = "//a[text()='File Upload']")
    public WebElement linkFileUpload;

    @FindBy(id = "file-submit")
    public WebElement uploadBtn;

    @FindBy(id = "file-upload")
    public WebElement chooseFileBtn;

    @FindBy(tagName = "h3")
    public WebElement verifyMessage;


    //   Floating Menu
    @FindBy(xpath = "//a[text()='Floating Menu']")
    public WebElement linkFloatMenu;

    @FindBy(id = "menu")
    public WebElement menuModules;

    @FindBy(xpath = "//div[@id='page-footer']//a")
    public WebElement scrollToElement;


    //   Frames
    @FindBy(xpath = "//a[text()='Frames']")
    public WebElement linkFrames;

    @FindBy(xpath = "//a[.='iFrame']")
    public WebElement clickIFrame;

    @FindBy(id = "mce_0_ifr")
    public WebElement iframe;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    public WebElement sendText;


    //   Hovers
    @FindBy(xpath = "//a[text()='Hovers']")
    public WebElement linkHover;

    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> images;

    @FindBy (xpath = "(//div[@class='figcaption']/h5)")
    public List<WebElement> hoverText;


    public boolean hoverImages() {
        boolean text = false;
        int i = 1;
        Actions action = new Actions(Driver.getDriver());
        for (WebElement each : images) {
            action.moveToElement(each).perform();
            text = Driver.getDriver().findElement(By.xpath("(//div[@class='figcaption']/h5)[" + i + "]")).isDisplayed();
            i++;
        }
        return text;
    }

    public void hoverTexts() {
        int i = 1;
        String text;
        Actions actions = new Actions(Driver.getDriver());
        for (WebElement each : images) {
            actions.moveToElement(each).build().perform();
            text = Driver.getDriver().findElement(By.xpath("(//div[@class='figcaption']/h5)[" + i + "]")).getText();
            i++;
            System.out.println(text);
        }
    }



    //   JavaScript Alerts
    @FindBy(xpath = "//a[text()='JavaScript Alerts']")
    public WebElement linkJSAlerts;

    @FindBy (xpath = "//button[@onclick='jsAlert()']")
    public WebElement jsAlertBtn;

    @FindBy (xpath = "//p[@id='result']")
    public WebElement jsAlertMsg;

    @FindBy (xpath = "//button[@onclick='jsConfirm()']")
    public WebElement jsConfirmBtn;

    @FindBy (xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsPromptBtn;


    //   JavaScript onload event error
    @FindBy(xpath = "//a[text()='JavaScript onload event error']")
    public WebElement linkJSError;

    @FindBy (xpath = "/html/body/p")
    public WebElement jsErrorMsg;


    //   Multiple Windows
    @FindBy(xpath = "//a[text()='Multiple Windows']")
    public WebElement linkMultiTabs;

    @FindBy (xpath = "//a[.='Click Here']")
    public WebElement clickHereBtn;

    @FindBy(xpath = "//h3[.='New Window']")
    public WebElement newTabMsg;

    public void openNewTab(){

        String windowHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for(String handle : windowHandles){
            Driver.getDriver().switchTo().window(handle);
            if(!handle.equals(windowHandle)){
                break;
            }
        }
    }


    //   Notification Messages
    @FindBy(xpath = "//a[text()='Notification Messages']")
    public WebElement linkNotifyMsg;

    @FindBy (xpath = "//div[@class='flash notice']") // /html/body/div[1]/div/div   ////div[@class='flash notice']
    public WebElement notifyMsg;

    @FindBy (linkText = "Click here")
    public WebElement notifyClickHereBtn;





}
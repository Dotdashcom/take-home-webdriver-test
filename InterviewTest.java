import graphql.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class InterviewTest {
    private static final String BASE_URL = "http://localhost:7080/";
    private static final String LOGIN = "Login";
    private static final String CHECKBOX = "CheckBoxes";
    private static final String CONTEXT_MENU = "Context Menu";
    private static final String DRAG_AND_DROP = "Drag and Drop";
    private static final String DROP_DOWN = "Drop down";
    private static final String DYNAMIC_CONTENT = "Dynamic Content";
    private static final String DYNAMIC_CONTROLS = "Dynamic Controls";
    private static final String DYNAMIC_LOADING = "Dynamic Loading";
    private static final String  FILE_DOWNLOAD = "File Download";
    private static final String FILE_UPLOAD = "File Upload";
    private static final String FLOATING_MENU = "Floating Menu";
    private static final String IFRAME = "Iframe";
    private static final String MOUSE_HOVER = "Mouse Hover";
    private static final String JAVASCRIPT_ALERTS = "JavaScript Alerts";
    private static final String OPEN_IN_NEW_TAB = "Open in New Tab";
    private static final String NOTIFICATION_MESSAGE = "Notification Message";
    private static final String JAVASCRIPT_ERROR = "JavaScript Error";
    private static final String FILE_NAME = "some-file.txt";
    private static final String LOGIN_USERNAME = "tomsmith";
    private static final String LOGIN_PASSWORD = "SuperSecretPassword!";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String DRAG_AND_DROP_JAVASCRIP =
            "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                    "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                    "ction(format,data){this.items[format]=data;this.types.append(for" +
                    "mat);},getData:function(format){return this.items[format];},clea" +
                    "rData:function(format){}};var emit=function(event,target){var ev" +
                    "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                    "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                    "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                    "'drop',tgt);emit('dragend',src);";
    private static final String UPLOAD_AND_DOWNLOAD_FILE_PATH = "/home/hector-dev-enviroment/Downloads/";
    private static final String BUTTON_XPATH_BY_TEXT = "//button[text()=";
    private static final String XPATH_JAVASCRIPT_ALERTS_FIRST__BUTTON = BUTTON_XPATH_BY_TEXT + "\"Click for JS Alert\"]";
    private static final String XPATH_JAVASCRIPT_ALERTS_SECOND_BUTTON = BUTTON_XPATH_BY_TEXT + "\"Click for JS Confirm\"]";
    private static final String XPATH_JAVASCRIPT_ALERTS_THIRD_BUTTON = BUTTON_XPATH_BY_TEXT + "\"Click for JS Prompt\"]";
    private static final int FIVE_SECONDS = 5;
    private Map<String,String> scenariosLinkMap;
    private static WebDriver driver;



    @BeforeClass
    private void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/home/hector-dev-enviroment/Documents/selenium related/chromedriver_linux64/chromedriver");

        driver = new ChromeDriver();
        scenariosLinkMap = new HashMap<>();
        scenariosLinkMap.put(LOGIN,  BASE_URL + "login");
        scenariosLinkMap.put(CHECKBOX, BASE_URL.concat("checkboxes"));
        scenariosLinkMap.put(CONTEXT_MENU, BASE_URL.concat("context_menu"));
        scenariosLinkMap.put(DRAG_AND_DROP, BASE_URL.concat("drag_and_drop"));
        scenariosLinkMap.put(DROP_DOWN, BASE_URL.concat("dropdown"));
        scenariosLinkMap.put(DYNAMIC_CONTENT, BASE_URL.concat("dynamic_content"));
        scenariosLinkMap.put(DYNAMIC_CONTROLS,BASE_URL.concat("dynamic_controls"));
        scenariosLinkMap.put(DYNAMIC_LOADING, BASE_URL.concat("dynamic_loading/2"));
        scenariosLinkMap.put(FILE_DOWNLOAD,BASE_URL.concat("download"));
        scenariosLinkMap.put(FILE_UPLOAD, BASE_URL.concat("upload"));
        scenariosLinkMap.put(FLOATING_MENU,  BASE_URL.concat("floating_menu"));
        scenariosLinkMap.put(IFRAME, BASE_URL.concat("iframe "));
        scenariosLinkMap.put(MOUSE_HOVER, BASE_URL.concat("hovers"));
        scenariosLinkMap.put(JAVASCRIPT_ALERTS, BASE_URL.concat("javascript_alerts"));
        scenariosLinkMap.put(JAVASCRIPT_ERROR, BASE_URL.concat("javascript_error"));
        scenariosLinkMap.put(OPEN_IN_NEW_TAB, BASE_URL.concat("windows "));
        scenariosLinkMap.put(NOTIFICATION_MESSAGE, BASE_URL.concat("notification_message_rendered"));

    }


    @Test
    public void validUserCredentials_loginOnPage_returnTrue () throws InterruptedException {

        driver.get(scenariosLinkMap.get(LOGIN));
        driver.findElement(By.name(USERNAME_KEY)).sendKeys(LOGIN_USERNAME);
        driver.findElement(By.name(PASSWORD_KEY)).sendKeys(LOGIN_PASSWORD);
        driver.findElement(By.className("radius")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        Assert.assertTrue(driver.findElement(By.id("flash")).getText().toString().contains("logged into"));
    }

    @Test
    public void invalidUserCredentials_loginOnPage_succeed () {

        driver.get(scenariosLinkMap.get(LOGIN));
        driver.findElement(By.name(USERNAME_KEY)).sendKeys(LOGIN_USERNAME);
        driver.findElement(By.name(PASSWORD_KEY)).sendKeys("invalidPassword");
        driver.findElement(By.className("radius")).click();

        getExplicitWait(FIVE_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("password is invalid"));
    }

    @Test // may need some improvements to make it a more dynamic test-case
    public void uncheckedAndCheckedBoxes_checkBoth_succeed() {
        driver.get(scenariosLinkMap.get(CHECKBOX));
        List<WebElement> checkBoxes = driver.findElement(By.id("checkboxes")).findElements(By.tagName("input"));
        boolean prestateOfBox1 = checkBoxes.get(0).isSelected();
        boolean prestateOfBox2 = checkBoxes.get(1).isSelected();

        // iterate over checkboxes and click them
        checkBoxes.forEach(WebElement::click);

        Assert.assertFalse(checkBoxes.get(0).isSelected() && prestateOfBox1);
        Assert.assertFalse(checkBoxes.get(1).isSelected() && prestateOfBox2);
    }

    @Test
    public void contextMenu_popUpWindow_AlertShows_succeed() {
        driver.get(scenariosLinkMap.get(CONTEXT_MENU));

        // makes right click
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        getExplicitWait(FIVE_SECONDS).until(ExpectedConditions.alertIsPresent());

        // asserts alert contains the expected message
        Assert.assertTrue(driver.switchTo().alert().getText().contains("You selected a context menu"));

        // alert shows up
        Assert.assertTrue(isAlertPresent(driver));
        driver.switchTo().alert().accept();
        // alert goes away
        Assert.assertFalse(isAlertPresent(driver));
    }

    @Test
    public void dragAndDropSection_dragElements_aAndBAreSwitched_returnTrue() {

        driver.get(scenariosLinkMap.get(DRAG_AND_DROP));
        WebElement columA = driver.findElement(By.id("column-a"));
        WebElement columB = driver.findElement(By.id("column-b"));

        // javascript injection due to chrome driver limitations on drag and drop in the latest version.
        ((JavascriptExecutor)driver).executeScript(DRAG_AND_DROP_JAVASCRIP, columA, columB);

        Assert.assertTrue(driver.findElement(By.id("column-a")).findElement(By.tagName("header")).getText().equals("B"));
        Assert.assertTrue(driver.findElement(By.id("column-b")).findElement(By.tagName("header")).getText().equals("A"));
    }

    @Test
    public void dropDownMenu_selectOptions_optionsAreSelected_returnTrue() {
        driver.get(scenariosLinkMap.get(DROP_DOWN));
        Select drpOption = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownElements = driver.findElement(By.id("dropdown")).findElements(By.tagName("option"));

        dropdownElements.forEach(dropElement -> {
            if(!dropElement.getText().contains("Please select an option")){
                drpOption.selectByVisibleText(dropElement.getText());
                Assert.assertTrue(dropElement.isSelected());
            }
        });
    }

    @Test
    public void dynamicContent_refreshPage_pageChangesContent_succeed() {
        driver.get(scenariosLinkMap.get(DYNAMIC_CONTENT));
        // refresh 4 times
        int times = 4;
        String prevDomVersion = driver.getPageSource();
        for(int i = 0; i < times ; i++){
            driver.navigate().refresh();
            // asserts that page changes the page-source after refresh
            Assert.assertFalse(prevDomVersion.equals(driver.getPageSource()));
            // updates version
            prevDomVersion = driver.getPageSource();
        }
    }

    @Test
    public void dynamicControls_clickOnElements_elementsDynamicallyResponded_succeed(){

        driver.get(scenariosLinkMap.get(DYNAMIC_CONTROLS));

        driver.findElement(By.xpath(BUTTON_XPATH_BY_TEXT + "\"Remove\"]")).click();
        getExplicitWait(FIVE_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        Assert.assertTrue(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox"))).apply(driver));

        getExplicitWait( FIVE_SECONDS).until(ExpectedConditions.elementToBeClickable((By.xpath(BUTTON_XPATH_BY_TEXT + "\"Add\"]"))));

        driver.findElement(By.xpath(BUTTON_XPATH_BY_TEXT + "\"Add\"]")).click();
        getExplicitWait(FIVE_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        Assert.assertTrue(ExpectedConditions.not(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox"))).apply(driver));

        // don't need to wait here since don't affect the checkbox area or vice-versa
        driver.findElement(By.xpath(BUTTON_XPATH_BY_TEXT + "\"Enable\"]")).click();
        getExplicitWait(FIVE_SECONDS).until(ExpectedConditions.elementToBeClickable(By.tagName("input")));
        Assert.assertFalse(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.tagName("input"))).apply(driver));

        getExplicitWait( FIVE_SECONDS).until(ExpectedConditions.elementToBeClickable((By.xpath(BUTTON_XPATH_BY_TEXT + "\"Disable\"]"))));

        // don't need to wait here since don't affect the checkbox area or vice-versa
        driver.findElement(By.xpath(BUTTON_XPATH_BY_TEXT + "\"Disable\"]")).click();
        getExplicitWait( FIVE_SECONDS).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((By.cssSelector("//input[type=\"text\"][disabled]")))));
        Assert.assertTrue(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.cssSelector("//input[type=\"text\"][disabled]"))).apply(driver));
    }

    @Test
    public void dynamicLoading_clickStartButton_ElementRendersAfter_returnTrue(){
        driver.get(scenariosLinkMap.get(DYNAMIC_LOADING));
        driver.findElement(By.xpath(BUTTON_XPATH_BY_TEXT + "\"Start\"]")).click();
        getExplicitWait(FIVE_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        Assert.assertTrue(driver.findElement(By.id("finish")).getText().contains("Hello World!"));
    }



    @Test
    public void downloadLinkExist_fileDownloaded_returnTrue() {
        driver.get(scenariosLinkMap.get(FILE_DOWNLOAD));
        driver.findElement(By.linkText(FILE_NAME)).click();

        // Assert file downloaded
        File f = new File(UPLOAD_AND_DOWNLOAD_FILE_PATH + FILE_NAME);
        getExplicitWait(FIVE_SECONDS).until(filePresent(UPLOAD_AND_DOWNLOAD_FILE_PATH + FILE_NAME));
        Assert.assertTrue(f.exists() && !f.isDirectory());
    }

    @Test
    public void fileUpload_uploadButton_fileIsUploaded_succeed(){
        driver.get(scenariosLinkMap.get(FILE_UPLOAD));
        WebElement uploadButton = driver.findElement(By.id("file-upload"));
        uploadButton.sendKeys(UPLOAD_AND_DOWNLOAD_FILE_PATH + FILE_NAME);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        getExplicitWait(FIVE_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        // expect the opposite condition
        Assert.assertFalse(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files"))).apply(driver));
    }

    @Test
    public void iframe_typeInIframe_textIsAsExpected_returnTrue(){
        driver.get(scenariosLinkMap.get(IFRAME));
        driver.switchTo().frame("mce_0_ifr");
        WebElement actElement = driver.switchTo().activeElement();
        actElement.sendKeys("Hello Iframe!");
        Assert.assertTrue(driver.findElement(By.id("tinymce")).getText().contains("Hello Iframe!"));
    }

    @Test
    public void  mouseHover_moveMoseOverEachPicture_additionalInfoDisplayedOnEach_succeed(){
        driver.get(scenariosLinkMap.get(MOUSE_HOVER));

        //object action
        Actions action = new Actions(driver);

        // use of streams for scalability
        driver.findElements(By.className("figure")).stream().forEach( e -> {
            action.moveToElement(e).perform();
            Assert.assertTrue(e.findElement(By.className("figcaption")).getCssValue("display").equals("block"));
        });

    }

    @Test
    public void javascriptAlerts_triggerAlert_alertMessageAsExpected_succeed(){

        driver.get(scenariosLinkMap.get(JAVASCRIPT_ALERTS));

        driver.findElements(By.tagName("button")).stream()
                        .forEach( button -> {

                            if (driver.findElement(By.xpath(XPATH_JAVASCRIPT_ALERTS_FIRST__BUTTON)).equals(button)){
                                button.click();
                                Assert.assertTrue(driver.switchTo().alert().getText().contains("I am a JS Alert"));
                                driver.switchTo().alert().accept();
                            }
                            if(driver.findElement(By.xpath(XPATH_JAVASCRIPT_ALERTS_SECOND_BUTTON)).equals(button)){
                                button.click();
                                Assert.assertTrue(driver.switchTo().alert().getText().contains("I am a JS Confirm"));
                                driver.switchTo().alert().accept();
                            }
                            if(driver.findElement(By.xpath(XPATH_JAVASCRIPT_ALERTS_THIRD_BUTTON)).equals(button)){
                                button.click();
                                driver.switchTo().alert().sendKeys("It's fun");
                                driver.switchTo().alert().accept();
                                Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("It's fun"));
                            }
                        });

    }

    @Test
    public void javascriptError_findError_succeed(){
        driver.get(scenariosLinkMap.get(JAVASCRIPT_ERROR));

        // needed to iterate and filter to other errors on my browser.
        List<LogEntry> logEntries = driver.manage().logs().get(LogType.BROWSER).getAll().stream().
                filter(logEntry -> logEntry.getMessage().contains("undefined") || logEntry.getMessage().contains("error")).toList();

        Assert.assertTrue(logEntries.get(0).getMessage().contains("Cannot read properties of undefined (reading 'xyz')"));
    }

    @Test
    public void newTabLink_click_newTabOpen_succeed(){
        driver.get(scenariosLinkMap.get(OPEN_IN_NEW_TAB));
        driver.findElement(By.linkText("Click Here")).click();

        //switch to new tab
        List<String> newTb = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));

        Assert.assertTrue(driver.getCurrentUrl().contains(BASE_URL + "windows/new"));
    }

    @Test
    public void notificationMessage_clickOnLink_generatesDifferentNotifications_succeeded() {
        driver.get(scenariosLinkMap.get(NOTIFICATION_MESSAGE));
        driver.findElement(By.linkText("Click here")).click();
        Map<String,Integer> expectedNotifications = new HashMap<>();

        /* uncomment below line of code if you want to include such scenario. Added because of the rubric directions.
         such notification message does not exist in current render version such it will fail*/
        // expectedNotifications.put("Action unsuccesful",0);

        // leave typo. It exists in alert message.
        expectedNotifications.put("Action unsuccesful, please try again",0);
        expectedNotifications.put("Action successful", 0);

        int numberOfClicks = 10;
        // clicking number at least double the amount of alerts to be displayed
        while(numberOfClicks > 0){
            expectedNotifications.keySet().stream().forEach( notificationKey -> {
                        String notificationMessage = driver.findElement(By.id("flash-messages")).getText();
                        if (notificationMessage.contains(notificationKey)) {
                            expectedNotifications.put(notificationKey, 1);
                        }
            });
            getExplicitWait( FIVE_SECONDS).until(ExpectedConditions.elementToBeClickable((By.linkText("Click here"))));
            driver.findElement(By.linkText("Click here")).click();
            numberOfClicks-=1;
        };

        // asserts all notifications appear at least once.
        Assert.assertTrue(expectedNotifications.values().stream().allMatch(numberOfDisplays -> numberOfDisplays > 0));

    }


    private static Boolean isAlertPresent(WebDriver driver){
        Boolean result;
        try{
            driver.switchTo().alert();
            result = true;
        }catch (NoAlertPresentException e){
            result = false;
        }

        return result;
    }


    // adopting explicit wait over others to avoid race conditions.
    private static WebDriverWait getExplicitWait(int second){
        Duration duration = Duration.ofSeconds(second);
        return new WebDriverWait(driver,duration);
    }

    private ExpectedCondition<Boolean> filePresent(String filepath) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                File f = new File(filepath);
                return f.exists();
            }
            @Override
            public String toString() {
                return String.format("file to be present within the time specified");
            }
        };
    }

    @AfterClass
    private void teardown() {
        driver.close();
        driver.quit();
    }


}
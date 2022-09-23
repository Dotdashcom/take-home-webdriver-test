package core;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

abstract public class AbstractWebPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractWebPage.class);
    public static String osName = System.getProperty("os.name").toLowerCase();
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected WebDriverWait wdWait;
    protected Actions mkbActions;
    protected Robot robot;
    protected String pathSeparator;
    protected int genericControlKey;
    protected int genericEscapeKey;

    @FindBy(css = "#content > div > h3")
    protected WebElement pageHeaderTitleH3Elm;

    public AbstractWebPage(WebDriver driver){
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        mkbActions = new Actions(driver);
        robot = instantiateRobot();

        if(osName.contains("windows")) {
            pathSeparator = "\\";
            genericControlKey = KeyEvent.VK_CONTROL;
            genericEscapeKey = KeyEvent.VK_ESCAPE;
        } else if(osName.contains("mac")) {
            pathSeparator = "/";
            genericControlKey = KeyEvent.VK_META;
            genericEscapeKey = KeyEvent.VK_5;
        }
    }

    public String getPageHeaderTitle() {
        return pageHeaderTitleH3Elm.getText();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public void waitForElementToBeClickable(String cssSelector) {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    public boolean isElementPresent(String cssSelector){
        try {
            driver.findElement(By.cssSelector(cssSelector));
        } catch(NoSuchElementException exception){
            LOGGER.info("Element not found for given css selector: [{}]" , cssSelector);
            return false;
        }
        return true;
    }

    public boolean isElementDisabled(String cssSelector){
        WebElement elm = driver.findElement(By.cssSelector(cssSelector));
        if(elm.getAttribute("disabled") == null) {
            LOGGER.info("Element is NOT disabled for given css selector: [{}]" , cssSelector);
            return false;
        } else if (elm.getAttribute("disabled").equals("true")) {
            return true;
        }
        return false;
    }

    public void copyPasteRobot(String path) {
        // Copy the ABS path of the file into clipboard
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        sleepInSeconds(2);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(genericControlKey);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(genericControlKey);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        sleepInSeconds(1);
    }

    public void pressEscRobot() {
        if(robot == null) {
            LOGGER.error("Robot is NOT initialized.");
            return;
        }
        sleepInSeconds(1);

        robot.keyPress(genericEscapeKey);
        robot.keyRelease(genericEscapeKey);

    }

    private Robot instantiateRobot() {
        if(robot != null) {
            return robot;
        }

        try {
            robot = new Robot();
        } catch (AWTException ex) {
            robot = null;
            LOGGER.error(ex.getMessage(), ex);
        }
        return robot;
    }

    public void navigateTo(String pageName){
        String baseURL = ConfigReader.getAutProperty("baseURL");
        String requiredPageURL = baseURL + "/" + pageName;
        LOGGER.debug("Navigating to url: [{}]" , requiredPageURL);

        driver.get(requiredPageURL);
    }

    public void overrideInput(WebElement elm, String data) {
        elm.clear();
        elm.sendKeys(data);
    }

    public void scrollVerticleByOneScreen() {
        sleepInSeconds(1);
        jse.executeScript("window.scrollBy(50, 1000);");
    }

    public boolean isVisibleInViewport(WebElement element) {
        return (Boolean)(jse.executeScript(
                "var elem = arguments[0],           " +
                "  box = elem.getBoundingClientRect(),    " +
                "  cx = box.left + box.width / 2,         " +
                "  cy = box.top + box.height / 2,         " +
                "  e = document.elementFromPoint(cx, cy); " +
                "for (; e; e = e.parentElement) {         " +
                "  if (e === elem)                        " +
                "    return true;                         " +
                "}                                        " +
                "return false;                            "
                , element));
    }

    public void sleepInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    public void dragAndDropJS(WebElement source, WebElement destination) {
        jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);
        sleepInSeconds(2);
    }

    public void clickOnElementJS(String cssSelector) {
        String script = "document.querySelectorAll(\"" + cssSelector + "\")[0].click();";
        LOGGER.info("JS Script is : " + script);
        jse.executeScript(script);
    }

    public void clickOnElementMKB(String cssSelector) {
        LOGGER.info("Clicking through Actions class.");
        WebElement targetElement = driver.findElement(By.cssSelector(cssSelector));
        mkbActions.moveToElement(targetElement).click().build().perform();
    }
}

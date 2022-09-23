package core;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

abstract public class AbstractWebPage {
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected WebDriverWait wdWait;
    protected Actions mkbActions;
    protected Robot robot;

    public AbstractWebPage(WebDriver driver){
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        mkbActions = new Actions(driver);
        robot = instantiateRobot();
    }

    public void waitForElementToBeClickable(String cssSelector) {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    public boolean isElementPresent(String cssSelector){
        try {
            driver.findElement(By.cssSelector(cssSelector));
        } catch(NoSuchElementException exception){
            return false;
        }
        return true;
    }

    public boolean isElementDisabled(String cssSelector){
        WebElement elm = driver.findElement(By.cssSelector(cssSelector));
        if(elm.getAttribute("disabled") == null) {
            return false;
        } else if (elm.getAttribute("disabled").equals("true")) {
            return true;
        }
        return false;
    }

    public void copyPasteRobot(String path) {
        // Copy path to system clipboard
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        sleepInSeconds(1);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        sleepInSeconds(1);
    }

    public void pressEscRobot() {
        if(robot == null) {
            return;
        }
        sleepInSeconds(2);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    private Robot instantiateRobot() {
        if(robot != null) {
            return robot;
        }

        try {
            robot = new Robot();
        } catch (AWTException e) {
            robot = null;
            System.out.println("Robot instantiation failed. " + e.getMessage());
        }
        return robot;
    }

    public void navigateTo(String pageName){
        String baseURL = ConfigReader.getAutProperty("baseURL");
        String expectedPageURL = baseURL + "/" + pageName;

        driver.get(expectedPageURL);
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
            System.out.println("Thread.sleep got interrupted.");
        }
    }

    public void dragAndDropJS(WebElement source, WebElement destination) {
        jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);", source,destination);
        sleepInSeconds(2);
    }

    public void clickOnElementJS(String cssSelector) {
        String script = "document.querySelectorAll('" + cssSelector + "')[0].click()";
        jse.executeScript(script);
    }

}

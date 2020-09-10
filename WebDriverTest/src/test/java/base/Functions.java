package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.List;
import java.util.Set;

public class Functions extends PageInit {

    //-------------------------------------------Waits--------------------------------------------

    /**
     * Group of methods for synchronization
     */


    public static WebDriverWait getWaitObj() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static WebElement waitForClick(WebElement element) {
        return getWaitObj().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element) {
        return getWaitObj().until(ExpectedConditions.visibilityOf(element));
    }

    public static List<WebElement> waitForVisibility(List<WebElement> elements) {
        return getWaitObj().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------Click and Send Text-------------------------------------------------

    /**
     * Method sends text to the text box
     *
     * @param element
     * @param text
     */
    public static void enterText(WebElement element, String text) {
        waitForClick(element).clear();
        element.sendKeys(text);
    }

    /**
     * Method clicks on web element
     *
     * @param element
     */
    public static void click(WebElement element) {
        waitForClick(element).click();
    }

    /**
     * Method clicks on web element using JavascriptExecutor interface
     *
     * @param element
     */
    public static void jsClick(WebElement element) {

        getJSEObj().executeScript("arguments[0].click();", waitForClick(element));
    }


    //------------------------------------------JavascriptExecutor---------------------------------------------

    /**
     * Method converts WebDriver instance to the JavascriptExecutor type
     *
     * @return
     */
    public static JavascriptExecutor getJSEObj() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * Method scrolls the page down based on passed pixels
     *
     * @param pixel
     */
    public static void scrollDown(int pixel) {
        getJSEObj().executeScript("window.scrollBy(0," + pixel + ")");
    }

    //-----------------------------------------Actions--------------------------------------------------------

    /**
     * Methods returns Actions class instance
     *
     * @return
     */
    public static Actions getActionsClassInstance() {

        Actions actions = new Actions(driver);
        return actions;
    }


    /**
     * Method simulates mouse hover functionality
     *
     * @param element
     */
    public static void hoverMouse(WebElement element) {
        getActionsClassInstance().moveToElement(waitForVisibility(element)).perform();
    }


    /**
     * Method for context/right mouse click
     *
     * @param element
     */
    public static void contextClick(WebElement element) {

        getActionsClassInstance().moveToElement(waitForClick(element)).contextClick().build().perform();
    }

    /**
     * Method performs drags element and drop into specific place
     *
     * @param drag source element
     * @param drop target place/element
     */
    public static void drugAndDrop(WebElement drag, WebElement drop) {

//        Actions actions = new Actions(driver);
//        actions.dragAndDrop(drag, drop).build().perform();
//        getActionsClassInstance().clickAndHold(source).moveToElement(target).release(source).build().perform();
//        getActionsClassInstance().clickAndHold(source).moveToElement(target).build().perform();
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", target);
//
//        getActionsClassInstance().moveToElement(target).release().perform();

//        Actions builder = new Actions(driver);
//        Action dragAndDrop = builder.clickAndHold(drag)
//                .moveToElement(drop)
//                .release(drop)
//                .build();
//        dragAndDrop.perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", drag, drop);
    }

    public static void click(int x1, int y1, int x2, int y2) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.mouseMove(x1, y1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        wait(2);
        robot.mouseMove(x2, y2);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


    }


    //-----------------------------------------Alerts----------------------------------------------------------


    /**
     * Method return instance of Alert type
     *
     * @return
     */
    public static Alert getAlertInstance() {
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    /**
     * Method retrieves prompt alert message
     *
     * @return
     */
    public static String getAlertMessage() {

        return getAlertInstance().getText();
    }

    /**
     * Method accepts simple and confirmation alerts
     */
    public static void acceptAlert() {

        getAlertInstance().accept();
    }


    //-----------------------------------------Dropdown---------------------------------------------------------

    /**
     * Method select dropdown option by visible text
     *
     * @param element
     * @param text
     */
    public static void selectDDOption(WebElement element, String text) {
        try {
            Select select = new Select(element);
            List<WebElement> list = select.getOptions();
            for (WebElement el : list) {
                String opt = el.getText().trim();
                String optToSelect = text.trim();

                if (el.isEnabled() && opt.equalsIgnoreCase(optToSelect)) {
                    select.selectByVisibleText(optToSelect);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method retrieves selected dropdown option and return as String
     *
     * @param element
     * @return
     */
    public static String getSelectedDDOption(WebElement element) {
        String option = null;
        try {
            Select select = new Select(element);

            List<WebElement> list = select.getOptions();
            for (WebElement el : list) {
                if (el.isSelected()) {
                    option = el.getText().trim();
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
        return option;
    }


    //-------------------------------------------------Download---------------------------------------------------

    /**
     * Method verifies file successfully downloaded
     *
     * @param downloadPath
     * @param fileName
     * @return
     */
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                flag = true;
        }

        return flag;
    }

    //----------------------------------------------Frames--------------------------------------------------------

    /**
     * Method switches to frame by WebElement
     */
    public static void switchToFrame(WebElement element) {
        waitForVisibility(element);
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------------Windows-----------------------------------------------------

    /**
     * Method retrieves alphanumeric id of current window
     *
     * @return
     */
    public static String getParentHandle() {
        return driver.getWindowHandle();

    }


    /**
     * Method switches focus to the child window
     *
     * @param parentHandle
     */
    public static void switchToChildWindow(String parentHandle) {

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
            }
        }


    }
}

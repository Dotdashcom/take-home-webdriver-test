package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import java.awt.event.InputEvent;

public class WaitUtilities {

    private final static int TIMEOUT = 10;

    public static By getByFromWebElement(WebElement element) {
        By by = null;
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");

        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
            case "tag name":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
            case "css selector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }

    public static WebElement explicitWaitByWebElementvisibilityOfElementLocated(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(WaitUtilities.getByFromWebElement(element)));
    }
    
    public static WebElement explicitWaitByWebElementvisibilityOfElementLocated(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    public static WebElement explicitWaitByElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(WaitUtilities.getByFromWebElement(element)));
    }
    
    public static WebElement explicitWaitByElementToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean explicitWaitByElementNotToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        return wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(WaitUtilities.getByFromWebElement(element))));
    }

    public static boolean explicitWaitByElementNotToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        return wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
    }
    
    public static void explicitWaitForAlert(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public static void clickByJavascript(WebDriver driver, WebElement element) {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
    	executor.executeScript("arguments[0].click()", element);
    }

    public static void dragAndDropElementByRobot(WebElement dragFrom, WebElement dragTo)  {
        // Setup robot
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(200);
        // Get size of elements
        Dimension fromSize = dragFrom.getSize();
        Dimension toSize = dragTo.getSize();
        Point fromLocation = dragFrom.getLocation();
        Point toLocation = dragTo.getLocation();
        System.out.println(fromSize.width + "  " + fromSize.height);
        System.out.println(toSize.width + "  " + toSize.height);
        System.out.println(fromLocation);
        System.out.println(toLocation);
        fromLocation.x += fromSize.width/2;
        fromLocation.y += fromSize.height/2+150;
        toLocation.x += toSize.width/2;
        toLocation.y += toSize.height/2+150;
        System.out.println(fromLocation);
        System.out.println(toLocation);

        //Move mouse to drag from location
        robot.mouseMove(fromLocation.x, fromLocation.y);
        //Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);

        //Drag events require more than one movement to register
        //Just appearing at destination doesn't work so move halfway first
        robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x , ((toLocation.y - fromLocation.y) / 2) + fromLocation.y);

        //Move to final position
        robot.mouseMove(toLocation.x, toLocation.y);
        //delay a bit to mouse move correct in Linux
        robot.delay(1000);
        //Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

    }

    public static void dragAndDropElementByAction(WebDriver driver, WebElement dragFrom, WebElement dragTo) {
        Actions action = new Actions(driver);
        action.clickAndHold(dragFrom).moveToElement(dragTo).release().perform();
    }


    public static boolean explicitWaitByElementToBeDisappear(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }



}


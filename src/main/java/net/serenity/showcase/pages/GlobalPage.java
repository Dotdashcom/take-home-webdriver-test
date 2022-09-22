package net.serenity.showcase.pages;

import net.serenity.showcase.utils.Constants.WaitingTime;
import net.serenity.showcase.utils.Util;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webelements.Checkbox;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static net.serenity.showcase.utils.Util.pause;

public class GlobalPage extends PageObject {

    private static Logger logger = Logger.getLogger(GlobalPage.class);
    private WebDriver webDriver;
    private Properties propertyFile;

    /**
     * Default Constructor.
     */
    public GlobalPage(final WebDriver driver) {
        super(driver);
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        webDriver = driver;
    }

    /**
     * Constructor with different parameters
     */
    public GlobalPage(final WebDriver driver, final Properties properties) {
        this(driver);
        this.propertyFile = properties;
    }

    /**
     * Custom function to click on elementName
     *
     * @param elementName
     */
    public void clickOn(String elementName) {
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);
        $(elementProperty).waitUntilClickable().click();
    }

    public void clickOn(String elementName, String textValue) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = (String.format(propertyFile.getProperty(elementName), textValue));
        $(elementProperty).waitUntilClickable().click();
    }

    public void clickByJS(String elementName, String textValue) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = (String.format(propertyFile.getProperty(elementName), textValue));
        WebElement element = webDriver.findElement(By.xpath(elementProperty));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
    }

    public void typeIn(String elementName, String keyword) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);
        $(elementProperty).waitUntilEnabled().type(keyword);
    }

    public void selectFromDropdown(String elementName, String keyword) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);
        $(elementProperty).selectByValue(keyword);
    }

    public void changeCheckboxStatus(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);
        Checkbox checkbox = new Checkbox($(elementProperty));
        if ($(elementProperty).isSelected())
            checkbox.setChecked(false);
        else
            checkbox.setChecked(true);
    }

    public void contextClick(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);

        Actions builder = new Actions(webDriver);
        Action action = builder.contextClick($(elementProperty)).build();
        action.perform();
    }

    public void mouseHover(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);

        Actions builder = new Actions(webDriver);
        Action action = builder.moveToElement($(elementProperty)).build();
        action.perform();
    }

    public String getAlertText() {
        logger.info(Util.getMethodName(0) + " Instantiated");

        return webDriver.switchTo().alert().getText();
    }

    public void typeInAlert(final String textValue) {
        logger.info(Util.getMethodName(0) + " Instantiated");

        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys(textValue);
        alert.accept();
    }

    public String getJavascriptError(){
        logger.info(Util.getMethodName(0) + " Instantiated");

        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> lg = logEntries.getAll();
        String[] errorMessage = lg.get(0).getMessage().split("TypeError:");
        return errorMessage[0].trim();
    }

    public Boolean findFileInTargetFolder(final String fileName){
        File dir = new File(System.getProperty("user.dir") + "\\target");

        File[] matches = dir.listFiles(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                return name.startsWith(fileName) && name.endsWith(".txt");
            }
        });
        return matches.length > 0;
    }

    public void switchToTab(Integer tabNumber) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        List<String> browserTabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(browserTabs.get(tabNumber));
    }

    public void pressEnter() {
        logger.info(Util.getMethodName(0) + " Instantiated");
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public String getTextOf(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);
        // return $(elementProperty).waitUntilVisible().getText();
        return $(elementProperty).getText();
    }

    public PageObject waitForElementOnPage(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);
        return waitForPresenceOf(elementProperty);
    }

    public void waitForElementToDisappear(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        String elementProperty = propertyFile.getProperty(elementName);
        waitForRenderedElementsToDisappear(By.xpath(elementProperty));
    }

    public void performDragAndDrop() throws IOException {
        logger.info(Util.getMethodName(0) + " Instantiated");

/*      Standard drag and drop is not working, hence using js executor

        String elementSourceProperty = propertyFile.getProperty(source);
        String elementDestinationProperty = propertyFile.getProperty(destination);

        Actions builder = new Actions(webDriver);
        Action action = builder.clickAndHold($(elementDestinationProperty))
                .pause(100)
                //.moveToElement($(elementDestinationProperty))
                //.moveByOffset(100,0)
                .moveToElement($(elementSourceProperty))
                .pause(100)
                .release().build();
        action.perform();*/

        String filePath = System.getProperty("user.dir") + "\\drag_and_drop_helper.js";
        StringBuffer buffer = new StringBuffer();

        String line;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while((line = br.readLine())!=null)
            buffer.append(line);

        String javaScript = buffer.toString();
        javaScript = javaScript + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});";
        ((JavascriptExecutor)webDriver).executeScript(javaScript);
    }

    public void uploadFile(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");

        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testImages\\sample.jpg";
        String elementProperty = propertyFile.getProperty(elementName);
        WebElement input = webDriver.findElement(By.xpath(elementProperty));
        input.sendKeys(filePath);
    }

    public void switchToIframe(String elementName) {
        logger.info(Util.getMethodName(0) + " Instantiated");
        webDriver.switchTo().frame(elementName);
    }

    public void refreshThePage() {
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        getDriver().navigate().refresh();
    }

    public void scrollToBottom() {
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToMid() {
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 750)");
    }

    public void scrollIntoView(String elementName, String textValue) {
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        String elementProperty = (String.format(propertyFile.getProperty(elementName), textValue));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", $(elementProperty));
    }

}


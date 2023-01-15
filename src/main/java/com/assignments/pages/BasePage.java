package com.assignments.pages;

import com.assignments.enums.WaitStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

import static com.assignments.constants.MessageConstants.*;
import static com.assignments.driver.DriverManager.getDriver;
import static com.assignments.factory.LoggerFactory.info;
import static com.assignments.factory.WaitFactory.explicitWaitElement;
import static com.assignments.reports.ExtentReportLogger.pass;
import static java.lang.String.format;

public class BasePage {

  protected BasePage() {
  }

  protected void select(By by, WaitStrategy waitStrategy, String visibleText) {
    new Select(scrollIntoElement(by, waitStrategy)).selectByVisibleText(visibleText);
    String message = visibleText + " is selected from dropdown";
    pass(message);
    info(message);
  }

  protected String getFirstSelected(By by, WaitStrategy waitStrategy) {
    String selectedOption = new Select(scrollIntoElement(by, waitStrategy)).getFirstSelectedOption().getText();
    String message = selectedOption + " is the first selected";
    pass(message);
    info(message);
    return selectedOption;
  }

  public WebElement scrollIntoElement(By by, WaitStrategy waitStrategy) {
    WebElement element = explicitWaitElement(by, waitStrategy);
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    return element;
  }


  protected void click(By by, WaitStrategy waitStrategy, String elementName) {
    scrollIntoElement(by, waitStrategy).click();
    String message = format(CLICKED_MESSAGE, elementName);
    info(message);
  }

  protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
    scrollIntoElement(by, waitStrategy).sendKeys(value);
    String message = format(VALUE_ENTERED_MESSAGE, value, elementName);
    pass(message);
    info(message);
  }

  protected String getText(By by, WaitStrategy waitStrategy, String elementName) {
    String text= scrollIntoElement(by, waitStrategy).getText();
    String message = format(TEXT_RETRIEVED_MESSAGE, elementName);
    info(message);
    return text;
  }

  protected boolean isDisplayed(By by, WaitStrategy waitStrategy, String elementName) {
    boolean result = false;

    try {
      result = scrollIntoElement(by, waitStrategy).isDisplayed();
    } catch (Exception e) {
      e.printStackTrace();
    }

    String message = format(DISPLAYED_MESSAGE, elementName);
    if (result) {
      pass(message);
      info(message);
    } else {
      info(format(NOT_DISPLAYED_MESSAGE, elementName));
    }
    return result;
  }

  public boolean isSelected(By by, WaitStrategy waitStrategy, String elementName) {
    return scrollIntoElement(by, waitStrategy).isSelected();
  }

  public void contextClick(By by, WaitStrategy waitStrategy, String elementName) {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(scrollIntoElement(by, waitStrategy)).contextClick().perform();
  }

  public String getAlertMessageAndClickOk() {
    Alert alert = getDriver().switchTo().alert();
    String alertMessage = alert.getText();
    alert.accept();
    return alertMessage;
  }

  public String getSourceCode() {
    return getDriver().getPageSource();
  }

  public boolean isEnabled(By by, WaitStrategy waitStrategy, String elementName) {
    return scrollIntoElement(by, waitStrategy).isEnabled();
  }

  public void scrollToEndOfPage() {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public void javaScriptDragAndDrop(String script, WebElement source, WebElement target) {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript(script, source, target);
  }

  public void switchToFrame(String frameName) {
    getDriver().switchTo().frame(frameName);
  }

  public void mouseHover(By by, WaitStrategy waitStrategy) {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(scrollIntoElement(by, waitStrategy)).release().perform();
  }

  public Alert switchToAlert() {
    return getDriver().switchTo().alert();
  }

  public String getJSLog() {
    StringBuilder message = new StringBuilder();
    LogEntries log = getDriver().manage().logs().get(LogType.BROWSER);
    for (LogEntry entry : log) {
      message.append(entry.getMessage());
    }
    return message.toString();
  }

  public String switchToWindowAndGetTitle() {
    ArrayList<String> tab = new ArrayList<>(getDriver().getWindowHandles());
    getDriver().switchTo().window(tab.get(1));
    return getDriver().getTitle();
  }
}

package com.assignments.factory;

import com.assignments.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.assignments.constants.FrameworkConstants.getExplicitWait;
import static com.assignments.driver.DriverManager.getDriver;
import static com.assignments.factory.LoggerFactory.info;
import static java.time.Duration.ofSeconds;
import static java.util.Objects.requireNonNull;

/**
 * This class produces different waits before operating on {@link org.openqa.selenium.WebElement}
 * instance.
 */
public final class WaitFactory {

  /**
   * Private constructor to avoid external instantiation.
   */
  private WaitFactory() {
  }

  /**
   * @param by           {@link org.openqa.selenium.By} instance, locator of the webelement
   * @param waitStrategy Strategy to be applied to find a webelement {@link WaitStrategy}
   * @return Locates and return {@link org.openqa.selenium.WebElement} instance
   */
  public static WebElement explicitWaitElement(By by, WaitStrategy waitStrategy) {
    WebElement element;
    if (waitStrategy == WaitStrategy.CLICKABLE) {
      element = new WebDriverWait(getDriver(), ofSeconds(getExplicitWait()))
          .until(ExpectedConditions.elementToBeClickable(by));
    } else if (waitStrategy == WaitStrategy.VISIBLE) {
      element = new WebDriverWait(getDriver(), ofSeconds(getExplicitWait()))
          .until(ExpectedConditions.visibilityOfElementLocated(by));
    } else if (waitStrategy == WaitStrategy.PRESENCE) {
      element = new WebDriverWait(getDriver(), ofSeconds(getExplicitWait()))
          .until(ExpectedConditions.presenceOfElementLocated(by));
    } else {
      element = getDriver().findElement(by);
    }

    return element;
  }

  /**
   * @param by           {@link org.openqa.selenium.By} instance, locator of the webelement
   * @param waitStrategy Strategy to be applied to find a webelement {@link WaitStrategy}
   * @return Locates and returns {@link List<WebElement>} instance
   */
  public static List<WebElement> explicitWaitListOfElement(By by, WaitStrategy waitStrategy) {
    List<WebElement> element;
    if (waitStrategy == WaitStrategy.VISIBLE) {
      element = new WebDriverWait(getDriver(), ofSeconds(getExplicitWait()))
          .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    } else if (waitStrategy == WaitStrategy.PRESENCE) {
      element = new WebDriverWait(getDriver(), ofSeconds(getExplicitWait()))
          .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    } else {
      element = getDriver().findElements(by);
    }
    return element;
  }
}

package com.assignments.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver}
 * instance.
 */
public final class DriverManager {

  /**
   * Private constructor to avoid external instantiation
   */
  private DriverManager() {

  }

  private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  /**
   * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal
   * variable.
   *
   * @return WebDriver instance.
   */
  public static WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  /**
   * Set the {@link org.openqa.selenium.WebDriver} instance to thread local variable.
   *
   * @param webDriverRef WebDriver instance that needs to saved from Thread safety issues.
   */
  public static void setDriver(WebDriver webDriverRef) {
    driverThreadLocal.set(webDriverRef);
  }
  
  public static void removeDriver(){
  driverThreadLocal.remove();
  }

}

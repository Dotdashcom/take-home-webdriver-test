package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.assignments.driver.Driver.initializeDriver;
import static com.assignments.driver.Driver.quitDriver;
import static com.assignments.enums.ConfigProperties.BROWSER;
import static com.assignments.utils.PropertyUtils.getValue;

public class BaseTest {

  protected BaseTest() {
  }

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    initializeDriver(getValue(BROWSER));
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    quitDriver();
  }

}

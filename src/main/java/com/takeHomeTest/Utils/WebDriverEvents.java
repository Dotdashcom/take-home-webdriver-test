package com.takeHomeTest.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.takeHomeTest.base.TestBase;

public class WebDriverEvents extends TestBase implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		logger.info("about to accept alert on " + driver.getCurrentUrl());

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		logger.info("Accepted Alert on " + driver.getCurrentUrl());

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Navigating to URL " + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("Navigated to URL " + driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		logger.info("refreshing.... " + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		logger.info("refreshed.... " + driver.getCurrentUrl());

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Finding Webelement " + element);

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info(" Webelement found " + element);

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicking Webelement " + element);

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicked Webelement " + element);

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		logger.info("Switching to Window " + windowName);

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		logger.info("Switched to Window " + windowName);

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		logger.info("Exception Encountered " + throwable.getMessage());

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		logger.info("Getting text from " + element);

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		logger.info("Got text from " + element + " : " + text);

	}

}

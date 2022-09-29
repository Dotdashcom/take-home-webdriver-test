package com.internet.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;



public abstract class GeneralPage extends LoadableComponent<GeneralPage> {

	private static final int DEFAULT_TIME_TO_WAIT_FOR_PAGE = 50;
	protected WebDriver driver;

	public GeneralPage(WebDriver wd, boolean waitForPageToLoad) {

		this.driver = wd;
		if (waitForPageToLoad) {
			this.waitforPageToload();
		}
	}

	@Override
	protected void load() {
		String pageURL = getPageURL();
		driver.get(pageURL);

	}
	@Override
	public GeneralPage get() {

		GeneralPage page = super.get();
		this.waitforPageToload();
		return page;
	}

	@Override
	protected abstract void isLoaded() throws Error;

	protected abstract String getPageURL();

	public void waitforPageToload() {
		this.waitForDocumentCompleteststate();

	}

	protected boolean urlContains(String url) {
		try {
			String pageUrl = getPageURL();

			URL pageUrlObject = new URL(pageUrl);
			URL urlObject = new URL(url);

			String pageUrlHost = pageUrlObject.getHost();
			String urlHost = urlObject.getHost();

			System.out.println((String.format("Checking URL: Contains: %s; Actual: %s", pageUrl, url)));

			if (pageUrlHost.equalsIgnoreCase(urlHost)) {
				// Using URL.getPath() did not work with buy flow where URLs
				// contain a '#' which denotes the 'ref' portion of a URL.
				// See
				// https://docs.oracle.com/javase/tutorial/networking/urls/urlInfo.html.
				String pageUrlExclHost = pageUrl.substring(pageUrl.indexOf(pageUrlHost) + pageUrlHost.length());
				String urlExclHost = url.substring(url.indexOf(urlHost) + urlHost.length());
				return urlExclHost.toLowerCase().contains(pageUrlExclHost.toLowerCase());
			} else {
				return false;
			}

		} catch (MalformedURLException e) {

		}

		return false;
	}

	public void waitForDocumentCompleteststate() {
		waitForDocumentCompleteState(DEFAULT_TIME_TO_WAIT_FOR_PAGE);

	}

	public void waitForDocumentCompleteState(int secondsToWait) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIME_TO_WAIT_FOR_PAGE));

	}
}

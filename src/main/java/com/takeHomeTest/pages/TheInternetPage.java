package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class TheInternetPage extends Page {

	public TheInternetPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By formAuthenticationBtn = By.cssSelector("div#content ul li:nth-of-type(21) a");
	private By checkBoxesBtn = By.cssSelector("div#content ul li:nth-of-type(6) a");
	private By contextMenuBtn = By.cssSelector("div#content ul li:nth-of-type(7) a");
	private By dragNDropBtn = By.cssSelector("div#content ul li:nth-of-type(10) a");
	private By dropDownBtn = By.cssSelector("div#content ul li:nth-of-type(11) a");
	private By dynamicContentBtn = By.cssSelector("div#content ul li:nth-of-type(12) a");
	private By dynamicControltBtn = By.cssSelector("div#content ul li:nth-of-type(13) a");
	private By dynamicLoadingPageBtn = By.cssSelector("div#content ul li:nth-of-type(14) a");
	private By dynamicLoadingExample1 = By.cssSelector("div.example a:first-of-type");
	private By downloadPageBtn = By.cssSelector("div#content ul li:nth-of-type(17) a");
	private By uploadPageBtn = By.cssSelector("div#content ul li:nth-of-type(18) a");
	private By floatingMenuBtn = By.cssSelector("div#content ul li:nth-of-type(19) a");
	private By framePageBtn = By.cssSelector("div#content ul li:nth-of-type(22) a");
	private By hoverPageBtn = By.cssSelector("div#content ul li:nth-of-type(25) a");
	private By javaScriptPage = By.cssSelector("div#content ul li:nth-of-type(29) a");
	private By javaScriptErrorPage = By.cssSelector("div#content ul li:nth-of-type(30) a");
	private By newWindowPage = By.cssSelector("div#content ul li:nth-of-type(33) a");
	private By NotiifcationPage = By.cssSelector("div#content ul li:nth-of-type(35) a");

	public LoginPage clickformAuthenticationBtn() {
		((ProxyDriver) wd).click(formAuthenticationBtn);
		return new LoginPage(wd, true);
	}

	public CheckBoxPage clickcheckBoxesBtn() {
		((ProxyDriver) wd).click(checkBoxesBtn);
		return new CheckBoxPage(wd, true);
	}

	public ContextMenuPage clickcontextMenuBtn() {
		((ProxyDriver) wd).click(contextMenuBtn);
		return new ContextMenuPage(wd, true);
	}

	public DragNDropPage clickDragNDropBtn() {
		((ProxyDriver) wd).click(dragNDropBtn);
		return new DragNDropPage(wd, true);
	}

	public DropDownPage clickDropDownBtn() {
		((ProxyDriver) wd).click(dropDownBtn);
		return new DropDownPage(wd, true);
	}

	public DynamicContentPage clickDynamicContentBtn() {
		((ProxyDriver) wd).click(dynamicContentBtn);
		return new DynamicContentPage(wd, true);
	}

	public DynamicControls clickDynamicControltBtn() {
		((ProxyDriver) wd).click(dynamicControltBtn);
		return new DynamicControls(wd, true);
	}

	public DynamicLoadingPage clickDynamicLoadingPageBtn() {
		((ProxyDriver) wd).click(dynamicLoadingPageBtn);
		((ProxyDriver) wd).click(dynamicLoadingExample1);
		return new DynamicLoadingPage(wd, true);
	}

	public DownloadPage clickDownloadPageBtn() {
		((ProxyDriver) wd).click(downloadPageBtn);
		return new DownloadPage(wd, true);
	}

	public UploadPage clickuploadPageBtn() {
		((ProxyDriver) wd).click(uploadPageBtn);
		return new UploadPage(wd, true);
	}

	public FloatingMenuPage clickfloatingMenuBtn() {
		((ProxyDriver) wd).click(floatingMenuBtn);
		return new FloatingMenuPage(wd, true);
	}

	public FramePage clickframePageBtn() {
		((ProxyDriver) wd).click(framePageBtn);
		return new FramePage(wd, true);
	}

	public MouseHoverPage clickhoverPageBtn() {
		((ProxyDriver) wd).click(hoverPageBtn);
		return new MouseHoverPage(wd, true);
	}

	public JavaScriptAlertsPage clickjavaScriptPage() {
		((ProxyDriver) wd).click(javaScriptPage);
		return new JavaScriptAlertsPage(wd, true);
	}

	public JavaScriptErrorPage clickjavaScriptErrorPage() {
		((ProxyDriver) wd).click(javaScriptErrorPage);
		return new JavaScriptErrorPage(wd, true);
	}

	public MultipleWindowPage clicknewWindowPage() {
		((ProxyDriver) wd).click(newWindowPage);
		return new MultipleWindowPage(wd, true);
	}

	public NotificationMsgPage clickNotiifcationPage() {
		((ProxyDriver) wd).click(NotiifcationPage);
		return new NotificationMsgPage(wd, true);
	}
}

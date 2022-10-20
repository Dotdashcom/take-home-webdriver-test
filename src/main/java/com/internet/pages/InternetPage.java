package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class InternetPage extends Page {

	public InternetPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By formAuthentication = By.xpath("//a[contains(text(),'Form Authentication')]");
	private By checkBoxes = By.cssSelector("a[href='/checkboxes']");
	private By contextMenu=By.cssSelector("a[href='/context_menu']");
	private By drapAndDrop=By.cssSelector("a[href='/drag_and_drop']");
	private By dropDown=By.cssSelector("a[href='/dropdown']");
	private By dynamicContent=By.cssSelector("a[href='/dynamic_content']");

	private By dynamicControls=By.cssSelector("a[href='/dynamic_controls']");
	private By dynamicLoading=By.cssSelector("a[href='/dynamic_loading']");
	private By fileDownload=By.cssSelector("a[href='/download']");
	private By fileUpload=By.cssSelector("a[href='/upload']");
	private By floatingMenu=By.cssSelector("a[href='/floating_menu']");
	private By iframe=By.cssSelector("a[href='/frames']");
	private By hover=By.cssSelector("a[href='/hovers']");
	private By javascriptalert=By.cssSelector("a[href='/javascript_alerts']");
	private By javascripterror=By.cssSelector("a[href='/javascript_error']");
	private By windows=By.cssSelector("a[href='/windows']");
	private By notification=By.cssSelector("a[href='/notification_message']");

	
	public AccountLoginPage clickformAuthentication() {
		((ProxyDriver) driver).click(formAuthentication);
		return new AccountLoginPage(driver, true);
	}

	public CheckBoxesPage clickCheckBoxes() {
		((ProxyDriver) driver).click(checkBoxes);
		return new CheckBoxesPage(driver, true);
	}
	public ContextMenuPage clickContextMenu() {
		((ProxyDriver) driver).click(contextMenu);
		return new ContextMenuPage(driver, true);
	}
	public DragAndDropPage clickDragAndDrop() {
		((ProxyDriver) driver).click(drapAndDrop);
		return new DragAndDropPage(driver, true);
	}
	public DropDownPage clickDropDown() {
		((ProxyDriver) driver).click(dropDown);
		return new DropDownPage(driver, true);
	}
	public DynamicContentPage clickDynamicContent() {
		((ProxyDriver) driver).click(dynamicContent);
		return new DynamicContentPage(driver, true);
	}
	public DynamicControlsPage clickDynamicControls() {
		((ProxyDriver) driver).click(dynamicControls);
		return new DynamicControlsPage(driver, true);
	}
	public DynamicPageLoading clickDynamicLoading() {
		((ProxyDriver) driver).click(dynamicLoading);
		return new DynamicPageLoading(driver, true);
	}
	public FileDownloadPage clickFileDownload() {
		((ProxyDriver) driver).click(fileDownload);
		return new FileDownloadPage(driver, true);
	}

	public FileUploadPage clickFileUpload() {
		((ProxyDriver) driver).click(fileUpload);
		return new FileUploadPage(driver, true);
	}
	public FloatingMenuPage clickFloatingMenu() {
		((ProxyDriver) driver).click(floatingMenu);
		return new FloatingMenuPage(driver, true);
	}
	public FramePage clickFrames() {
		((ProxyDriver) driver).click(iframe);
		return new FramePage(driver, true);
	}
	public MouseHoverPage clickHovers() {
		((ProxyDriver) driver).click(hover);
		return new MouseHoverPage(driver, true);
	}
	public JavascriptAlertPage clickalert() {
		((ProxyDriver) driver).click(javascriptalert);
		return new JavascriptAlertPage(driver, true);
	}
	public JavascriptErrorPage clickerror() {
		((ProxyDriver) driver).click(javascripterror);
		return new JavascriptErrorPage(driver, true);
	}
	public MultipleWindowsPage clickWindows() {
		((ProxyDriver) driver).click(windows);
		return new MultipleWindowsPage(driver, true);
	}

	public NotificationMessagePage clickNotification() {
		((ProxyDriver) driver).click(notification);
		return new NotificationMessagePage(driver, true);
	}
}
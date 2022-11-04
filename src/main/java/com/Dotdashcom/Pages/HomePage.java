package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class HomePage extends GeneralPage {
	
	public HomePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	private static final String PAGE_URL = "";

	private By formAuthentication = By.xpath("//a[contains(text(),'Form Authentication')]");
	private By checkBoxes = By.cssSelector("a[href='/checkboxes']");
	private By contextMenu=By.cssSelector("a[href='/context_menu']");
	private By drapAndDrop=By.cssSelector("a[href='/drag_and_drop']");
	private By dropDown=By.cssSelector("a[href='/dropdown']");
	private By dynamicContent=By.cssSelector("a[href='/dynamic_content']");

	private By dynamicControls=By.cssSelector("a[href='/dynamic_controls']");
	private By dynamicLoading=By.cssSelector("a[href='/dynamic_loading']");
	private By clickOnFirstLink=By.cssSelector("#content > div > a:nth-child(8)");
	private By fileDownload=By.cssSelector("a[href='/download']");
	private By fileUpload=By.cssSelector("a[href='/upload']");
	private By floatingMenu=By.cssSelector("a[href='/floating_menu']");
	private By iframe=By.cssSelector("a[href='/frames']");
	private By hover=By.cssSelector("a[href='/hovers']");
	private By javascriptalert=By.cssSelector("a[href='/javascript_alerts']");
	private By javascripterror=By.cssSelector("a[href='/javascript_error']");
	private By windows=By.cssSelector("a[href='/windows']");
	private By notification=By.cssSelector("a[href='/notification_message']");


	public LoginPage clickformAuthentication() {
		((ProxyDriver) wd).click(formAuthentication);
		return new LoginPage(wd, true);
	}

	public CheckBoxesPage clickCheckBoxes() {
		((ProxyDriver) wd).click(checkBoxes);
		return new CheckBoxesPage(wd, true);
	}
	public ContextMenuPage clickContextMenu() {
		((ProxyDriver) wd).click(contextMenu);
		return new ContextMenuPage(wd, true);
	}
	public DragAndDropPage clickDragAndDrop() {
		((ProxyDriver) wd).click(drapAndDrop);
		return new DragAndDropPage(wd, true);
	}
	public DropDownPage clickDropDown() {
		((ProxyDriver) wd).click(dropDown);
		return new DropDownPage(wd, true);
	}
	public DynamicContentPage clickDynamicContent() {
		((ProxyDriver) wd).click(dynamicContent);
		return new DynamicContentPage(wd, true);
	}
	public DynamicControlsPage clickDynamicControls() {
		((ProxyDriver) wd).click(dynamicControls);
		return new DynamicControlsPage(wd, true);
	}
	public DynamicLoadingPage clickDynamicLoading() {
		((ProxyDriver) wd).click(dynamicLoading);
		((ProxyDriver) wd).click(clickOnFirstLink);
		return new DynamicLoadingPage(wd, true);
	}
	public FileDownLoadPage clickFileDownload() {
		((ProxyDriver) wd).click(fileDownload);
		return new FileDownLoadPage(wd, true);
	}
//
	public FileUploadPage clickFileUpload() {
		((ProxyDriver) wd).click(fileUpload);
		return new FileUploadPage(wd, true);
	}
	public FloatingMenuPage clickFloatingMenu() {
		((ProxyDriver) wd).click(floatingMenu);
		return new FloatingMenuPage(wd, true);
	}
	public IFramePage clickFrames() {
		((ProxyDriver) wd).click(iframe);
		return new IFramePage(wd, true);
	}
	public MouseHoverPage clickhoverPageBtn() {
		((ProxyDriver) wd).click(hover);
		return new MouseHoverPage(wd, true);
	}
	public JavaScriptAlertsPage clickalert() {
		((ProxyDriver) wd).click(javascriptalert);
		return new JavaScriptAlertsPage(wd, true);
	}
	public JavaScriptErrorPage clickError() {
		((ProxyDriver) wd).click(javascripterror);
		return new JavaScriptErrorPage(wd, true);
	}
	public OpenNewWindowPage clickWindows() {
		((ProxyDriver) wd).click(windows);
		return new OpenNewWindowPage(wd, true);
	}

	public NotificationMessagePage clickNotification() {
		((ProxyDriver) wd).click(notification);
		return new NotificationMessagePage(wd, true);
	}
	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}

}

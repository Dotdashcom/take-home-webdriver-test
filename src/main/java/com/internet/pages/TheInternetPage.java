package com.internet.pages;

import com.internet.utils.Proxywrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheInternetPage extends Page {

	public TheInternetPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By formAuthentication = By.xpath("//a[contains(text(),'Form Authentication')]");
	private By checkBoxes = By.cssSelector("a[href='/checkboxes']");
	private By contextMenu=By.cssSelector("a[href='/context_menu']");
	private By dragAndDrop=By.cssSelector("a[href='/drag_and_drop']");
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

	
	public LoginPage clickformAuthentication() {
		((Proxywrapper) driver).click(formAuthentication);
		return new LoginPage(driver, true);
	}

	public CheckBoxesPage clickCheckBoxes() {
		((Proxywrapper) driver).click(checkBoxes);
		return new CheckBoxesPage(driver, true);
	}
	public ContextMenuPage clickContextMenu() {
		((Proxywrapper) driver).click(contextMenu);
		return new ContextMenuPage(driver, true);
	}

	public DragAndDropPage clickDragAndDrop(){
		((Proxywrapper) driver).click(dragAndDrop);
		return new DragAndDropPage(driver, true);
	}
	
	public DropDownPage clickDropDown() {
		((Proxywrapper) driver).click(dropDown);
		return new DropDownPage(driver, true);
	}
	public DynamicContentPage clickDynamicContent() {
		((Proxywrapper) driver).click(dynamicContent);
		return new DynamicContentPage(driver, true);
	}
	public DynamicControlsPage clickDynamicControls() {
		((Proxywrapper) driver).click(dynamicControls);
		return new DynamicControlsPage(driver, true);
	}
	public DynamicLoadingPage clickDynamicLoading() {
		((Proxywrapper) driver).click(dynamicLoading);
		return new DynamicLoadingPage(driver, true);
	}
	public FileDownloadPage clickFileDownload() {
		((Proxywrapper) driver).click(fileDownload);
		return new FileDownloadPage(driver, true);
	}

	public FileUploadPage clickFileUpload() {
		((Proxywrapper) driver).click(fileUpload);
		return new FileUploadPage(driver, true);
	}
	public FloatingMenuPage clickFloatingMenu() {
		((Proxywrapper) driver).click(floatingMenu);
		return new FloatingMenuPage(driver, true);
	}
	public FramesPage clickFrames() {
		((Proxywrapper) driver).click(iframe);
		return new FramesPage(driver, true);
	}
	public HoversPage clickHovers() {
		((Proxywrapper) driver).click(hover);
		return new HoversPage(driver, true);
	}
	public JavascriptAlertPage clickalert() {
		((Proxywrapper) driver).click(javascriptalert);
		return new JavascriptAlertPage(driver, true);
	}
	public JavascriptErrorPage clickerror() {
		((Proxywrapper) driver).click(javascripterror);
		return new JavascriptErrorPage(driver, true);
	}
	public MultipleWindowsPage clickWindows() {
		((Proxywrapper) driver).click(windows);
		return new MultipleWindowsPage(driver, true);
	}

	public NotificationMessagePage clickNotification() {
		((Proxywrapper) driver).click(notification);
		return new NotificationMessagePage(driver, true);
	}
}

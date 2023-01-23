package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class LandingPage extends AbstractClass {
	WebDriver driver;

	@FindBy(partialLinkText = "Form Authentication")
	WebElement loginLink;
	@FindBy(partialLinkText = "Context Menu")
	WebElement contextLink;
	@FindBy(partialLinkText = "Dropdown")
	WebElement dropdownLink;
	@FindBy(partialLinkText = "Dynamic Controls")
	WebElement dynamiccontrolLink;
	@FindBy(partialLinkText = "Dynamic Loading")
	WebElement ldynamicloadingLink;
	@FindBy(partialLinkText = "Example 1:")
	WebElement dynamicloadingLink;
	@FindBy(partialLinkText = "Floating Menu")
	WebElement floatingmenugLink;
	@FindBy(partialLinkText = "JavaScript Alerts")
	WebElement javascriptLink;
	@FindBy(partialLinkText = "Multiple Windows")
	WebElement multiplewindowLink;
	@FindBy(partialLinkText = "Notification Messages")
	WebElement notificationLink;
	@FindBy(partialLinkText = "File Download")
	WebElement fileDownloadLink;
	@FindBy(partialLinkText = "Checkboxes")
	WebElement checkboxLink;
	@FindBy(partialLinkText = "Drag and Drop")
	WebElement dragndropLink;
	@FindBy(partialLinkText = "Dynamic Content")
	WebElement dynamicLink;
	@FindBy(partialLinkText = "JavaScript onload event error")
	WebElement JSErrorLink;
	@FindBy(partialLinkText = "Hovers")
	WebElement hoversLink;
	@FindBy(partialLinkText = "Frames")
	WebElement framesLink;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getTo() throws InterruptedException {
		driver.get("http://localhost:7080");
		Thread.sleep(1000);
	}

	public LoginPage getLoginPage() throws InterruptedException {
		loginLink.click();
		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		return loginPage;
	}

	public ContextMenuPage getContextPage() throws InterruptedException {
		contextLink.click();
		Thread.sleep(1000);
		ContextMenuPage contextpage = new ContextMenuPage(driver);
		Thread.sleep(1000);
		return contextpage;
	}

	public DropDownPage getdropdownPage() throws InterruptedException {
		dropdownLink.click();
		Thread.sleep(1000);
		DropDownPage dropdownpage = new DropDownPage(driver);
		Thread.sleep(1000);
		return dropdownpage;
	}

	public DynamicControlsPage getdynamicControlPage() throws InterruptedException {
		dynamiccontrolLink.click();
		Thread.sleep(1000);
		DynamicControlsPage dynamiccontrolpage = new DynamicControlsPage(driver);
		Thread.sleep(1000);
		return dynamiccontrolpage;
	}

	public DynamicLoadingPage getdynamicloadingPage() throws InterruptedException {
		ldynamicloadingLink.click();

		Thread.sleep(1000);
		dynamicloadingLink.click();
		Thread.sleep(1000);
		DynamicLoadingPage dynamicloadingpage = new DynamicLoadingPage(driver);
		Thread.sleep(1000);
		return dynamicloadingpage;
	}

	public FloatingMenuPage getfloatMenuPage() throws InterruptedException {
		floatingmenugLink.click();
		Thread.sleep(1000);
		FloatingMenuPage floatingmenupage = new FloatingMenuPage(driver);
		Thread.sleep(1000);
		return floatingmenupage;

	}

	public JavaScriptAlertsPage getjavascriptPage() throws InterruptedException {
		javascriptLink.click();
		Thread.sleep(1000);
		JavaScriptAlertsPage javaScriptalertspage = new JavaScriptAlertsPage(driver);
		Thread.sleep(1000);
		return javaScriptalertspage;

	}

	public OpenInnewtabPage getnewwindowPage() throws InterruptedException {
		multiplewindowLink.click();
		Thread.sleep(1000);
		OpenInnewtabPage openinnewtabpage = new OpenInnewtabPage(driver);
		Thread.sleep(1000);
		return openinnewtabpage;

	}

	public NotificationMessagePage getnotificationPage() throws InterruptedException {
		notificationLink.click();
		Thread.sleep(1000);
		NotificationMessagePage notificationPage = new NotificationMessagePage(driver);
		Thread.sleep(1000);
		return notificationPage;

	}

	public FileDownloadPage getfiledownloadPage() throws InterruptedException {
		fileDownloadLink.click();
		Thread.sleep(1000);
		FileDownloadPage filedownloadpage = new FileDownloadPage(driver);
		Thread.sleep(1000);
		return filedownloadpage;

	}

	public CheckboxPage getcheckboxPage() throws InterruptedException {
		checkboxLink.click();
		Thread.sleep(1000);
		CheckboxPage checkboxpage = new CheckboxPage(driver);
		Thread.sleep(1000);
		return checkboxpage;

	}

	public DragNDropPage getdragndropPage() throws InterruptedException {
		dragndropLink.click();
		Thread.sleep(1000);
		DragNDropPage dragNdroppage = new DragNDropPage(driver);
		Thread.sleep(1000);
		return dragNdroppage;

	}

	public DynamicContentPage getdynamiccontentPage() throws InterruptedException {
		dynamicLink.click();
		Thread.sleep(1000);
		DynamicContentPage dynamiccontentpage = new DynamicContentPage(driver);
		Thread.sleep(1000);
		return dynamiccontentpage;

	}

	public JavaScriptErrorPage getJSErrorPage() throws InterruptedException {
		JSErrorLink.click();
		Thread.sleep(1000);
		JavaScriptErrorPage javascripterrortest = new JavaScriptErrorPage(driver);
		Thread.sleep(1000);
		return javascripterrortest;

	}

	public MouseOverPage getMouseHoverPage() throws InterruptedException {
		hoversLink.click();
		Thread.sleep(1000);
		MouseOverPage mouseoverpage = new MouseOverPage(driver);
		Thread.sleep(1000);
		return mouseoverpage;

	}

	public IframePage getFramePage() throws InterruptedException {
		framesLink.click();
		Thread.sleep(1000);

		FramesPage framepage = new FramesPage(driver);
		IframePage iframePage = framepage.nextframe();
		
		Thread.sleep(1000);
		return iframePage;
	}

}

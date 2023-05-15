package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	private WebDriver driver;
	@FindBy(how = How.LINK_TEXT, using = "Form Authentication")
	private WebElement fromAuthentication;

	@FindBy(how = How.LINK_TEXT, using = "Checkboxes")
	private WebElement checkBoxes;

	@FindBy(how = How.LINK_TEXT, using = "Context Menu")
	private WebElement contextMenu;

	@FindBy(how = How.LINK_TEXT, using = "Drag and Drop")
	private WebElement dragAndDrop;

	@FindBy(how = How.LINK_TEXT, using = "Dropdown")
	private WebElement dropDown;

	@FindBy(how = How.LINK_TEXT, using = "Dynamic Content")
	private WebElement dynamicContent;

	@FindBy(how = How.LINK_TEXT, using = "Dynamic Controls")
	private WebElement dynamicControl;

	@FindBy(how = How.LINK_TEXT, using = "Dynamic Loading")
	private WebElement dynamicLoading;

	@FindBy(how = How.LINK_TEXT, using = "File Download")
	private WebElement fileDownLoad;

	@FindBy(how = How.LINK_TEXT, using = "File Upload")
	private WebElement fileUpload;

	@FindBy(how = How.LINK_TEXT, using = "Floating Menu")
	private WebElement floatMenu;

	@FindBy(how = How.LINK_TEXT, using = "Frames")
	private WebElement frame;

	@FindBy(how = How.LINK_TEXT, using = "Hovers")
	private WebElement hover;

	@FindBy(how = How.LINK_TEXT, using = "JavaScript Alerts")
	private WebElement javaScriptAlert;
	
	@FindBy(how = How.LINK_TEXT, using = "JavaScript onload event error")
	private WebElement javaScriptError;
	
	@FindBy(how = How.LINK_TEXT, using = "Multiple Windows")
	private WebElement openNewTab;
	
	@FindBy(how = How.LINK_TEXT, using = "Notification Messages")
	private WebElement notificationMessage;


	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickAuthenticationLink() {
		fromAuthentication.click();
		return new LoginPage(driver);
	}

	public CheckBoxesPage clickCheckBox() {
		checkBoxes.click();
		return new CheckBoxesPage(driver);

	}

	public ContextMenuPage clickContextMenu() {
		contextMenu.click();
		return new ContextMenuPage(driver);
	}

	public DragAndDropPage clickDragAndDrop() {
		dragAndDrop.click();
		return new DragAndDropPage(driver);
	}

	public DropdownPage clickDropDown() {
		dropDown.click();
		return new DropdownPage(driver);
	}

	public DynamicContentPage clickDynamicContent() {
		dynamicContent.click();
		return new DynamicContentPage(driver);
	}

	public DynamicControlsPage clickDynamicControl() {
		dynamicControl.click();
		return new DynamicControlsPage(driver);
	}

	public DynamicLoadingPage clickDynamicLoading() {
		dynamicLoading.click();
		return new DynamicLoadingPage(driver);
	}

	public FileDownloadPage clickFileDown() {
		fileDownLoad.click();
		return new FileDownloadPage(driver);
	}

	public FileUploadPage clickFileUpload() {
		fileUpload.click();
		return new FileUploadPage(driver);
	}

	public FloatingMenuPage clickFloatMenu() {

		floatMenu.click();
		return new FloatingMenuPage(driver);
	}

	public IframePage clickFrame() {
		frame.click();
		return new IframePage(driver);
	}

	public MouseHoverPage clickHover() {
		hover.click();
		return new MouseHoverPage(driver);
	}

	public JavaScriptAlertsPage clickJavascriptAlert() {
		javaScriptAlert.click();
		return new JavaScriptAlertsPage(driver);
	}
	
	public JavaScriptErrorPage clickJavaScriptErro() {
		javaScriptError.click();
		return new JavaScriptErrorPage(driver);
	}

	public OpeningNewTabPage clickOpenNewTab() {
		openNewTab.click();
		return new OpeningNewTabPage(driver);	
	}
	
	public NotificationMessagePage clickNotification() {
		notificationMessage.click();
		return new NotificationMessagePage(driver);
	}
	

}
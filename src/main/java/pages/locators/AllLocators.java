package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllLocators {
	
	//checkboxes
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public WebElement checkbox1;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement checkbox2;
	
	//context menu
	
	@FindBy(id = "hot-spot")
	public WebElement contextMenu;
	
	//Drag and Drop
	
	@FindBy(xpath = "//div[@id='column-a']")
	public WebElement boxA;
	
	@FindBy(xpath = "//div[@id='column-b']")
	public WebElement boxB;
	
	@FindBy(xpath = "//h3[text()='Drag and Drop']")
	public WebElement body;
	
	// Dropdown
	
	@FindBy(id = "dropdown")
	public WebElement dropdown;
	
	// Dynamic Content
	
	@FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
	public WebElement dynamicContent;
	
	// Dynamic Controls
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement removeCheckbox;
	
	@FindBy(xpath = "//button[normalize-space()='Remove']")
	public WebElement removeBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	public WebElement addBtn;
	
	@FindBy(id = "message")
	public WebElement message;
	
	@FindBy(xpath = "//button[normalize-space()='Enable']")
	public WebElement enableBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Disable']")
	public WebElement disableBtn;
	
	@FindBy(xpath = "//input[@type='text']")
	public WebElement textBox;
	
	
	// Dynamic loading
	
	@FindBy(xpath = "//button[normalize-space()='Start']")
	public WebElement startBtn;
	
	@FindBy(id = "finish")
	public WebElement finish;
	
	// File Downlaod
	
	@FindBy(xpath = "//a[normalize-space()='some-file.txt']")
	public WebElement fileDownload;

	
	// file upload
	
	@FindBy(id = "file-upload")
	public WebElement fileUpload;
	
	@FindBy(id = "file-submit")
	public WebElement uploadBtn;
	
	@FindBy(id = "uploaded-files")
	public WebElement uploadedFile;
	
	
	// floating menu
	
	@FindBy(id = "menu")
	public WebElement floatingMenu;
	
	
	// Iframe
	
	@FindBy(xpath = "//div[@aria-label='Close']")
	public WebElement iframeCloseBtn;
	
	@FindBy(id = "tinymce")
	public WebElement iFrameTextBox;
	
	// mouse hover
	
	@FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
	public WebElement mouseHover1;
	
	@FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
	public WebElement mouseHover2;
	
	@FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
	public WebElement mouseHover3;
	
	
	@FindBy(xpath = "//div[@class='figcaption']")
	public WebElement mouseHoverCaption;
	
	
	// JavaScript Alerts
	
	@FindBy(xpath = "//button[@onclick='jsAlert()']")
	public WebElement JSAlert;
	
	@FindBy(xpath = "//button[@onclick='jsConfirm()']")
	public WebElement JSConfirm;
	
	@FindBy(xpath = "//button[@onclick='jsPrompt()']")
	public WebElement JSPrompt;
	
	@FindBy(xpath = "//p[@id='result']")
	public WebElement JSPromptMessage;
	
	// JavaScript Errors
	
	// Open In New Tab
	
	@FindBy(xpath = "//a[text()='Click Here']")
	public WebElement newTabClick;
	
	// Notification Message
	
	@FindBy(xpath = "//a[text()='Click here']")
	public WebElement notificationClick;
	
	@FindBy(id = "flash")
	public WebElement notificationMessage;
	
	
	
	
	
	
	
	

}

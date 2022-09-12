package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//i[contains(@class,'fa-sign-in')]")
	WebElement login;
	
	@FindBy(xpath="//input[@type='checkbox'][1]")
	WebElement checkbox1;
	
	@FindBy(xpath="//input[@type='checkbox'][2]")
	WebElement checkbox2;
	
	@FindBy(xpath="//div[@id='hot-spot']")
	WebElement contextBox;
	
	@FindBy(xpath="//div[@id='column-a']")
	WebElement elementA;
	
	@FindBy(xpath="//div[@id='column-b']")
	WebElement elementB;
	
	@FindBy(xpath="//select[@id='dropdown']")
	WebElement dropdown;
	
	@FindBy(xpath="//a[contains(@href,'download')]")
	WebElement fileDownloadLink;
	
	@FindBy(xpath="//input[@id='file-upload']")
	WebElement fileUpload;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement fileUploadButton;
	
	@FindBy(xpath="//button[text()='Start']")
	WebElement startButton;
	
	@FindBy(xpath="//button[text()='Remove']")
	WebElement removeButton;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement addButton;
	
	@FindBy(xpath="//button[contains(@onclick,'swapCheckbox')]")
	WebElement swapCheckboxButton;
	
	@FindBy(xpath="//button[contains(@onclick,'swapInput')]")
	WebElement swapInputButton;
	
	@FindBy(xpath="//button[text()='Enable']")
	WebElement enableButton;
	
	@FindBy(xpath="//button[text()='Disable']")
	WebElement disableButton;
	
	@FindBy(xpath="//input/parent::div[contains(text(),'checkbox')]")
	WebElement dynamicControlsCheckbox;
	                
	@FindBy(xpath="//form[@id='input-example']/input")
	WebElement dynamicControlsBar;
	
	@FindBy(xpath="//div[@id='finish']/h4")
	WebElement dynamicallyLoadedMessage;
	
	@FindBy(xpath="//iframe[@id='mce_0_ifr']")
	WebElement iframe;
	
	@FindBy(xpath="//body[@id='tinymce']/p")
	WebElement iframeParagraphBox;
	
	@FindBy(xpath="//a[text()='Click Here']")
	WebElement clickHereButton;
	
	@FindBy(xpath="//a[text()='Click here']")
	WebElement clickHereLink;
	
	@FindBy(xpath="//div[@id='menu']")
	WebElement floatingMenu;
	
	@FindBy(xpath="//button[contains(@class,'dismiss')]")
	WebElement closeButton;
	
	@FindBy(xpath="//button[contains(text(),'JS Alert')]")
	WebElement jsAlertButton;
	
	@FindBy(xpath="//button[contains(text(),'JS Confirm')]")
	WebElement jsAlertConfirm;
	
	@FindBy(xpath="//button[contains(text(),'JS Prompt')]")
	WebElement jsAlertPrompt;
	
	@FindBy(xpath="//div[@id='flash']")
	WebElement flashMessage;
	
	
	public Login() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	

}

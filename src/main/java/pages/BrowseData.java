package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BrowseData extends TestBase{
	
	//all the WebElements get it form the Webpage to declare and  intialize here 
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement loginbutton;
	
	@FindBy(xpath ="//h4[@class='subheader']")
	public WebElement msg;
	
	@FindBy(xpath = "//div[contains(text(),'Your username is invalid')]")
	public WebElement errormsg;
	
	@FindBy(xpath ="//input[@type='checkbox'][1]")
	public WebElement checkbox1;
	
	@FindBy(xpath ="//input[@type='checkbox'][2]")
	public WebElement checkbox2;
	
	@FindBy(id="hot-spot")
	public WebElement contextMenu;
	
	@FindBy(xpath ="//div[@id='column-a']")
	public WebElement column_a;
	
	@FindBy(xpath ="//div[@id='column-b']")
	public WebElement column_b;
	
	@FindBy(xpath ="//div[@id='column-a']/header")
	public WebElement column_a_text;
	
	@FindBy(xpath ="//div[@id='column-b']/header")
	public WebElement column_b_text;
	
	@FindBy(id="dropdown")
	public WebElement dropdownmenu;
	
	@FindBy(xpath ="//option[@selected ='selected']")
	public WebElement dropdowntext;
	
	@FindBy(xpath ="//a[contains(text(),'click here')]")
	public WebElement linkbtn;
	
	@FindBy(xpath ="//div[@id='content']/div[3]")
	public WebElement dynamictext;
	
	@FindBy(xpath ="//button[contains(text(),'Remove')]")
	public WebElement removebutton;
	
	@FindBy(id="message")
	public WebElement textmsg;
	
	@FindBy(xpath ="//button[contains(text(),'Add')]")
	public WebElement addbutton;
	
	@FindBy(xpath ="//input[@id='checkbox']")
	public WebElement checkbox;
	
	@FindBy(xpath ="//button[contains(text(),'Enable')]")
	public WebElement enablebutton;
	
	@FindBy(xpath ="//p[@id='message']")
	public WebElement msg1;
	
	@FindBy(xpath ="//input[@type='text']")
	public WebElement textbox;
	
	@FindBy(xpath ="//button[contains(text(),'Disable')]")
	public WebElement disablebutton;
	
	@FindBy(xpath ="//button[contains(text(),'Start')]")
	public WebElement startButton;
	
	@FindBy(id="loading")
	public WebElement loadingicon;
	
	@FindBy(id="finish")
	public WebElement hellotext;
	
	@FindBy(xpath ="//a[contains(text(),'some-file.txt')]")
	public WebElement filedownload;
	
	@FindBy(xpath ="//input[@id='file-upload']")
	public WebElement fileupload;
	
	@FindBy(xpath ="//input[@id='file-submit']")
	public WebElement fileuploadbutton;
	
	@FindBy(xpath ="//h3[contains(text(),'File Uploaded!')]")
	public WebElement uploadtext;
	
	@FindBy(xpath ="//div[@id='menu']")
	public WebElement floatingmenu;
	
	@FindBy(xpath ="//iframe[@id='mce_0_ifr']")
	public WebElement iframe;
	
	@FindBy(id="tinymce")
	public WebElement framebody;
	
	@FindBy(xpath ="//div[@class='figure']")
	public List<WebElement> mousehover;
	
	@FindBy(xpath ="//div[@class='figcaption']")
	public List<WebElement> additionallist;
	
	@FindBy(xpath ="//button[contains(text(),'Click for JS Alert')]")
	public WebElement jsbutton;
	
	@FindBy(xpath ="//button[contains(text(),'Click for JS Confirm')]")
	public WebElement jsconfirm;
	
	@FindBy(xpath ="//button[contains(text(),'Click for JS Prompt')]")
	public WebElement jsprompt;
	
	@FindBy(id="result")
	public WebElement alertmsg;
	
	@FindBy(xpath ="//a[contains(text(),'Click Here')]")
	public WebElement newWindow;
	
	@FindBy(xpath ="//h3[contains(text(),'New Window')]")
	public WebElement newmessage;
	
	@FindBy(xpath ="//a[contains(text(),'Click here')]")
	public WebElement notificationlink;
	
	@FindBy(id="flash")
	public WebElement divmsg;
	
	public BrowseData() throws IOException {
		
		//Initialize the WebElements 
		PageFactory.initElements(driver, this);
	}
}

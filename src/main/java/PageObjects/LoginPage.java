package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(how=How.ID,using="username")
	private WebElement searchusername;
	
	@FindBy(how=How.ID,using="password")
	private WebElement searchpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchloginbutton;
	
	@FindBy(xpath="//div[@id='flash']")
	private WebElement successMsg;
	
	@FindBy(xpath="//div[@id='flash']")
	private WebElement failMsg;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
		}
	
	public void searchusernamebox(String username) {
		searchusername.sendKeys(username);
	}
	
	public void searchpasswordbox(String password) {
		searchpassword.sendKeys(password);
	}
	
	public void searchloginbutton() {
		searchloginbutton.click();
	}
	
    public String successMsgis() {
		return successMsg.getText();

    }
    
    public String failMsg() {
    	return failMsg.getText();
    }
	
	public void login(String username,String password) {
		searchusernamebox(username);
		searchpasswordbox(password);
		searchloginbutton();
	}
	
}

package Dotdashcom.takehomewebdrivertest.pages;

	
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

	public class NotificationMessage extends BaseClass {
		
		@FindBy(linkText = "Notification Messages")
	    WebElement notificationButton;

	    @FindBy(linkText = "Click here")
	    WebElement clickHereButton;
	    @FindBy(xpath = "//div[@class='flash notice']")
	    WebElement message;
		
		

		public NotificationMessage(){
			PageFactory.initElements(driver, this);
		
		}

	    public void clickButton(){
	        notificationButton.click();
	    }
	    public void clickHere(){
	        clickHereButton.click();
	    }
	    public String validateMessage(){
	        return message.getText();
	    }
}

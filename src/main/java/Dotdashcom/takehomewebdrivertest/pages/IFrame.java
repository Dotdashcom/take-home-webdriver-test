	package Dotdashcom.takehomewebdrivertest.pages;
	
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	
	import com.dotdashcom.takehomewebdrivertest.base.BaseClass;
	
		public class IFrame extends BaseClass {
			@FindBy(xpath = "//a[.='Frames']")
		    WebElement frameButton;
		    @FindBy(xpath = "//a[.='iFrame']")
		    WebElement iFrameButton;
	
		    @FindBy(xpath = "//body/div[4]/div[1]/div[1]/button[1]/div[1]/*[1]")
		    WebElement xButton;
		    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
		    WebElement messageInBox;
			
			
	
			
			JavascriptExecutor j = (JavascriptExecutor) driver;
			public IFrame(){
				PageFactory.initElements(driver, this);
			
			}
			
			public void clickButtons(){
				frameButton.click();
				iFrameButton.click();
	
	
		    }
	
	
		    public String sendAndGetText(WebDriver driver){
		    	xButton.click();
		  //      driver.switchTo().frame("mce_0_ifr");
		        messageInBox.clear();
		        messageInBox.sendKeys("my input message");
		        return messageInBox.getText();
	
		    }
	
		}

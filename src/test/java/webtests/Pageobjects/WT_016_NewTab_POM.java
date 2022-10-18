package webtests.Pageobjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import webtests.BasePackage.WT_BaseClass;

public class WT_016_NewTab_POM extends WT_BaseClass{
	
	@FindBy (xpath= "//a[contains(text(),'Click Here')]")
	WebElement Clickherelink;
	
	@FindBy (xpath= "//h3[contains(text(),'New Window')]")
	WebElement Newwindow;
 
	public WT_016_NewTab_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public void ClickHereLink() {
		Clickherelink.click();
		
		
	}
	
	public String NewWindowText() {
		String text = Newwindow.getText();
		return text;
		
	}
	
	
	
}

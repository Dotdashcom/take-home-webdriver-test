package pomPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomDynamicContent extends BaseClass{
	
	public PomDynamicContent() {
		
		PageFactory.initElements(driver, this);
	}
    
	@FindBy (xpath = "//*[@id=\"content\"]/div[1]/div[2]") WebElement image1text;
    
    @FindBy (xpath = "//*[@id=\"content\"]/div[2]/div[2]") WebElement image2text;
	
	public String dyanamictextcheck() throws InterruptedException {
		
		String fig1= image1text.getText();
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		return fig1;
	}
	public String dynamictextafterrefresh() {
		
		String fig1afterrefresh = image1text.getText();
		return fig1afterrefresh;
	}
	
	
}

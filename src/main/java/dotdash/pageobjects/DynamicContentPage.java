package dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicContentPage {
	
public WebDriver driver;
	
	

	@FindBy(xpath="//div[@id='content']/div/div/div/div/div[2]")
	private WebElement firstpara;
	
	@FindBy(xpath="//div[@id='content']/div/div/div/div[2]/div[2]")
	private WebElement secondpara;
	
	@FindBy(xpath="//div[@id='content']/div/div/div/div[3]/div[2]")
	private WebElement thirdpara;
	
	
	public DynamicContentPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void refreshPage(int count)  {
		
		for(int i=0; i<count; i++) {
			String fpBefore = firstpara.getText();
			String spBefore = secondpara.getText();
			String tpBefore = thirdpara.getText();
			driver.navigate().refresh();
			Assert.assertNotEquals(firstpara.getText(), fpBefore);
			Assert.assertNotEquals(secondpara.getText(), spBefore);
			Assert.assertNotEquals(thirdpara.getText(), tpBefore);
		}
	}
	


}

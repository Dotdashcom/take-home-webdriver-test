package java.Pages;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPages {
	
	WebDriver driver;
	
	public NewWindowPages(WebDriver driver)
	{
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//div[@class='example']//a")
	WebElement linkToOpenANewWindow;
	
	
	@FindBy(xpath = "//div//h3")
	WebElement newWindowText;
	
	
	
	public void openANewWindow() throws InterruptedException
	{
		
		String parent=driver.getWindowHandle();
		
		
		
		linkToOpenANewWindow.click();
		Thread.sleep(5000);
		
		
		Set<String>s=driver.getWindowHandles();
		
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());

		String text = newWindowText.getText();
		Assert.assertEquals(text, "New Window");
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	

}

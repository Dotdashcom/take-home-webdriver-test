package java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MouseHoversPage {

	WebDriver driver;
	
	public MouseHoversPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div//img[@src='/img/avatar-blank.jpg'])[1]")
	WebElement image1;
	
	@FindBy(xpath = "(//div//img[@src='/img/avatar-blank.jpg'])[2]")
	WebElement image2;
	
	@FindBy(xpath = "(//div//img[@src='/img/avatar-blank.jpg'])[3]")
	WebElement image3;
	
	
	
	public void mouseHovers() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		
		
			for(int i=1;i<=3;i++)
			{	
			actions.moveToElement(driver.findElement(By.xpath("(//div//img[@src='/img/avatar-blank.jpg'])["+i+"]"))).build().perform();
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("(//div[@class='figcaption']//h5)["+i+"]"));
			String Text = element.getText();
			System.out.println(Text);
			Assert.assertEquals(Text, "name: user"+i+"");
			}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

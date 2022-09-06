package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls extends Driver {
	
	//Locators
	public static By RemoveBtn = By.xpath("//button[contains(text(),'Remove')]");
	public static By ChkboxBefore = By.xpath("//div[@id='checkbox']");
	public static By ChkboxAfter = By.xpath("//input[@id='checkbox']");
	public static By ItsBack = By.xpath("//p[@id='message']");
	public static By AddBtn = By.xpath("//button[@onclick='swapCheckbox()']");
	public static By EnableBtn = By.xpath("//button[contains(text(),'Enable')]");
	public static By Enablefield = By.xpath("//body/div[2]/div[1]/div[1]/form[2]/input[1]");
	public static By DisableBtn = By.xpath("//button[contains(text(),'Disable')]");
		
	// Create object of WebDriverWait class
	static WebDriverWait wait = new WebDriverWait(Driver.Instance,Duration.ofSeconds(20));

	// Navigate to Dynamic control page
	public static void NavigateToDynamicControlsPage()
	{
		Driver.Instance.get(Baseurl+"//dynamic_controls");		
	}
	
	// Click on Remove button
	public static void ClickremoveButton()
	{
		Driver.Instance.findElement(ChkboxBefore).isDisplayed();
		Driver.Instance.findElement(RemoveBtn).click();			
	}
		
	//Validate if checkbox is NotVisible 
	public static boolean IscheckBoxNotVisible()
	{
		Boolean CheckBox1 = wait.until(ExpectedConditions.invisibilityOfElementLocated(ChkboxBefore));
		return CheckBox1;		
	}
		
	// Click on Add Button
	public static void ClickAddButton()
	{
		if(IscheckBoxNotVisible()==true)
		{
			Driver.Instance.findElement(AddBtn).click();
		}
	}
		
	//Validate if checkbox is visible
	public static boolean IscheckBoxVisible()
	{				
		WebElement CheckBox2 =wait.until(ExpectedConditions.elementToBeClickable(ChkboxAfter));
		return CheckBox2.isDisplayed();
							
	}
	

	//Validate if Enable text field is Enabled
		public static boolean IsEnableTextBoxEnabled()
		{				
			WebElement EnableField =wait.until(ExpectedConditions.visibilityOfElementLocated(Enablefield));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean x = EnableField.isEnabled();
			return x;
		}
		
		
		
		// Click Enable Button
		public static void ClickEnableButton()
		{
			boolean IsEnable= IsEnableTextBoxEnabled();
			if(IsEnable == false)
			Driver.Instance.findElement(EnableBtn).click();	
			
		}
		
		//// Click Disable Button
		public static void ClickDisableButton()
		{
			boolean IsDisable= IsEnableTextBoxEnabled();
			if(IsDisable == true)
			Driver.Instance.findElement(DisableBtn).click();			
		}
		
}

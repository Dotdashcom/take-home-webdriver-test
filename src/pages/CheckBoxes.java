package pages;

import org.openqa.selenium.By;

public class CheckBoxes extends Driver 
{
	
	//Locators
	
	public static By ChkBox1 = By.xpath("//*[@id='checkboxes']/input[1]");
	public static By ChkBox2 = By.xpath("//*[@id='checkboxes']/input[2]");
	
	// Navigate to Checkbox page
	public static void NavigateToCheckBoxPage()
	{
		Driver.Instance.get(Baseurl+"//checkboxes");				
	}
			 
	// Method to check if checkbox is selected
	public static boolean IscheckboxSelected(By by)
	{
		return Driver.Instance.findElement(by).isSelected();
	}
	
	// Method to Enable checkbox
	public static void EnableCheckbox(By by)
	{
		if(IscheckboxSelected(by) == true)
		{
			System.out.print( by + " is already selected");
		}else
		{
			Driver.Instance.findElement(by).click();
		} 
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Enable checkbox1	 
	public static void EnableCheckbox1()
	{
		EnableCheckbox(ChkBox1);	 
	}
	
	//Enable checkbox2
	public static void EnableCheckbox2()
	{
		EnableCheckbox(ChkBox2);	 
	}
	
	//Is checkbox1 selected 
	public static boolean IsCheckBox1Selected() 
	{
		return IscheckboxSelected(ChkBox1);
	}
	
	//Is checkbox1 selected
	public static boolean IsCheckBox2Selected()
	{
		return IscheckboxSelected(ChkBox2);
	}
			 
	//Method to disable check box
	public static void DisableCheckbox(By by)
	{
		if(IscheckboxSelected(by) == true)
		{
			Driver.Instance.findElement(by).click();	
		}else
		{
			System.out.print(  by + " is already Disabled");
		}	 
	}
		 
	//Disable checkbox1
	public static void DisableCheckbox1()
	{
		DisableCheckbox(ChkBox1);	 
	} 
	
	//Disable checkbox2
	public static void DisableCheckbox2()
	{
		DisableCheckbox(ChkBox2); 
	}
		
}

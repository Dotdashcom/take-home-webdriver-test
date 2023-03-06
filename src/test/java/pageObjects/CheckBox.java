package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBox extends BaseTemplate{

	public CheckBox(WebDriver driver) {
		super(driver);
		
	}
	
	private static final By checkBox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private static final By checkBox2 = By.xpath("(//input[@type='checkbox'])[2]");
    
    
    public void clickCheckBox1() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBox1));
    	driver.findElement(checkBox1).click();
    }
    
    public void clickCheckBox2() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBox2));
    	driver.findElement(checkBox2).click();
    }
    
    //method to erase of existing actions
    public void unselectCheckBoxes() {
    	if(driver.findElement(checkBox1).isSelected())
    	{
    		driver.findElement(checkBox1).click();
    	}
    	else if(driver.findElement(checkBox2).isSelected())
    	{
    		driver.findElement(checkBox2).click();
    	}
    }
    
    public boolean isBox1Checked()
    {
    	return driver.findElement(checkBox1).isSelected();
    }
    public boolean isBox2Checked()
    {
    	return driver.findElement(checkBox2).isSelected();
    }
    
}

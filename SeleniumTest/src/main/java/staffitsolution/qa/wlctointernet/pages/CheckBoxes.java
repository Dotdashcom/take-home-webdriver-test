package staffitsolution.qa.wlctointernet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxes {
	private WebDriver driver;
	private By chkbox1= By.xpath("//input[@type='checkbox'][last()-1]"); 
	private By chkbox2= By.xpath("//input[@type='checkbox'][last()]"); 
	

	public CheckBoxes(WebDriver driver)
	{
		this.driver=driver;		

}
}

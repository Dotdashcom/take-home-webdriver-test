package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {
	public WebDriver driver;
	By checkBox= By.xpath("//*[@id=\"checkboxes\"]/input[1]");
	By checkBox2=By.xpath("//*[@id=\"checkboxes\"]/input[2]");
	   
	public CheckBoxPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	public WebElement getCheckBox()
	{
		return driver.findElement(checkBox);
	}
	public WebElement getCheckBox2()
	{
		return driver.findElement(checkBox2);
	}
}

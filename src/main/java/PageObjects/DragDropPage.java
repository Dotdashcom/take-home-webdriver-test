package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragDropPage {
	public WebDriver driver;
	By sourceLocator = By.xpath("//*[@id=\'column-a\']");
    By destinationLocator = By.xpath("//*[@id=\'column-b\']");
    
    public DragDropPage (WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
    
    
    public WebElement getSourceLocator()
	{
		return driver.findElement(sourceLocator);
	}
    
    public WebElement getDestinationLocator()
   	{
   		return driver.findElement(destinationLocator);
   	}
	    
}

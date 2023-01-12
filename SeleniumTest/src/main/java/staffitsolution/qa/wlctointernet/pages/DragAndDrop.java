package staffitsolution.qa.wlctointernet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDrop {
	private WebDriver driver;
	By parentMenu= By.xpath("//div[@id='column-a']"); 
	By courseMenu= By.xpath("//div[@id='column-b']");
	
	public DragAndDrop(WebDriver driver)
	{
		this.driver=driver;		
}
}

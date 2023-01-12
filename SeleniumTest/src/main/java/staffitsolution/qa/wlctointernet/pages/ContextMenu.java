package staffitsolution.qa.wlctointernet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenu {

	
	private WebDriver driver;
	private By contextbox= By.xpath("//div[@id='hot-spot']");

	public ContextMenu(WebDriver driver)
	{
		this.driver=driver;		

}
}

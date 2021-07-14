package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC05_dragDropObject{
	public WebDriver driver;
	By dragDropLink = By.xpath("//a[text() = 'Drag and Drop']");
	By box1 = By.xpath("//div[@id='column-a']");
	By box2 = By.xpath("//div[@id='column-b']");
	
	//constructor for giving a life to the driver
	public TC05_dragDropObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getdragDropLink() {
		return driver.findElement(dragDropLink);
	}
	
	public WebElement getbox1() {
		return driver.findElement(box1);
	}
	
	public WebElement getbox2() {
		return driver.findElement(box2);
	}
	
	
}

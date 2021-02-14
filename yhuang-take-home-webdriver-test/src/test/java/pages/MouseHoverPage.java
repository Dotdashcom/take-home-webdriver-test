package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MouseHoverPage extends BaseDriver{
	private Actions actions;
	
	public MouseHoverPage(WebDriver driver){
        super(driver);
        this.actions = new Actions(driver);
    }
	
	@FindBy(css="div.figure")
	public List<WebElement> figures;
	
	public void moveMouseHoverOnImage(int imageIndex) throws InterruptedException {
		actions.moveToElement(figures.get(imageIndex)).build().perform();
		Thread.sleep(3000);
	}
	
	public boolean isAdditionalInformationDisplayed(int imageIndex) {
		List<WebElement> elements = figures.get(imageIndex).findElements(By.xpath(".//div[@class='figcaption']/h5"));
		if(elements.isEmpty())
			return false;
		return elements.get(0).isDisplayed();
	}
	
	public int getNumberOfImages() {
		return figures.size();
	}
}

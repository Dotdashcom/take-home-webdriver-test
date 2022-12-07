package PageObjects;
import Common.Config;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MouseHoverPage extends BasePage {
	@FindBy (css = "#content > div.example > div.figure")
	List <WebElement> imageList;
	WebElement hoveredImage = null;
	public MouseHoverPage (Config testConfig) {
		super(testConfig);
	}
	public void hoverOver(String imageNumber) {
		WebElement image = imageList.get(Integer.valueOf(imageNumber) - 1);
		(new Actions(testConfig.driver)).moveToElement(image).perform();
		hoveredImage = image;
		return;
	}
	public String getDisplayedText() {
		WebDriverWait webDriverWait = new WebDriverWait(this.testConfig.driver, 5);
		webDriverWait.until(ExpectedConditions.visibilityOf(hoveredImage.findElement(By.cssSelector("div > h5"))));
		return hoveredImage.getText();
	}
}

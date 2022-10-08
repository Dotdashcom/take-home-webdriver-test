package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.PageObjectBase;

public class MouseHoverPage extends PageObjectBase{

	public MouseHoverPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public MouseHoverPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public MouseHoverPage hoverPicture(int position) {

		WebElement picture = this.getDriver().findElement(By.xpath("//div[@class='figure'][position()=" + position + "]//img"));

		Actions actions = new Actions(getDriver());
		actions.moveToElement(picture);
		actions.build().perform();

		return this;
	}



	@Override
	protected String getRelativeUrl() {
		return "/hovers";
	}

}

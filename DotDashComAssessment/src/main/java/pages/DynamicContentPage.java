package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class DynamicContentPage extends PageObjectBase{

	public DynamicContentPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DynamicContentPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public String returnFirstParagraph() {

		WebElement paragraph = this.getDriver().findElement(By.xpath("//div[@id='content']/div[@class='row'][position()=1]"));
		String paragraphText = paragraph.getText();

		return paragraphText;
	}

	public DynamicContentPage refreshPage() {

		this.getDriver().navigate().refresh();

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/dynamic_content";
	}

}

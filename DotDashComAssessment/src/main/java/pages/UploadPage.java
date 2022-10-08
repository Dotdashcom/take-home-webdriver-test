package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class UploadPage extends PageObjectBase{

	public UploadPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public UploadPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public UploadPage chooseFile() {

		WebElement fileButton = this.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
		fileButton.sendKeys("/Users/gssiler7/git/take-home-webdriver-test/dotDashAssessment/src/test/resources/empty-file");

		return this;
	}

	public String clickUploadButton() {

		WebElement uploadButton = this.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
		uploadButton.click();

		String confirmation = this.getDriver().findElement(By.xpath("//div[@class='example']")).getText();

		System.out.println(confirmation);

		return confirmation;
	}

	@Override
	protected String getRelativeUrl() {
		return "/upload";
	}

}

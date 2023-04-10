package navpreet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicContentPageObject {

	WebDriver driver;
	Select select;

	public DynamicContentPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']/div[@class='row'][1]/div[@class='large-10 columns']")
	private WebElement first_para;

	@FindBy(xpath = "//div[@id='content']/div[@class='row'][2]/div[@class='large-10 columns']")
	private WebElement second_para;

	@FindBy(xpath = "//div[@id='content']/div[@class='row'][3]/div[@class='large-10 columns']")
	private WebElement third_para;

	@FindBy(xpath = "//a[text()='Dynamic Content']")
	private WebElement click_content;

	public void ClickDynamicContent() {
		click_content.click();
	}

	public void RefreshPage(int count) {
		for (int i = 0; i < count; i++) {
			String first_para_before = first_para.getText();
			String second_para_before = second_para.getText();
			String third_parabefore = third_para.getText();
			driver.navigate().refresh();
			Assert.assertNotEquals(first_para.getText(), first_para_before);
			Assert.assertNotEquals(second_para.getText(), second_para_before);
			Assert.assertNotEquals(third_para.getText(), third_parabefore);
		}
	}

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class DynamicContentPage extends GenericPage {

	@FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
	public WebElement text1;

	@FindBy(xpath = "(//div[@class='large-10 columns'])[2]")
	public WebElement text2;

	public DynamicContentPage() {
		PageFactory.initElements(driver, this);
	}
}
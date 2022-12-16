package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage extends BaseClass {

	@FindBy(xpath = "(//div[@class='figure'])[1]")
	public WebElement picture1;

	@FindBy(xpath = "(//div[@class='figure'])[2]")
	public WebElement picture2;

	@FindBy(xpath = "(//div[@class='figure'])[3]")
	public WebElement picture3;

	public MouseHoverPage() {
		PageFactory.initElements(driver, this);
	}

}
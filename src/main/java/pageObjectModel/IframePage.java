package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IframePage {
	private WebDriver driver;

	public IframePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "iFrame")
	private WebElement iFrameLink;

	@FindBy(how = How.ID, using = "mce_0_ifr")
	private WebElement iFrame;

	@FindBy(how = How.XPATH, using = "//body[@id='tinymce']/p")
	private WebElement textBox;

	public void switchAndText(String text) {
		iFrameLink.click();
		driver.switchTo().frame(iFrame);
		textBox.clear();
		textBox.sendKeys(text);
	}

	public String verifyText() {
		return textBox.getText();
	}

}

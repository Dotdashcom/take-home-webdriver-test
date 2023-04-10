package navpreet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePageObjects {

	WebDriver driver;
	
	public IFramePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Frames']")
	private WebElement click_frames;
	
	@FindBy(xpath = "//a[text()='iFrame']")
	private WebElement click_iframes;
	
	@FindBy(id="mce_0_ifr")
	private WebElement i_frame;

	@FindBy(xpath="//body[@id='tinymce']/p")
	private WebElement text_box;

	public void ClickFrames()
	{
		click_frames.click();
	}
	
	public void ClickIFrames()
	{
		click_iframes.click();
	}
	
	public void SwitchAndTypeText(String text) {
		driver.switchTo().frame(i_frame);
		text_box.clear();
		text_box.sendKeys(text);
	}
	public String verifyText() {
		String i_frame_text=text_box.getText();
		return i_frame_text;
	}
}

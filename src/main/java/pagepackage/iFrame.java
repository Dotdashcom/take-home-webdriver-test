package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class iFrame extends BaseTest {
public iFrame() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//*[@id='mce_0_ifr']")
private static  WebElement iframe;

@FindBy(xpath="//*[@id=\"tinymce\"]/p")
private static WebElement textarea;

public void iframe() {
	driver.switchTo().frame("mce_0_ifr");
	textarea.clear();
	textarea.sendKeys("Shivam");
	textarea.getText().toString();
	Assert.assertEquals(textarea.getText().toString(), "Shivam");
}
}

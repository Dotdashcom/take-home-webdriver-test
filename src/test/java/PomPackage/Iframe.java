package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class Iframe extends BaseClass {
	@FindBy(tagName = "p")
	private WebElement textBox;

	@FindBy(id = "mce_0_ifr")
    private WebElement iframe;

	public  Iframe() {
		PageFactory.initElements(driver, this);
	}

	public String getIframeText() throws InterruptedException {
		
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
        System.out.println(textBox.getText());
        return textBox.getText();
	}

}

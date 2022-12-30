package com.takehome.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {

	WebDriver driver;

	@FindBy(xpath = "//iframe[@id=\"mce_0_ifr\"]")
	WebElement iFrame;
	@FindBy(xpath = "/html/body/div[4]/div/div/button")
	WebElement notificationDisposeButton;
	@FindBy(xpath = "//*[@id=\"tinymce\"]/p")
	WebElement editor;

	public IFramePage(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "iframe";
		driver.get(url);
		PageFactory.initElements(driver, this);
	}

	public WebElement getIFrame() {
		return iFrame;
	}

	public WebElement getNotificationDisposeButton() {
		return notificationDisposeButton;
	}

	public WebElement getEditor() {
		return editor;
	}

	public void clearEditorContent() {

		
		String currentOperatingSystem = System.getProperty("os.name");
		if (currentOperatingSystem.contains("Mac")) {
			editor.sendKeys(Keys.chord(Keys.COMMAND, "a"));
			editor.sendKeys(Keys.DELETE);
		} else {
			// This is for Windows
			editor.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			editor.sendKeys(Keys.DELETE);
		}

	}

	public void writeContenttoEditor(String text) {
		
		editor.sendKeys(text);
	}

	public String readContentFromEditor() {
	
		return editor.getText();
	}
	
}

package com.tjank.PageObjectModel;


import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NotificationMessagePage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public NotificationMessagePage() {
		this.URL = this.URL.concat("/notification_message_rendered");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[text()='Click here']")
	public WebElement notificationLink;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Notification Message']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void clickLink() {
		notificationLink.click();
	}
	
	public void verifyNotificationMessage() {
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flash']")));
		String[] messages = {"Action unsuccesful, please try again","Action successful"};
		WebElement el = driver.findElement(By.xpath("//*[@id='flash']"));
		for(String mes: messages) {
			System.out.println(el.getText().replace("×", "").trim() + " " + mes);
			if(el.getText().replace("×", "").trim().equals(mes)) {
				Assert.assertEquals(el.getText().replace("×", "").trim(),mes);
				break;
			}
		}
		Assert.fail();
	}
}

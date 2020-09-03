package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.BaseClass;

public class NotifictionMessage extends BaseClass{

	public static void main(String[] args) {
		setUp("notification_message_rendered");
		
		WebElement ClickHere= driver.findElement(By.xpath("//a[text()='Click here']"));
		ClickHere.click();
		
		WebElement Notification= driver.findElement(By.xpath("//div[@id='flash']"));
		System.out.println(Notification.getText());
		driver.quit();
	}
}

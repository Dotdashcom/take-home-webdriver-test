package com.selenium.tests;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends TestBase {

	@Test
	public void downloadFile() {

		String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
		driver.get("http://localhost:7080/download");

		WebElement link = driver.findElement(By.cssSelector("#content a"));
		String filename = link.getText();
		link.click();

		FluentWait<String> wait = new FluentWait<>(filename);
		wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));

		boolean isDownloaded = wait.until(new Function<String, Boolean>() {
			@Override
			public Boolean apply(String fileName) {
				Boolean exist = false;

				File dir = new File(downloadPath);
				File[] dir_contents = dir.listFiles();

				for (int i = 0; i < dir_contents.length; i++) {
					if (dir_contents[i].getName().contains(fileName))
						exist = true;
				}
				return exist;
			}
		});
		
		Assert.assertTrue(isDownloaded);
	}
}
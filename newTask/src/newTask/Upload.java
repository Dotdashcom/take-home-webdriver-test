package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.BaseClass;

public class Upload extends BaseClass {

	public static void main(String[] args) {
		setUp("upload");
		WebElement chooseFile= driver.findElement(By.id("file-upload"));
		chooseFile.sendKeys("/home/nazarov/Downloads");
		
		WebElement submit= driver.findElement(By.id("file-submit"));
		submit.click();
	}
}

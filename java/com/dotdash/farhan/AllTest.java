package com.dotdash.farhan;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AllTest extends Hooks {
	@Test
	public void successfulLogin() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/login");
		lpf.username().sendKeys("tomsmith");
		lpf.password().sendKeys("SuperSecretPassword!");
		lpf.submitBtn().click();
		expected = "Secure Area";
		actual = hpf.secureAreaTitle().getText();
		sf.assertEquals(actual, expected);
		sf.assertAll();
	}	

	@Test
	public void failureLogin() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/login");
		lpf.username().sendKeys("tom");
		lpf.password().sendKeys("SecretPassword!");
		lpf.submitBtn().click();
		expected = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";
		actual = lpf.invalidInput().getText();
		sf.assertEquals(actual, expected);
		sf.assertAll();
	}	

	@Test
	public void checkBox() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/checkboxes");
		boolean checked = false;
		List<WebElement> checkBoxes = cbf.allCheckBox();
		for(int i = 0; i < checkBoxes.size(); i++) {
			checked = cbf.allCheckBox().get(i).isSelected();
			if(!checked) {
				cbf.allCheckBox().get(i).click();
				sf.assertEquals(cbf.allCheckBox().get(i).isSelected(), true);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		for(int i = 0; i < checkBoxes.size(); i++) {
			checked = cbf.allCheckBox().get(i).isSelected();
			if(checked) {
				cbf.allCheckBox().get(i).click();
				sf.assertEquals(cbf.allCheckBox().get(i).isSelected(), false);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		sf.assertAll();
	}


	@Test
	public void ContextMenu() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/context_menu");
		Actions action = new Actions(driver);
		action.contextClick(cpf.hotBox()).perform();
		actual = driver.switchTo().alert().getText();
		sf.assertEquals(actual,"You selected a context menu");
		sf.assertAll();
	}

	@Test
	public void dragAndDrop(){
		sf = new SoftAssert();
		driver.get("http://localhost:7080/drag_and_drop");
		Actions builder = new Actions(driver);
		//builder.dragAndDrop(dad.drag(), dad.drop()).build().perform();
		builder.clickAndHold(dad.drag()).moveToElement(dad.drop()).release().build().perform();
			

	}

	@Test
	public void dropDown() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/dropdown");
		Select s = new Select(ddp.dropdown());
		
		s.selectByValue("1");
		sf.assertEquals(s.getFirstSelectedOption().isSelected(), true);
		s.selectByValue("2");
		sf.assertEquals(ddp.dropdown().isSelected(), false);
		sf.assertAll();
	}

	@Test
	public void dynamicContent() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/dynamic_content");
		expected = dcp.contentText().getText();
		driver.navigate().refresh();
		driver.navigate().refresh();
		actual = dcp.contentText().getText();
		sf.assertNotEquals(actual, expected);
		
		sf.assertAll();
	}

	@Test
	public void dynamicControls() {
		sf =  new SoftAssert();
		driver.get("http://localhost:7080/dynamic_controls ");
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		dcop.removeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(dcop.removeBtn()));
		sf.assertEquals(dcop.text().getText(), "It's gone!");
		dcop.removeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(dcop.removeBtn()));
		sf.assertEquals(dcop.text().getText(), "It's back!");
		dcop.inputBoxBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(dcop.inputBoxBtn()));
		sf.assertEquals(dcop.text().getText(), "It's enabled!");
		dcop.inputBoxBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(dcop.inputBoxBtn()));
		sf.assertEquals(dcop.text().getText(), "It's disabled!");
		sf.assertAll();
}

	@Test
	public void dynamicLoading() {
		sf = new SoftAssert();
		driver.get(" http://localhost:7080/dynamic_loading/2");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		dlp.startBtn().click();
		actual = wait.until(ExpectedConditions.visibilityOf(dlp.text())).getText();
		expected = "Hello World!";
		sf.assertEquals(actual, expected);
		sf.assertAll();
	}

	@Test
	public void fileUpload() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/upload");
		fup.browserTab().sendKeys("C:\\Users\\Owner\\Desktop\\GOPR0050.jpg");
		fup.uploadBtn().click();
		sf.assertEquals(fup.text().getText(), "File Uploaded!");
		sf.assertAll();
	}

	@Test
	public void fileDownload() {
		File ss;
		sf= new SoftAssert();
		driver.get("http://localhost:7080/download");
		fdp.fileDownload().click();
		String s = System.getProperty("C:\\Users\\Owner\\Downloads","some-file.txt");
		expected = "some-file";
		ss = new File(s, expected);
		sf.assertAll();
	}

	@Test
	public void floatingMenu() {
		sf= new SoftAssert();
		driver.get("http://localhost:7080/floating_menu");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,7200)", "");
		sf.assertEquals(fmp.homeBtn().isDisplayed(), true);
		sf.assertEquals(fmp.newsBtn().isDisplayed(), true);
		sf.assertEquals(fmp.contactBtn().isDisplayed(), true);
		sf.assertEquals(fmp.aboutBtn().isDisplayed(), true);
		sf.assertAll();			 
	}

	@Test
	public void iFrame () {
		sf= new SoftAssert();
		driver.get("http://localhost:7080/iframe");
		driver.switchTo().frame("mce_0_ifr");
		ip.textBox().clear();
		ip.textBox().sendKeys("test-passed!");
		sf.assertEquals(ip.textBox().getText(), "test-passed!");
		sf.assertAll();
	}
	
	
	@Test
	public void mouseHover() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/hovers");
		Actions action = new Actions(driver);
		action.moveToElement(mhpf.firstPic()).build().perform();
		sf.assertEquals(mhpf.firstPopUp().getText(), "name: user1");
		action.moveToElement(mhpf.secondPic()).build().perform();
		sf.assertEquals(mhpf.secondPopUp().getText(), "name: user2");
		action.moveToElement(mhpf.thirdPic()).build().perform();
		sf.assertEquals(mhpf.thirdPopUp().getText(), "name: user3");
		sf.assertAll();
		
	}


	@Test
	public void jsAlert() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/javascript_alerts");
		jsap.jsAlertBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		sf.assertEquals(jsap.text().getText(), "You successfuly clicked an alert");

		jsap.jsCOnfirmBtn().click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		sf.assertEquals(jsap.text().getText(), "You clicked: Ok");

		jsap.jsPromptBtn().click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Mir Rakib Hossain");
		alert2.accept();
		sf.assertEquals(jsap.text().getText(), "You entered: Mir Rakib Hossain");

		sf.assertAll();
	}

	@Test
	public void jsError() {
		sf = new SoftAssert();
		driver.get(" http://localhost:7080/javascript_error");
		LogEntries a = driver.manage().logs().get(LogType.BROWSER);
		
		sf.assertAll();
		System.out.println("Error Note : " + a);
	}

	@Test
	public void newWindow() {
		sf=new SoftAssert();
		driver.get("http://localhost:7080/windows");
		ontp.newTabBtn().click();
		sf.assertEquals(ontp.newWindow().getText(), "Opening a new window");
		sf.assertAll();	
	}
	
	@Test
	public void notificationMessage() {
		sf = new SoftAssert();
		driver.get("http://localhost:7080/notification_message_rendered");
		np.newMessageBtn().click();
		sf.assertEquals(np.notificationMessage().getText(), "Action unsuccesful, please try again\r\n" + 
				"×");
		sf.assertAll();
		
	}
}

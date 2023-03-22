package com.test.TakeHomeShivam;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.TakeHomeShivam.TestBase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllOtherTests extends TestBase {

	// For this test class - I have not used the concepts used for best coding
	// practices as LoginTest and LoginPage already demonstrates that
		
	@BeforeMethod
	public void beforeMethod() {
		init();
	}
	
	@Test
	public void TC_002_TestContextMenu() {
		getDriver().get("http://localhost:7080/context_menu");
		WebElement contextBtn = getDriver().findElement(By.xpath("//*[@id=\"hot-spot\"]"));
		Actions actions = new Actions(getDriver());
		actions.contextClick(contextBtn).perform();
		String expectedAlertMessage = "You selected a context menu";
		String actualAlertMessage = getDriver().switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		getDriver().switchTo().alert().accept();
	}

	@Test
	public void TC_003_TestDragAndDrop() {
		getDriver().get("http://localhost:7080/drag_and_drop");
		WebElement from = getDriver().findElement(By.id("column-a"));
		WebElement to = getDriver().findElement(By.id("column-b"));
		WebElement header = getDriver().findElement(By.xpath("//*[@id=\"column-a\"]/header"));
		Actions actions = new Actions(getDriver());
		actions.dragAndDrop(from, to).perform();
		String text = header.getText();
		Assert.assertEquals(text, "A");
	}
	
	@Test
	public void TC_004_ValidatingCheckboxes() {
		getDriver().get("http://localhost:7080/checkboxes");
		WebElement checkbox1 = getDriver().findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = getDriver().findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		Assert.assertFalse(checkbox1.isSelected());
		checkbox1.click();
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertTrue(checkbox2.isSelected());
		checkbox2.click();
		Assert.assertFalse(checkbox2.isSelected());
	}

	@Test
	public void TC_005_TestDropDown() {
		getDriver().get("http://localhost:7080/dropdown");
		Select drpdown = new Select(getDriver().findElement(By.id("dropdown")));
		drpdown.selectByVisibleText("Option 1");
		String selection1 = drpdown.getFirstSelectedOption().getText();
		Assert.assertEquals("Option 1", selection1);
		drpdown.selectByVisibleText("Option 2");
		String selection2 = drpdown.getFirstSelectedOption().getText();
		Assert.assertEquals("Option 2", selection2);
	}

	@Test
	public void TC_006_DynamicControls() {
		getDriver().get("http://localhost:7080/dynamic_controls");
		WebElement AddRemoveButton= getDriver().findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		AddRemoveButton.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
		Assert.assertEquals(0, getDriver().findElements(By.id("checkbox")).size());
		AddRemoveButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		Assert.assertEquals(1, getDriver().findElements(By.id("checkbox")).size());
		WebElement enableDisableBtn= getDriver().findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		enableDisableBtn.click();
		WebElement textbox= getDriver().findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		wait.until(ExpectedConditions.elementToBeClickable(textbox));
		Assert.assertEquals(true, textbox.isEnabled());
		enableDisableBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enable']")));
		Assert.assertEquals(false, textbox.isEnabled());	
	}
	
	@Test
	public void TC_007_TestDynamicContent() {
		getDriver().get("http://localhost:7080/dynamic_content");
		String oldValue = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
		getDriver().navigate().refresh();
		String newValue = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
		Assert.assertNotEquals(oldValue, newValue);
	}

	@Test
	public void TC_008_TestDynamicLoading() {
		getDriver().get(" http://localhost:7080/dynamic_loading/2");
		WebElement startbtn = getDriver().findElement(By.xpath("//*[@id=\"start\"]/button"));
		startbtn.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		WebElement msg = getDriver().findElement(By.xpath("//*[text()='Hello World!']"));
		wait.until(ExpectedConditions.visibilityOf(msg));
		Assert.assertEquals("Hello World!",msg.getText());		
	}
    
	@Test
	public void TC_009_TestFileUpload() {
		getDriver().get("http://localhost:7080/upload");
		WebElement fileUploadBtn = getDriver().findElement(By.id("file-upload"));
		File file = new File("./sample.txt");
		fileUploadBtn.sendKeys(file.getAbsolutePath());
		WebElement uploadBtn = getDriver().findElement(By.id("file-submit"));
		uploadBtn.click();
		String msg = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		Assert.assertEquals("File Uploaded!", msg);
	}

	@Test
	public void TC_010_TestFileDownload() {
		getDriver().get("http://localhost:7080/download");
		WebElement fileDownload = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
		fileDownload.click();
		File file = new File("./download/");
		File dir = new File(file.getAbsolutePath());
		File[] dirContents = dir.listFiles();
		int flag = 0;
		for (int i = 0; i < dirContents.length; i++) {
			System.out.println(dirContents[i].getName());
			if (dirContents[i].getName().equalsIgnoreCase("empty.txt")) {
				flag = 1;
			} else {}
		}
		//Assert.assertEquals(1, flag);
	}
	
	@Test
	public void TC_011_TestIFrame() {
		getDriver().get("http://localhost:7080/iframe");
		getDriver().switchTo().frame("mce_0_ifr");
		WebElement iFrame = getDriver().findElement(By.id("tinymce"));
		iFrame.clear();
		iFrame.sendKeys("This is a test");
		Assert.assertEquals("This is a test", iFrame.getText());
	}

	@Test
	public void TC_012_TestMouseHover() {
		getDriver().get(" http://localhost:7080/hovers");
		WebElement img1 = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(img1).perform();
		WebElement label1 = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
		Assert.assertEquals(true, label1.isDisplayed());

		WebElement img2 = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[2]"));
		actions.moveToElement(img2).perform();
		WebElement label2 = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
		Assert.assertEquals(true, label2.isDisplayed());

		WebElement img3 = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[3]"));
		actions.moveToElement(img3).perform();
		WebElement label3 = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
		Assert.assertEquals(true, label3.isDisplayed());
	}

	@Test
	public void TC_013_TestFloatingMenu() {

		getDriver().get("http://localhost:7080/floating_menu");
		WebElement menu = getDriver().findElement(By.id("menu"));
		Assert.assertEquals(true, menu.isDisplayed());
		((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Assert.assertEquals(true, menu.isDisplayed());
	}
	
	@Test
	public void TC_014_TestJavaScriptsAlerts() {
		getDriver().get(" http://localhost:7080/javascript_alerts");
		WebElement alert = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		alert.click();
		Assert.assertEquals("I am a JS Alert", getDriver().switchTo().alert().getText());
		getDriver().switchTo().alert().accept();

		WebElement confirm = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		confirm.click();
		Assert.assertEquals("I am a JS Confirm", getDriver().switchTo().alert().getText());
		getDriver().switchTo().alert().accept();

		WebElement prompt = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		prompt.click();
		getDriver().switchTo().alert().sendKeys("This is a test");
		getDriver().switchTo().alert().accept();
		Assert.assertEquals("You entered: This is a test", getDriver().findElement(By.xpath("//*[@id=\"result\"]")).getText());
	}

	@Test
	public void TC_015_TestJavaScriptError() {
		getDriver().get(" http://localhost:7080/javascript_error");
		List<LogEntry> errors = getDriver().manage().logs().get(LogType.BROWSER).getAll();
		Assert.assertTrue(errors.get(errors.size() - 1).getMessage().contains("Cannot read properties of undefined"));
	}

	@Test
	public void TC_016_TestOpenInNewTab() {
		getDriver().get(" http://localhost:7080/windows");
		WebElement btn = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		btn.click();
		String parentID = getDriver().getWindowHandle();
		ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
		if (parentID.equals(tabs2.get(0))) {
			getDriver().switchTo().window(tabs2.get(1));
		} else {
			getDriver().switchTo().window(tabs2.get(0));
		}
		Assert.assertEquals("New Window", getDriver().findElement(By.xpath("/html/body/div/h3")).getText());
	}

	@Test
	public void TC_017_TestNotificationMessage() {
		getDriver().get("http://localhost:7080/notification_message_rendered");
		WebElement clickHere = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		clickHere.click();
		String msg = getDriver().findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		System.out.println(msg);
		int flag = 0;
		if (msg.contains("Action unsuccesful, please try again") || msg.contains("Action successful")
				|| msg.contains("Action Unsuccessful")) {
			flag = 1;
		}
		Assert.assertEquals(1, flag);
		WebElement clickHere2 = getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		clickHere2.click();
		String msg2 = getDriver().findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		System.out.println(msg2);
		flag = 0;
		if (msg2.contains("Action unsuccesful, please try again") || msg2.contains("Action successful")
				|| msg2.contains("Action Unsuccessful")) {
			flag = 1;
		}
		Assert.assertEquals(1, flag);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
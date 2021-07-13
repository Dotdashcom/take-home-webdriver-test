	package com.selenium.test.stepdefinitions;
	
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.net.URL;
	import java.time.Duration;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	
	import org.junit.Assert;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.interactions.touch.TouchActions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	import com.google.common.io.Resources;
	import com.selenium.entity.DataSingleton;
	import com.selenium.test.util.LocalConfUtils;
	
	public class StepMethod {
	
		final static DataSingleton singleton = DataSingleton.getInstance();
		public static WebDriver driver;
	
		public static void loginSuccess(String url) {
	
			driver = singleton.getWebDriver();
	
			driver.navigate().to(url);
			driver.manage().window().maximize();
	
		}
	
		public static void EnterUser(String user) {
			driver.findElement(By.xpath(LocalConfUtils.getProperty("user"))).sendKeys(user);
	
		}
	
		public static void EnterPassword(String password) {
			driver.findElement(By.xpath(LocalConfUtils.getProperty("password"))).sendKeys(password);
	
		}
	
		public static void ClickLogin() {
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("login"))).click();
	
		}
	
		public static void ValidateLogin() {
	
			Assert.assertTrue("Login is not successful", driver
					.findElement(By.xpath(LocalConfUtils.getProperty("successlogin"))).getText().equals("Secure Area"));
		}
	
		public static void FailedLogin(String message) {
	
			System.out
			.println("TEXT : " + driver.findElement(By.xpath(LocalConfUtils.getProperty("failedlogin"))).getText());
			Assert.assertTrue("Error while login with Incorrect UserName/Password",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("failedlogin"))).getText().contains(message));
	
		}
	
		public static void CheckBox() {
	
			WebElement checkBox1 = driver.findElement(By.xpath(LocalConfUtils.getProperty("checkbox1")));
			WebElement checkBox2 = driver.findElement(By.xpath(LocalConfUtils.getProperty("checkbox2")));
	
			checkBox1.click();
			checkBox2.click();
	
			Assert.assertTrue("CheckBox One is not checked", checkBox1.isSelected());
			Assert.assertTrue("CheckBox Two is not checked", !checkBox2.isSelected());
	
		}
	
		public static void ContextMenu() {
	
			Actions action = new Actions(driver);
			action.contextClick(driver.findElement(By.xpath(LocalConfUtils.getProperty("contextmenu")))).build().perform();
			Assert.assertTrue("Context Menu text is not correct",
					driver.switchTo().alert().getText().contains("You selected a context menu"));
			driver.switchTo().alert().accept();
	
		}
	
		public static void DragAndDrop() throws InterruptedException {
	
			Actions action = new Actions(driver);
	
			WebElement a = driver.findElement(By.xpath(LocalConfUtils.getProperty("draga")));
			WebElement b = driver.findElement(By.xpath(LocalConfUtils.getProperty("dragb")));
	
			final String java_script = "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe"
					+ "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun"
					+ "ction(format,data){this.items[format]=data;this.types.append(for"
					+ "mat);},getData:function(format){return this.items[format];},clea"
					+ "rData:function(format){}};var emit=function(event,target){var ev"
					+ "t=document.createEvent('Event');evt.initEvent(event,true,false);"
					+ "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('"
					+ "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit("
					+ "'drop',tgt);emit('dragend',src);";
	
			((JavascriptExecutor) driver).executeScript(java_script, a, b);
			Thread.sleep(30);
	
			Assert.assertTrue("Drag and Drop Text is not as expected",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("draga"))).getText().equals("B"));
			Assert.assertTrue("Drag and Drop Text is not as expected",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("dragb"))).getText().equals("A"));
	
		}
	
		public static void DropDown() {
			Select dropdown;
			dropdown = new Select(driver.findElement(By.xpath(LocalConfUtils.getProperty("dropdown"))));
			dropdown.selectByIndex(1);
			Assert.assertTrue("Option1 is not selected", dropdown.getFirstSelectedOption().getText().equals("Option 1"));
			dropdown.selectByIndex(2);
			Assert.assertTrue("Option2 is not selected", dropdown.getFirstSelectedOption().getText().equals("Option 2"));
	
		}
	
		public static void ContentChange() {
	
			String testOld = driver.findElement(By.xpath(LocalConfUtils.getProperty("dynamiccontent"))).getText();
			String testNew;
			for (int i = 1; i <= 10; i++) {
	
				driver.navigate().refresh();
				testNew = driver.findElement(By.xpath(LocalConfUtils.getProperty("dynamiccontent"))).getText();
				if (testOld.trim().equals(testNew.trim())) {
	
					Assert.assertTrue("Page is not refreshed", false);
	
				} else {
	
					testOld = testNew;
				}
	
			}
	
		}
	
		public static void DynamicControl() {
	
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.findElement(By.xpath(LocalConfUtils.getProperty("removeaddbutton"))).click();
			Assert.assertTrue("Remove Button didn't work",
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(LocalConfUtils.getProperty("removeaddbuttontext"))))
					.getText().equals("It's gone!"));
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("removeaddbutton"))).click();
			Assert.assertTrue("Add Button didn't work",
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(LocalConfUtils.getProperty("removeaddbuttontext"))))
					.getText().equals("It's back!"));
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("enabledisablebutton"))).click();
			Assert.assertTrue("Remove Button didn't work",
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(LocalConfUtils.getProperty("enabledisablebuttontext"))))
					.getText().equals("It's enabled!"));
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("enabledisablebutton"))).click();
			Assert.assertTrue("Add Button didn't work",
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(LocalConfUtils.getProperty("enabledisablebuttontext"))))
					.getText().equals("It's disabled!"));
	
		}
	
		public static void DynamicLoading() {
	
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.findElement(By.xpath(LocalConfUtils.getProperty("startbutton"))).click();
			Assert.assertTrue("Start Button didn't work",
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(LocalConfUtils.getProperty("startbuttontext")))).getText()
					.equals("Hello World!"));
	
		}
	
		public static void FileDownlaod() {
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("filedownload"))).click();
			try {
				Thread.sleep(20 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String home = System.getProperty("user.home");
			File file = new File(home + "/Downloads/" + "some-file.txt");
			Assert.assertTrue("File is not downloaded ", file.exists());
	
		}
	
		public static void FileUpload() {
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("fileupload")))
			.sendKeys(System.getProperty("user.dir") + "/src/test/resources/abc.txt");
	
		}
	
		public static void IFrame() {
			driver.switchTo().frame(0);
			driver.findElement(By.xpath(LocalConfUtils.getProperty("iframe"))).clear();
			driver.findElement(By.xpath(LocalConfUtils.getProperty("iframe"))).sendKeys("abc");
			Assert.assertTrue("Typed txt is not as expected",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("iframe"))).getText().equals("abc"));
		}
	
		public static void MouseHover() throws InterruptedException {
	
			Actions action = new Actions(driver);
	
			action.moveToElement(driver.findElement(By.xpath(LocalConfUtils.getProperty("hover1")))).perform();
			Thread.sleep(10);
			Assert.assertTrue("Mouse Hover is not successful",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("hovertext1"))).getText().equals("name: user1"));
	
			action.moveToElement(driver.findElement(By.xpath(LocalConfUtils.getProperty("hover2")))).perform();
			Thread.sleep(10);
			Assert.assertTrue("Mouse Hover is not successful",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("hovertext2"))).getText().equals("name: user2"));
	
			action.moveToElement(driver.findElement(By.xpath(LocalConfUtils.getProperty("hover3")))).perform();
			Thread.sleep(10);
			Assert.assertTrue("Mouse Hover is not successful",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("hovertext3"))).getText().equals("name: user3"));
	
		}
	
		public static void JavaScriptAlert() {
	
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.findElement(By.xpath(LocalConfUtils.getProperty("js1"))).click();
			Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
			String text1 = alert1.getText();
			alert1.accept();
			Assert.assertTrue("Alert text is not as expected", text1.equals("I am a JS Alert"));
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("js2"))).click();
			Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
			String text2 = alert2.getText();
			alert2.accept();
			Assert.assertTrue("Alert text is not as expected", text2.equals("I am a JS Confirm"));
	
			/*
			 * driver.findElement(By.xpath(LocalConfUtils.getProperty("js3"))).click();
			 * Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
			 * alert3.sendKeys("abc"); String text3 = alert3.getText(); alert3.accept();
			 * Assert.assertTrue("Alert text is not as expected", text3.equals("abc"));
			 */
			 
	
		}
	
		public static void NewWindow() throws InterruptedException {
	
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
			driver.findElement(By.linkText("Click Here")).sendKeys(selectLinkOpeninNewTab);
			Thread.sleep(10);
			Set<String> windows = driver.getWindowHandles();
			Iterator I1 = windows.iterator();
			while (I1.hasNext()) {
	
				driver.switchTo().window(I1.next().toString());
			}
			Assert.assertTrue("New Tab doesn't work",
					driver.findElement(By.xpath(LocalConfUtils.getProperty("newtab"))).getText().equals("New Window"));
	
		}
	
		public static void NotificationMessage() {
	
			driver.findElement(By.xpath(LocalConfUtils.getProperty("notification"))).click();
	
			while (!driver.findElement(By.xpath(LocalConfUtils.getProperty("notificationmsg"))).getText().trim()
					.contains("Action successful")) {
	
				driver.findElement(By.xpath(LocalConfUtils.getProperty("notification"))).click();
	
			}
	
		}

		public static void FloatingMenu() {
			
			Assert.assertTrue("Floating menu is not visible", driver.findElement(By.xpath(LocalConfUtils.getProperty("float"))).getText().trim()
					.equals("Home"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			Assert.assertTrue("Floating menu is not visible", driver.findElement(By.xpath(LocalConfUtils.getProperty("float"))).getText().trim()
					.equals("Home"));
			js.executeScript("window.scrollBy(0,1000)");
			Assert.assertTrue("Floating menu is not visible", driver.findElement(By.xpath(LocalConfUtils.getProperty("float"))).getText().trim()
					.equals("Home"));
			
			
			
			
		}

		public static void JavaScriptError() throws InterruptedException {
			
			Thread.sleep(10);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			Assert.assertTrue("JS error test is not as expected", driver.findElement(By.xpath(LocalConfUtils.getProperty("jserror"))).getText().trim().equals("This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques."));
			
		}
	
	}

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class webdriverTest {

	public WebDriver _webDriver;

	public webdriverTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\D backup\\DockerPrac\\chromedriver.exe");
		_webDriver = new ChromeDriver();
	}

	@BeforeEach
	public void setUp() {
		// _webDriver.manage().window().maximize();
	}

	@BeforeEach
	public void tearDown() {
		// _webDriver.quit();
	}

	@Test
	public void Login_Success() {

		// Navigate to URL
		String url = "http://localhost:7080/login";
		_webDriver.get(url);
		// Enter Username
		WebElement href = _webDriver.findElement(By.xpath("//input[@id='username']"));
		WebElement username = _webDriver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("tomsmith");
		// Enter Password
		WebElement password = _webDriver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("SuperSecretPassword!");
		// Click on Login button
		WebElement button = _webDriver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		// Verify text after Login
		_webDriver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]"));
		// Close the Website
		_webDriver.quit();

	}

	@Test
	public void Login_Failure() {
		// Navigate to URL
		String url = "http://localhost:7080/login";
		_webDriver.get(url);
		// Enter Username
		WebElement href = _webDriver.findElement(By.xpath("//input[@id='username']"));
		WebElement username = _webDriver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("tomsmith");
		// Enter Password
		WebElement password = _webDriver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("SecretPassword!");
		// Click on Login button
		WebElement button = _webDriver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		// Verify text for invalid login
		_webDriver.findElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
		// Quit the browser
		_webDriver.quit();

	}

	@Test
	public void Check_Boxes() {
		// Navigate to URL
		String url = "http://localhost:7080/checkboxes";
		_webDriver.get(url);

		// for all checked checkboxes
		_webDriver.findElements(By.cssSelector("input:checked[type='checkboxs']"));
		// for all notchecked checkboxes
		_webDriver.findElements(By.cssSelector("input:not(:checked)[type='checkbox']"));

		// Quit the browser
		_webDriver.quit();

	}

	@Test
	public void Context_Menu() {

		_webDriver.get("http://localhost:7080/context_menu");
		WebElement box = _webDriver.findElement(By.id("hot-spot"));
		Actions actions = new Actions(_webDriver);
		actions.contextClick(box).perform();
		Alert alert = _webDriver.switchTo().alert();
		Assert.assertTrue((alert.getText()).equals("You selected a context menu"));

		// Quit the browser
		_webDriver.quit();
	}

	@Test
	public void Drag_Drop() {

		_webDriver.get("http://localhost:7080/drag_and_drop");
		WebElement boxA = _webDriver.findElement(By.id("column-a"));
		WebElement boxB = _webDriver.findElement(By.id("column-b"));
		Actions actions = new Actions(_webDriver);

		String actualMessage = _webDriver.findElement(By.id("column-b")).getText().trim();
		String expectedMessage = "B";
		Assert.assertEquals(actualMessage, expectedMessage);
		actions.dragAndDrop(boxA, boxB).perform();
		boxB = _webDriver.findElement(By.id("column-a"));
		String actualAfterDragAndDrop = _webDriver.findElement(By.id("column-a")).getText().trim();
		String expectedAfterDragAndDrop = "A";
		Assert.assertEquals(actualAfterDragAndDrop, expectedAfterDragAndDrop);
		_webDriver.quit();
	}

	@Test
	public void Drop_Down() {
		_webDriver.get("http://localhost:7080/dropdown");
		WebElement dropBox = _webDriver.findElement(By.xpath("//select[@id='dropdown']"));
		Select select = new Select(dropBox);
		select.selectByValue("1");
		WebElement option1 = _webDriver.findElement(By.xpath("//option[@value='1']"));
		Assert.assertTrue(option1.isSelected());
		String actual = option1.getText();
		String expected = "Option 1";
		Assert.assertEquals(actual, expected);

		select.selectByValue("2");
		WebElement option2 = _webDriver.findElement(By.xpath("//option[@value='2']"));
		Assert.assertTrue(option2.isSelected());
		String actual1 = option2.getText();
		String expected1 = "Option 2";
		Assert.assertEquals(actual1, expected1);
		_webDriver.quit();
	}

	@Test
	public void Dynamic_Text() {
		_webDriver.get("http://localhost:7080/dynamic_content ");
		List<String> expected = new ArrayList<>();
		List<WebElement> texts = _webDriver.findElements(By.xpath("//div[@class=\"large-10 columns\"]"));
		for (int i = 0; i < texts.size(); i++) {
			expected.add(texts.get(i).getText());
		}
		_webDriver.navigate().refresh();
		_webDriver.navigate().refresh();

		texts = _webDriver.findElements(By.xpath("//div[@class=\"large-10 columns\"]"));

		List<String> actual = new ArrayList<>();
		for (int i = 0; i < texts.size(); i++) {
			actual.add(texts.get(i).getText());

		}
		Assert.assertNotEquals(actual, expected);
		_webDriver.quit();
	}

	@Test
	public void Dynamic_LOading() throws InterruptedException {
		_webDriver.get("http://localhost:7080/dynamic_loading/2");
		WebElement startButton = _webDriver.findElement(By.xpath("//button"));
		startButton.click();
		WebDriverWait wait = new WebDriverWait(_webDriver, Duration.ofSeconds(10));
		Assert.assertTrue(wait
				.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='finish']//h4")))).getText().equals("Hello World!"));
		_webDriver.quit();

	}

	@Test
	public void File_Upload_Validation() {
		_webDriver.get("http://localhost:7080/upload");

		WebElement chooseFile = _webDriver.findElement(By.id("file-upload"));
		chooseFile.sendKeys("C:\\D backup\\DockerPrac\\usa.png");
		WebElement uploadButton = _webDriver.findElement(By.id("file-submit"));
		uploadButton.click();
		WebElement text = _webDriver.findElement(By.xpath("//h3"));
		String actualText = text.getText();
		String expectedText = "File Uploaded!";
		Assert.assertEquals(actualText, expectedText);
		_webDriver.quit();
	}

	@Test
	public void Scroll_View() {
		_webDriver.get("http://localhost:7080/floating_menu ");
		WebElement text = _webDriver.findElement(By.xpath("//div[@class='scroll large-10 columns large-centered']"));
		JavascriptExecutor js = (JavascriptExecutor) _webDriver;
	    js.executeScript("arguments[0].scrollIntoView(true)",text);
		Assert.assertTrue(text.isDisplayed());
		_webDriver.quit();
	}

	@Test
	public void iFrame() {

		_webDriver.get("http://localhost:7080/iframe");
		_webDriver.switchTo().frame("mce_0_ifr");
		WebElement message = _webDriver.findElement(By.xpath("//body[@id='tinymce']"));
		String actualMessage = message.getText().trim();
		String expectedMessage = "Your content goes here.";
		Assert.assertEquals(actualMessage, expectedMessage);
		_webDriver.quit();
	}

	@Test
	public void Hover_Over() throws InterruptedException {

		_webDriver.get("http://localhost:7080/hovers");

		List<WebElement> allNames = _webDriver.findElements(By.tagName("h5"));
		List<WebElement> allPictures = _webDriver.findElements(By.xpath("//div[@class='figure']/img"));
		List<String> expectedName = Arrays.asList("name: user1", "name: user2", "name: user3");
		List<String> actualName = new ArrayList<>();
		Actions actions = new Actions(_webDriver);
		for (int i = 0; i < allNames.size(); i++) {
			actions.moveToElement(allPictures.get(i)).perform();
			Thread.sleep(3000);
			actualName.add(allNames.get(i).getText());

		}
		Assert.assertEquals(actualName, expectedName);
		_webDriver.quit();
	}

	@Test
	public void Alert_Get_Text() {
		_webDriver.manage().window().maximize();
		_webDriver.get("http://localhost:7080/javascript_alerts");

		WebElement jsAlert = _webDriver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
		jsAlert.click();
		Alert alert = _webDriver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "I am a JS Alert";
		Assert.assertEquals(actualMessage, expectedMessage);
		alert.accept();
		String oldtab = _webDriver.getWindowHandle();
		_webDriver.switchTo().window(oldtab);
		Assert.assertTrue(_webDriver.findElement(By.xpath("//p[@id='result']")).getText().equals("You successfully clicked an alert"));
		_webDriver.quit();
	}

	@Test
	public void Alert_Dismiss() {
		_webDriver.get("http://localhost:7080/javascript_alerts");
		WebElement jsConfirm = _webDriver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
		jsConfirm.click();
		Alert alert = _webDriver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "I am a JS Confirm";
		Assert.assertEquals(actualMessage, expectedMessage);
		alert.dismiss();
		Assert.assertTrue(_webDriver.findElement(By.id("result")).getText().equals("You clicked: Cancel"));
		_webDriver.quit();
	}

	@Test
	public void Alert_KeysSend() {
		_webDriver.get("http://localhost:7080/javascript_alerts");
		WebElement jsPrompt = _webDriver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));
		jsPrompt.click();
		Alert alert = _webDriver.switchTo().alert();
		alert.sendKeys("SDET");
		alert.accept();
		Assert.assertTrue(_webDriver.findElement(By.id("result")).getText().equals("You entered: SDET"));
		_webDriver.quit();
	}

	@Test
	public void Window() {
		_webDriver.get("http://localhost:7080/windows ");
		WebElement clickHere = _webDriver.findElement(By.xpath("//a[.='Click Here']"));
		clickHere.click();
		
		//clickHere.click();
	    ArrayList<String> tabs2 = new ArrayList<String> (_webDriver.getWindowHandles());
	    _webDriver.switchTo().window(tabs2.get(1));
	    _webDriver.close();
	    _webDriver.switchTo().window(tabs2.get(0));
		
		//
	}

	@Test
	public void Notification_Msg() {
		_webDriver.get(" http://localhost:7080/notification_message_rendered");
		WebElement clickBox = _webDriver.findElement(By.xpath("//a[@href='/notification_message']"));
		clickBox.click();
		String message = _webDriver.findElement(By.xpath("//div[@id='flash-messages']//div")).getText();
		 message = message.replace("\n", "");
		//System.out.println(message);
		//String actualMessage = message;
		String expectedMessage = "Action successful×";

		String expectedMessage1 = "Action unsuccessful, please try again×";
		if(message.equals(expectedMessage)){
			_webDriver.quit();
			}
		else if(message.equals(expectedMessage1)) {
			_webDriver.quit();
				
		}
		
	}

}

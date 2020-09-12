package pageObjects;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	@FindBy(how = How.ID, using = "username")
	WebElement username;
	@FindBy(how = How.ID, using = "password")
	WebElement password;
	@FindBy(how = How.XPATH, using = "//i[contains(text(),'Login')]")
	WebElement login;
	@FindBy(how = How.ID, using = "flash")
	WebElement flash;
	@FindBy(how = How.ID, using = "hot-spot")
	WebElement context;
	@FindBy(how = How.ID, using = "dropdown")
	WebElement dropdown;
	@FindBy(how = How.XPATH, using = "//a[text()='click here']")
	WebElement clickhere;
	@FindBy(how = How.XPATH, using = "//h3[text()='Dynamic Content']/../div/div/div[3]/div[2]")
	WebElement pagecontent;
	@FindBy(how = How.XPATH, using = "//div[@id='checkbox']/../button")
	WebElement checkRemove;
	@FindBy(how = How.XPATH, using = "//form[@id='input-example']/button")
	WebElement enableRemove;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'gone!')]")
	WebElement checkboxgone;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'enabled!']")
	WebElement enable;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Start')]")
	WebElement start;
	@FindBy(how = How.XPATH, using = "//div[@id='finish']/h4")
	WebElement messagehello;
	@FindBy(how = How.XPATH, using = "//a[text()='some-file.txt']")
	WebElement somefiletxt;
	@FindBy(how = How.ID, using = "file-upload")
	WebElement chooseFile;
	@FindBy(how = How.ID, using = "file-submit")
	WebElement upload;
	@FindBy(how = How.TAG_NAME, using = "p")
	WebElement floatingmenu;
	@FindBy(how = How.ID, using = "mce_0_ifr")
	WebElement iframe;
	@FindBy(how = How.XPATH, using = "//img[@alt='User Avatar']")
	WebElement img;
	@FindBy(how = How.XPATH, using = "//button[text()='Click for JS Alert']")
	WebElement jsalert;
	@FindBy(how = How.XPATH, using = "//button[text()='Click for JS Confirm']")
	WebElement jsconfirm;
	@FindBy(how = How.XPATH, using = "//button[text()='Click for JS Prompt']")
	WebElement jspromt;
	@FindBy(how = How.XPATH, using = "//p[@id='result']")
	WebElement jspromttext;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click')]")
	WebElement windowtext;
	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public void login() {
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		login.click();
		Assert.assertTrue(flash.getText().contains("You logged into a secure area!"));
	}

	public void invalidLogin() {
		username.sendKeys("tomsmith");
		password.sendKeys("invalid!");
		login.click();
		Assert.assertTrue(flash.getText().contains("Your password is invalid!"));
	}

	public void checkChexBoxes() {
		List<WebElement> checks = driver.findElements(By.xpath("//form[@id='checkboxes']/input"));
		for (WebElement check : checks) {
			if (!(check.isSelected())) {
				check.click();
				Assert.assertTrue(check.isSelected());
				check.click();
			} else {
				check.click();
				Assert.assertFalse(check.isSelected());
				check.click();
			}
		}
	}

	public void rightClick() {
		Actions actions = new Actions(driver);
		actions.contextClick(context).perform();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "You selected a context menu");

	}

	public void dragAndDrop() {
		List<WebElement> data = driver.findElements(By.xpath("//div[@id='columns']/div"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(data.get(0), data.get(1)).build().perform();
		data = driver.findElements(By.xpath("//div[@id='columns']/div"));
		System.out.println(data.get(0).getAttribute("id"));
	}

	public void selectDropDown() {
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option 1");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");

	}

	public void staticContent() {
		String content = pagecontent.getText();
		System.out.println(content);
		clickhere.click();
		String content1 = pagecontent.getText();
		System.out.println(content1);
		Assert.assertNotEquals(content, content1);

	}

	public void handleAjax() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		checkRemove.click();
		wait.until(ExpectedConditions.visibilityOf(checkboxgone));
		enableRemove.click();
		wait.until(ExpectedConditions.visibilityOf(enable));

	}

	public void handleDynamicLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		start.click();
		wait.until(ExpectedConditions.visibilityOf(messagehello));

	}

	public void fileHandle() {
		somefiletxt.click();
		String path = "/Users/" + System.getProperty("user.name") + "/Downloads/" + somefiletxt.getText();
		File f = new File(path);
		Assert.assertTrue(f.exists());
	}

	public void floatingMenu() {
		List<WebElement> para = driver.findElements(By.tagName("p"));
		String beforeData = para.get(0).getText();
		driver.navigate().refresh();
		para = driver.findElements(By.tagName("p"));
		String afterData = para.get(0).getText();
		Assert.assertNotEquals(beforeData, afterData);
	}

	public void iframeHandle() {
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tinymce")).sendKeys("new text");

	}

	public void fileUpload() {

	}

	public void imageHover() {
		Actions actions = new Actions(driver);
		actions.moveToElement(img).build().perform();

	}

	public void jsAlert() {

		jsalert.click();
		driver.switchTo().alert().accept();
		jsconfirm.click();
		driver.switchTo().alert().dismiss();
		jspromt.click();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("demotest");
		alert.accept();
		Assert.assertEquals(jspromttext.getText(), "You entered: demotest");
	}
	public void jsError()
	{
		System.out.println(driver.findElement(By.tagName("p")));
		Assert.assertNotNull(driver.findElement(By.tagName("p")).getText());
	}

	public void windowHandles() 
	{
		String mainId=driver.getWindowHandle();
		windowtext.click();
		Set<String> handles=driver.getWindowHandles();
		handles.remove(mainId);	
		driver.switchTo().window(handles.toArray()[0].toString());
		driver.close();
	}
	public void notificationMessage() 
	{
		windowtext.click();
		System.out.println(flash.getText());
	}
 
}

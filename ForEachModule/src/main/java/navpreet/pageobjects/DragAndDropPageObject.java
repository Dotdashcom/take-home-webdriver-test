package navpreet.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPageObject {

	WebDriver driver;

	Actions actions;

	public DragAndDropPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Drag and Drop']")
	private WebElement drag;
	
	@FindBy(id = "column-a")
	private WebElement source;

	@FindBy(id = "column-b")
	private WebElement destination;

	public void ClickDragAndDrop()
	{
		drag.click();
	}
	public String GetSourceText() {
		String before_drag_src = source.getText();
		System.out.println(before_drag_src);
		return before_drag_src;
	}

	public String GetDestinationText() {
		String before_drag_dest = destination.getText();
		System.out.println(before_drag_dest);
		return before_drag_dest;
	}

	public void DragAndDrop() {
//		actions = new Actions(driver);													1st way
//		actions.dragAndDrop(source,destination).perform();	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe"			//2nd way
		                + "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:funct"
		                + "ion(format,data){this.items[format]=data;this.types.append(format)"
		                + "},getData:function(format){return this.items[format]},clearData:f"
		                + "unction(format){}};var emit=function(event,target){var evt=document"
		                + ".createEvent('Event');evt.initEvent(event,true,false);evt.dataTran"
		                + "sfer=dataTransfer;target.dispatchEvent(evt);};emit('dragstart',src);"
		                + "emit('dragenter',tgt);emit('dragover',tgt);emit('drop',tgt);emit('d"
		                + "ragend',src);", source, destination);
	}

	public void ImplicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));
	}
	public String GetSourceTextAfter() {
		String after_drag_src = source.getText();
		System.out.println(after_drag_src);
		return after_drag_src;
	}

	public String GetDestinationTextAfter() {
		String after_drag_dest = destination.getText();
		System.out.println(after_drag_dest);
		return after_drag_dest;

	}

}

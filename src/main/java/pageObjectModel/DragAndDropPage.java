package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class DragAndDropPage {

	private WebDriver driver;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	static final String JS_DRAG_AND_DROP = "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEff"
			+ "ect:'',effectAllowed:'all',files:[],items:{},types:[],setData:f"
			+ "unction(format,data){this.items[format]=data;this.types.append("
			+ "format);},getData:function(format){return this.items[format];},"
			+ "clearData:function(format){}};var emit=function(event,target){v"
			+ "ar evt=document.createEvent('Event');evt.initEvent(event,true,f"
			+ "alse);evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);}"
			+ ";emit('dragstart',src);emit('dragenter',tgt);emit('dragover',tg"
			+ "t);emit('drop',tgt);emit('dragend',src);";

	@FindBy(how = How.XPATH, using = "//div[@id='columns']/div[1]")
	private WebElement fieldA;

	@FindBy(how = How.XPATH, using = "//div[@id='columns']/div[2]")
	private WebElement fieldB;

	public boolean dragAndDrop() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(JS_DRAG_AND_DROP, new Object[] { fieldA, fieldB });

		String aText = fieldA.getText();
		return aText.equals("B");
	}

}

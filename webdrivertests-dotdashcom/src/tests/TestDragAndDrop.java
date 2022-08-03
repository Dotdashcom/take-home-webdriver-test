/**
 * 
 */
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @author connorparnell
 *
 */
     
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;



public class TestDragAndDrop {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/drag_and_drop");
		
	}
	
	@Test
	public void dragAndDropSuccess() {
		driver.manage().window().maximize();
		WebElement box_a = driver.findElement(By.id("column-a"));
		WebElement box_b = driver.findElement(By.id("column-b"));
		// dragging box a to box b using a workaround as dragAndDrop action does not function on Chrome
		final String jsWorkaround =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";
        ((JavascriptExecutor)this.driver).executeScript(jsWorkaround, box_a, box_b);
		// ensure that text on boxes has been switched
        System.out.println(box_a.getText());
		assertTrue(box_a.getText().contains("B"));
		assertTrue(box_b.getText().contains("A"));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}

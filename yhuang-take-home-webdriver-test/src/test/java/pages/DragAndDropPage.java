package pages;

import org.openqa.selenium.*;

public class DragAndDropPage extends BaseDriver{
	    
    public DragAndDropPage(WebDriver driver){
    	super(driver);
    }
    
    public void dragAndDropSwapColumn() {
    	WebElement columnABox = driver.findElement(By.id("column-a"));
    	WebElement columnBBox = driver.findElement(By.id("column-b"));
    	dragAndDrop(columnABox, columnBBox);
    }
    
    public String getCurrentLeftColumnHeaderText() {
    	WebElement columnABox = driver.findElement(By.id("column-a"));
    	return columnABox.findElement(By.cssSelector("header")).getText();
    }
    
    public String getCurrentRightColumnHeaderText() {
    	WebElement columnBBox = driver.findElement(By.id("column-b"));
    	return columnBBox.findElement(By.cssSelector("header")).getText();
    }
    
    private void dragAndDrop(WebElement from, WebElement to) {
    	final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                "ction(format,data){this.items[format]=data;this.types.append(for" +
                "mat);},getData:function(format){return this.items[format];},clea" +
                "rData:function(format){}};var emit=function(event,target){var ev" +
                "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                "'drop',tgt);emit('dragend',src);";

        ((JavascriptExecutor)driver).executeScript(java_script, from, to);
    }
}

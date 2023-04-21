import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {
    private String path = "/drag_and_drop";

    private By columnABy = By.xpath("//div[@id='column-a']");
    private By columnBBy = By.xpath("//div[@id='column-b']");

    DragAndDropPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public WebElement getColumnA() {
        return driver.findElement(columnABy);
    }
    public WebElement getColumnB() {
        return driver.findElement(columnBBy);
    }

    public void dragAtoB() {
        Actions actions = new Actions(driver);
        WebElement columnA = getColumnA();
        WebElement columnB = getColumnB();

        // =========================================================================================
        // Two two commented lines below seem like the correct way to automate this drag drop test,
        // but for some reason it refuses to work. It sounds like it's a bug with web elements that
        // have "draggable" attribute, which this application uses in this webpage.
        // https://www.softwaretestingmagazine.com/knowledge/selenium-drag-and-drop-bug-workaround/
        // Instead I'll just use this copy and pasted javascript work around that I do not claim
        // to understand. The JavaScript answer comes from the following link:
        // https://stackoverflow.com/questions/56141490/drag-and-drop-not-working-with-chrome-webdriver-in-java
        // =========================================================================================
        // actions.dragAndDrop(columnA, columnB).perform();
        // actions.clickAndHold(columnA).moveToElement(columnB).release(columnB).build().perform();

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

        ((JavascriptExecutor)driver).executeScript(java_script, columnA, columnB);
    }

    public String getAText() {
        return getColumnA().getText();
    }

    public String getBText() {
        return getColumnB().getText();
    }
}

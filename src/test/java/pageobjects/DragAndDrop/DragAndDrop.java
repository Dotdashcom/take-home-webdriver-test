package pageobjects.DragAndDrop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.HashMap;


public class DragAndDrop {
    protected WebDriver driver;
    private static final long DEFAULT_PAUSE = 2000;

    @FindBy(xpath ="//div[@id='column-a']")
    public WebElement elColumnA;

    @FindBy(xpath ="//div[@id='column-b']")
    public WebElement elColumnB;

    @FindBy(xpath ="//div[@id='column-a']/header")
    public WebElement elHeaderA;

    @FindBy(xpath ="//div[@id='column-b']/header")
    public WebElement elHeaderB;

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

    public DragAndDrop(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HashMap expDrapAndDrop() {
        HashMap<String, String> headers  = new HashMap<>();

        headers.put("Column A", elHeaderA.getText());
        headers.put("Column B", elHeaderB.getText());

        return headers;
    }

    public HashMap actDrapAndDrop() throws InterruptedException {
        HashMap<String, String> headers  = new HashMap<>();
        Thread.sleep(DEFAULT_PAUSE);

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(java_script, elColumnA, elColumnB);

            Thread.sleep(DEFAULT_PAUSE);

            headers.put("Column A", elHeaderA.getText());
            headers.put("Column B", elHeaderB.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return headers;
    }

}

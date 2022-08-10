package Test;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import Util.BrowserFactory;

public class JavaScriptErroTest extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
		driver.get(" http://localhost:7080/javascript_error");
	}
    @Test 
    public void Verify_ErroOccurs() throws Exception
    {
    	
        String error = "Cannot read properties of undefined";
        
        boolean exists = false;
        
        LogEntries LE = driver.manage().logs().get(LogType.BROWSER);
        
        List<LogEntry> log = LE.getAll();
        
        for(org.openqa.selenium.logging.LogEntry logEntry : log)
        {
            if(logEntry.toString().contains(error)) {
            	exists = true;
            }
        }
        assertTrue(exists);
   
    }
    
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }


}

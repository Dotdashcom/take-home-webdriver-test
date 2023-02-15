import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v107.console.model.ConsoleMessage.Level;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class JavascriptErrors {

	@Test
	public static void javascriptErrorsTest() {
	
		WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:7080/javascript_error");
        
        driver.manage().window().maximize();
        Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
        for (String s : logtyp) {
        //   System.out.println(logtyp);
        }
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> lg = logEntries.getAll();
        for(LogEntry logEntry : lg) {
           System.out.println(logEntry);
        }
        driver.quit();

	}

}

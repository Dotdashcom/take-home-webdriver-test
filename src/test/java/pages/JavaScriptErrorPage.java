package pages;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;
import org.testng.Assert;

import java.util.Iterator;

import base.BaseTest;

public class JavaScriptErrorPage extends BaseTest {

	public void javaScriptError(String error) {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		Iterator<LogEntry> it = logEntries.iterator();
		Assert.assertNotNull(it);
		Assert.assertNotNull(it.hasNext());
		LogEntry entry = it.next();

		Assert.assertEquals(Level.SEVERE, entry.getLevel());
		Assert.assertTrue(entry.getMessage().contains(error));

	}

}

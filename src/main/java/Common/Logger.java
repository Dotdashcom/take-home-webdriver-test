package Common;
import org.testng.Assert;
public class Logger {
	public static void Log(String message) {
		System.out.println(message);
	}
	public static void AssertEqualAndLog(String message, Object actual, Object expected) {
		Log(message);
		Assert.assertEquals(actual, expected);
	}
	public static void AssertNotEqualAndLog(String message, Object actual, Object expected) {
		Log(message);
		Assert.assertNotEquals(actual, expected);
	}
	public static void AssertContainsAndLog(String message, String actual, String expected) {
		Log(message);
		boolean contains = expected.contains(actual) || actual.contains(expected);
		Assert.assertEquals(true, contains);
	}
}
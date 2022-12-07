package Common;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
public class TestBase {
	static HashMap <String, ArrayList <Config>> map = new HashMap <>();
	@AfterSuite
	public void teardown(ITestContext iTestContext) {
		ITestNGMethod [] methodNames = iTestContext.getAllTestMethods();
		for (ITestNGMethod methodName : methodNames) {
			ArrayList <Config> allConfigs = map.get(methodName.getMethodName());
			if (allConfigs != null) {
				for (Config config : allConfigs) {
					Browser.closeBrowser(config);
				}
			}
		}
	}
	@DataProvider (name = "GetCheckBoxData")
	public Object [] [] getCheckBoxData(Method method) {
		Object [] [] config = new Object [4] [2];
		ArrayList <Config> c = new ArrayList <>();
		List <Boolean> isChecked = new ArrayList <>();
		config[0][0] = new Config();
		isChecked.add(0, false);
		isChecked.add(1, false);
		config[0][1] = isChecked;
		config[1][0] = new Config();
		isChecked = new ArrayList <>();
		isChecked.add(0, false);
		isChecked.add(1, true);
		config[1][1] = isChecked;
		config[2][0] = new Config();
		isChecked = new ArrayList <>();
		isChecked.add(0, true);
		isChecked.add(1, false);
		config[2][1] = isChecked;
		config[3][0] = new Config();
		isChecked = new ArrayList <>();
		isChecked.add(0, true);
		isChecked.add(1, true);
		config[3][1] = isChecked;
		for (int i = 0; i < 4; i++) {
			c.add((Config) config[i][0]);
		}
		map.put(method.getName(), c);
		return config;
	}
	@DataProvider (name = "GetFailedLoginData")
	public Object [] [] getFailedLoginData(Method method) {
		String failedLoginCreds[] = {"tomsmith/SuperSecretPassword", "tommith/SuperSecretPassword!"};
		String expectedMessage[] = {"Your password is invalid!", "Your username is invalid!"};
		Object [] [] config = new Object [2] [3];
		ArrayList <Config> c = new ArrayList <>();
		for (int i = 0; i < 2; i++) {
			config[i][0] = new Config();
			config[i][1] = failedLoginCreds[i];
			config[i][2] = expectedMessage[i];
			c.add((Config) config[i][0]);
		}
		map.put(method.getName(), c);
		return config;
	}
	@DataProvider (name = "GetTestConfig")
	public Object [] [] getTestConfig(Method method) {
		Object [] [] config = new Object [1] [1];
		config[0][0] = new Config();
		ArrayList <Config> c = new ArrayList <>();
		c.add((Config) config[0][0]);
		map.put(method.getName(), c);
		return config;
	}
	@DataProvider (name = "GetTestData")
	public Object [] [] getTestData(Method method) {
		int testDataSize = method.getAnnotation(TestData.class).value().length;
		Object [] [] config = new Object [testDataSize] [2];
		ArrayList <Config> c = new ArrayList <>();
		for (int i = 0; i < testDataSize; i++) {
			config[i][0] = new Config();
			config[i][1] = method.getAnnotation(TestData.class).value()[i];
			c.add((Config) config[i][0]);
		}
		map.put(method.getName(), c);
		return config;
	}
}

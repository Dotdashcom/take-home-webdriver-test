
import java.util.Arrays;

import org.testng.TestNG;

public class Runner {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		testng.setTestSuites(Arrays.asList("./testng.xml"));
		testng.run();
	}
}

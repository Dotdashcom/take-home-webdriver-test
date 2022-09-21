package steps;

import testbase.BaseClass;

import utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;


// Hooks is similar to Listener in TestNG framework

public class Hooks {
	
	@Before
	public void start() {
		BaseClass.setUp();
	}
	

	@After
	public void end() {
		CommonMethods.wait(2);
		BaseClass.tearDown();
	}

}

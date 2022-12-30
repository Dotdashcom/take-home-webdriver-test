package com.takehome.dataproviders;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestCaseDataProvider {

	@DataProvider(name="logindataprovider")
	public Object[][] loginDataProvider(Method invokingMethod)
	{
		if(invokingMethod.getName().equals("loginSuccess"))
			return new Object[][] {
			   {"tomsmith","SuperSecretPassword!"}
		   };
		
		else
			return new Object[][] {
			   {"test","tes!"}
		   };
	}
}

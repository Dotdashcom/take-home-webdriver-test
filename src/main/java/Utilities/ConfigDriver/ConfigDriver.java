package Utilities.ConfigDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigDriver {
	Properties properties;
	
	public ConfigDriver() throws IOException {
		try
		{
			File propFile = new File("C:\\Users\\Sruthi\\eclipse-workspace\\Practise\\src\\main\\java\\Resources\\config.properties");
			properties = new Properties();
			properties.load(new FileInputStream(propFile));
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println(fnf.getMessage());
			fnf.printStackTrace();
			//ExtentTestManager.getTest().log(LogStatus.FATAL,fnf.getMessage());
		}
		catch(IOException iox)
		{
			iox.getMessage();
			//ExtentTestManager.getTest().log(LogStatus.FATAL,iox.getMessage());
		}
	}
	
	public String getProperty(String propName)
	{
		return properties.getProperty(propName);
	}
	
	/*public static void main(String[] args) throws IOException
	{
		ConfigDriver cdf = new ConfigDriver();
		System.out.println(cdf.getProperty("URL"));
	}*/
}

package main.java;

	import java.io.File;
	import java.io.IOException;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class UtilityScreenshot {

		public static void captureScreenshot(WebDriver driver,String screenshotName)
		//ScreenshotName is given as pwrameter inorder to display screenshot by unique name when this method is used several times on various areas withint he class
		{
			
			try {
				TakesScreenshot ts=(TakesScreenshot)driver;
				File scr = ts.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scr,new File("./Screenshots/"+screenshotName+ ".png"));
			} 
			catch (Exception e) {
				System.out.println("Exception while taking screenshot" +e.getMessage());
				e.printStackTrace();
			}
		}
		

	}



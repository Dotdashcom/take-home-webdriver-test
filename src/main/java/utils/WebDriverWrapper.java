package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WebDriverWrapper {

    public static WebDriver driver = null;
    public static File folder;

    @BeforeMethod(alwaysRun = true)
    public static void launchApplication(){

        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/main/java/utils/drivers/chromedriver"));

        folder = new File((System.getProperty("user.dir") + "/src/main/java/utils"), "downloads");
        Boolean bool = folder.mkdir();
        String folderPath = (System.getProperty("user.dir") + "/src/main/java/utils/downloads");
        if (bool) {
            System.out.println("Directory created");

        } else {
            System.out.println("Directory not created");
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ConfigReader configReader = new ConfigReader();
        driver.get(configReader.getConfiguration("baseurl"));

    }

    @AfterMethod(alwaysRun = true)
	public static void closeApplication() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();

			for(File file : folder.listFiles()){
			    file.delete();
            }
            folder.delete();
		}
	}

}

package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class driverConfig
{
    public static WebDriver dr;
    public static Properties pr;

    public static String baseUrl;

    public static WebDriver invokedriver() throws IOException {

        String loc=System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\";

        FileInputStream fis=new FileInputStream(loc+"prop.properties");

        pr=new Properties();

        pr.load(fis);

        String browserName=pr.getProperty("browser");

        baseUrl= pr.getProperty("baseurl");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",loc+"chromedriver.exe");
            dr= new ChromeDriver();
            dr.manage().window().maximize();
        }

        else if(browserName.equalsIgnoreCase("Edge"))
        {
            System.setProperty("webdriver.edge.driver",loc+"msedgedriver.exe");
            dr= new EdgeDriver();
            dr.manage().window().maximize();
        }


        return dr;
    }


}
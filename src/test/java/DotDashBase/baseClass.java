package DotDashBase;

import DotDashUtilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseClass {

    ReadConfig readconfig = new ReadConfig();   //Creating object of ReadConfig Class
    public String baseURL=readconfig.getAppURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();

    public WebDriver driver;
    //Setup method
    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
        driver = new ChromeDriver(); //Launching the browser
        driver.manage().window().maximize();    //Maximize the page
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}

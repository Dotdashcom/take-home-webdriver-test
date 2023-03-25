package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class TestConfiguration {

    protected WebDriver driver;
    public Properties properties;

    @BeforeSuite
    public void getConfiguration() throws IOException {

        ClassLoader classLoader=getClass().getClassLoader();
        String configPath="configs/config.properties";
        URL configFileUrl=classLoader.getResource(configPath);
        InputStream config=configFileUrl.openStream();

        properties=new Properties();
        properties.load(config);
        config.close();
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

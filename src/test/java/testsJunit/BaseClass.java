package testsJunit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;


public abstract class BaseClass {


    protected WebDriver driver;
    protected Actions actions;


    @BeforeMethod(alwaysRun = true)

    public void setUpMethod() {

//		driver = Driver.getDriver();
//		actions = new Actions(driver);
//		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("http://localhost:7080");


    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() throws IOException {

        //   Driver.quit();
    }


}

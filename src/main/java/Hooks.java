import org.testng.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class Hooks extends TestDataProvider {

    @BeforeMethod
    public  void  Setup() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, MalformedURLException {
        App.Initdriver(10);
        App.driver.navigate().to(URLs.Home.getOption());

    }

    @AfterMethod
    public void Cleanup(){
       App.CloseDriver();
    }
}

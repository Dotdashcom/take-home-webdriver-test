package steps;
import base.MainClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


public class Hooks extends MainClass {

    @Before
    public void before(){

         setUp();

    }

    @After
    public void after(){

        //tearDown();

    }


}

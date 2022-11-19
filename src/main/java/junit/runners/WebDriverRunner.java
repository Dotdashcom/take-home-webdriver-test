package junit.runners;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import static server.SeleniumStandaloneServer.SERVER;

public class WebDriverRunner extends BlockJUnit4ClassRunner {

    /**
     * Starts Selenium Server
     *
     * @param klass Class (suite) to run tests from
     * @throws InitializationError
     */
    public WebDriverRunner(Class<?> klass) throws InitializationError {
        super(klass);
        SERVER.start();
    }


}

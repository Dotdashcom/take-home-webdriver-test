package browsers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static org.openqa.selenium.remote.DesiredCapabilities.chrome;
import static org.openqa.selenium.remote.DesiredCapabilities.firefox;

public enum BrowserType implements HasCapabilities {

    CHROME {
        public Capabilities getCapabilities() {
            chromedriver().setup();
            return chrome();
        }
    },

    FIREFOX {
        public Capabilities getCapabilities() {
            firefoxdriver().setup();
            return firefox();
        }
    }

}

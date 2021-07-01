package webdriver.test.Util;

import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class PageLoader {

    public static void initializePage(WebDriver driver, String pagePath) {
        String baseurl = null;

        try {
            baseurl = ConfigReader.getConfigProperties("baseURL");

        } catch (IOException e) {

            e.printStackTrace();

        }

        driver.get(baseurl + pagePath);
    }
}

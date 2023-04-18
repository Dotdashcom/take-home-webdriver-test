import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

class NotificationMessageTest {

    WebDriver driver;
    private final String url = "/notification_message_rendered";

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void notificationMessageTest() throws IOException, URISyntaxException {

        Collection<String> collection = new HashSet<>();
        collection.add("Action successful\n" +
                "×");
        collection.add("Action unsuccesful, please try again\n" +
                "×");
        collection.add("Action successful\n" +
                "×");

        for (int i=0; i<10; i++) {
            driver.findElement(By.xpath("//*[text()='Click here']")).click();
            collection.remove(driver.findElement(By.id("flash")).getText());
        }

        if (collection.size() == 0) {
            assert true;
        } else {
            assert false;
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
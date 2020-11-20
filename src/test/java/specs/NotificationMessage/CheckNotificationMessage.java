package specs.NotificationMessage;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #18 Notification Message: http://localhost:7080/notification_message_rendered Test notification Message
public class CheckNotificationMessage extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 4000;
    private static final int attempts = 5;

    private static final String ACT_SUCCESSFUL = "Action successful";
    private static final String ACT_UNSUCCESSFUL_TRY_AGAIN = "Action unsuccesful, please try again";
    private static final String ACT_UNSUCCESSFUL = "Action Unsuccessful";

    private static By byClickHere = By.linkText("Click here");
    private static By byFlashMsg = By.id("flash");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/notification_message_rendered");
    }

    @Test
    public void checkNotificationMessage() throws Exception {
        SoftAssert softas = new SoftAssert();
        boolean flag = false;

        for (int i=0; i<attempts; i++) {
            driver.findElement(byClickHere).click();
            Thread.sleep(DEFAULT_PAUSE);

            String actFlashMsg = driver.findElement(byFlashMsg).getText().trim();

            // Remove 'x' character
            actFlashMsg = actFlashMsg.substring(0, actFlashMsg.length() - 2);

            System.out.println(i + ": " + actFlashMsg);

            if (ACT_SUCCESSFUL.equals(actFlashMsg) ||
                    ACT_UNSUCCESSFUL_TRY_AGAIN.equals(actFlashMsg) ||
                    ACT_UNSUCCESSFUL.equals(actFlashMsg)) {
                flag = true;
            }

            // Validate the shown message is not correct
            softas.assertTrue(flag, "The shown message is not correct");

            flag =false;
        }

        softas.assertAll();
    }

}

package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class NotificationMessage extends WebObject {
    public NotificationMessage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static NotificationMessage navigateToNotificationMessagePage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/notification_message_rendered", baseUrl);
        driver.get(url);
        return new NotificationMessage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public boolean clickLinkUntilExpectedMessage(String message) throws Exception {
        By link = By.xpath(this.xpathForLink());

        boolean found = false;
        int i = 0;
        while (!found && i < 6) // 6 * 2 = 12 secs
        {
            if(i != 0) { //no need to wait for the first click
                Thread.sleep(2000);
            }
            driver.findElement(By.xpath(this.xpathForLink())).click(); // click the Refresh Status button
            this.waitForElementVisibility(link);
            found = driver.findElement(By.xpath(this.xpathForPageFlashNotice())).getText().contains(message); // compare the current engine status to Offline
            i++;
        }

        return found;
    }


    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForLink() {
        return "//a[text()=\"Click here\"]";
    }

    private String xpathForPageFlashNotice() {
        return "//*[@class=\"flash notice\"]";
    }
}

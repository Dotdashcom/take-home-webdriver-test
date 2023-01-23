package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base_Page;

import java.util.ArrayList;
import java.util.List;

public class notification_message_page extends Base_Page {
    WebDriver driver;

    public notification_message_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/p/a")
    WebElement click_here_link;

    @FindBy(how = How.XPATH, using = "//*[@id=\"flash\"]")
    WebElement notification_message;

    public void notification_message_meth() {
        List<String> provided_list = new ArrayList<String>();
        provided_list.add("Action Successful");
        provided_list.add("Action unsuccessful, please try again");
        provided_list.add("Action Unsuccessful");

        for (String pro: provided_list) {
            click_here_link.click();
            String notification = notification_message.getText();

            if (!notification.equals(pro)) {
//                System.out.println(notification);

            }else
                Assert.assertTrue(true);
            click_here_link.click();
            break;

        }

    }
}
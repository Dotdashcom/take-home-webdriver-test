package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.notification_message_page;
import utils.Browser_Factory;
public class _17_Notification_Message_test {
    WebDriver driver;
    String notification_message_rendered = "notification_message_rendered";

    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void  Notification_Message_test(){
        driver = Browser_Factory.init_url(notification_message_rendered);
        notification_message_page nmrp = PageFactory.initElements(driver, notification_message_page.class);
        nmrp.notification_message_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//      driver =  Browser_Factory.teardown();
    }
}

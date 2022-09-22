package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class NotificationMessagePage extends BasePage {

    private final By click_here_href_xpath = By.xpath("//*[contains(text(),'Click here')]");
    private final By text = By.xpath("//div[@id='content']/div/a");

    public NotificationMessagePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("notification_message_url"));
    }

    public void verify_click_here_link(){

        AtomicBoolean isTextPresent = new AtomicBoolean(false);

        muliple_click_link();

        if (pageSourceVerify("Action unsuccesful, please try again")) {

            isTextPresent.set(true);
            Log.info("text present => Action unsuccesful, please try again");

        }else if (pageSourceVerify("Action successful")){

            isTextPresent.set(true);
            Log.info("text present => Action successful");

        } else if (pageSourceVerify("Action unsuccessful")){

            isTextPresent.set(true);
            Log.info("Action unsuccessful");
        }
        Assert.assertEquals(true, isTextPresent.get(), "text is not displayed, please check");

    }

    private void muliple_click_link() {
        IntStream.range(0,new Random().nextInt(5)).forEach(x-> { getDriver().findElement(click_here_href_xpath).click(); });
    }


}

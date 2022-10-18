package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class DynamicContentPage extends BasePage {

    public DynamicContentPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/dynamic_content");
    }

    @FindBy(css = "a[href=\"/dynamic_content?with_content=static\"]")
    private WebElement click_here_Btn;


    @FindBy(css = "div[class=\"example\"] div[id=\"content\"] div[class=\"row\"]:nth-child(1) div:nth-child(2)")
    private WebElement textUser1;
    @FindBy(css = "div[class=\"example\"] div[id=\"content\"] div[class=\"row\"]:nth-child(4) div:nth-child(2)")
    private WebElement textUser2;

    @FindBy(css = "div[class=\"example\"] div[id=\"content\"] div[class=\"row\"]:nth-child(7) div:nth-child(2)")
    private WebElement textUser3;



    public void assertDynamicContent(int refreshTimes){

        String txtUser1 = textUser1.getText().trim();

        String txtUser2 = textUser2.getText().trim();

        String txtUser3 = textUser1.getText().trim();

        for (int i = 0; i <= refreshTimes; i++){

            click_here_Btn.click();

            if (i == 0){


                String txtUser1Updated = driver.findElement(By.cssSelector("div[class=\"example\"] div[id=\"content\"] div[class=\"row\"]:nth-child(1) div:nth-child(2)")).getText().trim();
                String txtUser2Updated = driver.findElement(By.cssSelector("div[class=\"example\"] div[id=\"content\"] div[class=\"row\"]:nth-child(4) div:nth-child(2)")).getText().trim();


                Assert.assertNotEquals(txtUser1, txtUser1Updated);
                Assert.assertNotEquals(txtUser2, txtUser2Updated);

            }

            String txtUser3Updated = driver.findElement(By.cssSelector("div[class=\"example\"] div[id=\"content\"] div[class=\"row\"]:nth-child(7) div:nth-child(2)")).getText().trim();
            Assert.assertNotEquals(txtUser3, txtUser3Updated);
        }


    }

}

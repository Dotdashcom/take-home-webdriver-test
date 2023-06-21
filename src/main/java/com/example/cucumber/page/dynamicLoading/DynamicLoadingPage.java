package com.example.cucumber.page.dynamicLoading;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.constants.Page.DYNAMIC_LOADING_PAGE;
import static com.example.constants.PageLinkText.DYNAMIC_LOADING;
import static org.junit.Assert.assertEquals;

public class DynamicLoadingPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By dynamic_loading_page_link = By.linkText(DYNAMIC_LOADING);

    public void the_user_click_on_dynamic_loading_page() {
        clckOnWebElement(dynamic_loading_page_link);
    }

    public void the_user_should_see_the_dynamic_loading_page() {
        assertEquals("Dynamic Download Page URL doesn't Match: ", DYNAMIC_LOADING_PAGE, driver.getCurrentUrl());
    }

    public void the_user_clicks_on_the_link_on_the_dynamic_loading_page(String exampleLink) {
        By exampleLinkXpath = By.xpath("//a[contains(text(),'" + exampleLink + "')]");
        clckOnWebElement(exampleLinkXpath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Start')]")));
    }

    public void the_user_should_see_the_page_on_the_dynamic_loading_page(String dynamicContentPage) {
        assertEquals("Dynamic content page not correct: ", dynamicContentPage,getWebElementText(By.xpath("//h3[contains(text(),'"+ dynamicContentPage +"')]")));
    }

    public void the_user_clicks_on_the_button_to_view_elements_on_the_dynamic_loading_page(String startButton) {
        By exampleLinkXpath = By.xpath("//button[contains(text(),'" + startButton + "')]");
        clckOnWebElement(exampleLinkXpath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
    }

    public void the_user_should_see_the_text_is_displayed_on_the_dynamic_loading_page(String dynamicText) {
        By hiddenTextXpath = By.xpath("//*[@id='finish']/h4");
        assertEquals("Hidden message not correct after enabled: ", dynamicText,getWebElementText(hiddenTextXpath));
    }
}

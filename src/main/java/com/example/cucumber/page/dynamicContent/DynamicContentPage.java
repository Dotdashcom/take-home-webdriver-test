package com.example.cucumber.page.dynamicContent;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

import static com.example.constants.Page.DYNAMIC_CONTENT_PAGE;
import static com.example.constants.PageLinkText.DYNAMIC_CONTENT;
import static org.junit.Assert.*;

public class DynamicContentPage extends WebDriverJavaUtil {
    private WebDriver driver;
    private ReadProperties readProperties = new ReadProperties();
    Logger log = Logger.getLogger(DynamicContentPage.class.getName());
    private By dynamic_content_page_link = By.linkText(DYNAMIC_CONTENT);
    private String initialPageSource;
    private String[] initialImageSources;
    private String[] initialTextSources;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void the_user_click_on_dynamic_content_page() {
        clckOnWebElement(dynamic_content_page_link);
    }

    public void the_use_should_see_the_dynamic_content_page() {
        assertEquals("Checkbox Page URL doesn't Match: ", DYNAMIC_CONTENT_PAGE, driver.getCurrentUrl());
    }

    public void the_user_clicks_on_the_link_on_the_dynamic_content_page(String clickHere) {
        initialPageSource = driver.getPageSource();
        List<WebElement> imageElements = driver.findElements(By.xpath("//*[@id='content']//img"));
        List<WebElement> textElements = driver.findElements(By.xpath("//div[contains(@class, 'large-10 columns') and not(contains(@class, 'large-centered'))]"));
        initialImageSources = new String[imageElements.size()];
        for (int i = 0; i < imageElements.size(); i++) {
            initialImageSources[i] = imageElements.get(i).getAttribute("src");
            log.info("Init Img: " + initialImageSources[i] );
        }
        initialTextSources = new String[textElements.size()];
        for (int i = 0; i < textElements.size(); i++) {
            initialTextSources[i] = textElements.get(i).getText();
            log.info("Init TXT: " + initialTextSources[i] );
        }
        By clickHereXpath = By.linkText(clickHere);
        clckOnWebElement(clickHereXpath);
        waitForMilliSeconds(1000);
    }

    public void the_user_should_see_the_page_is_refreshed_on_the_dynamic_content_page() {
        boolean allSameImg = true;
        boolean allSameTxt = true;
        List<WebElement> imageElements = driver.findElements(By.xpath("//*[@id='content']//img"));
        String[] refreshedImageSources = new String[imageElements.size()];
        for (int i = 0; i < imageElements.size(); i++) {
            refreshedImageSources[i] = imageElements.get(i).getAttribute("src");
            log.info("Final Img: " + refreshedImageSources[i] );
        }
        List<WebElement> refreshedTextElements = driver.findElements(By.xpath("//div[contains(@class, 'large-10 columns') and not(contains(@class, 'large-centered'))]"));
        String[] refreshedTextSources = new String[refreshedTextElements.size()];
        for (int i = 0; i < refreshedTextElements.size(); i++) {
            refreshedTextSources[i] = refreshedTextElements.get(i).getText();
            log.info("Final TXT: " + refreshedTextSources[i] );
        }
        for (int i = 0; i < imageElements.size(); i++) {
            if (!initialImageSources[i].equals(refreshedImageSources[i])){
                allSameImg = false;
                break;
            }
        }
        for (int i = 0; i < refreshedTextElements.size(); i++) {
            if (!initialTextSources[i].equals(refreshedTextSources[i])){
                allSameTxt = false;
                break;
            }
        }
        assertFalse("Image/Txt not refreshed: ", allSameImg && allSameTxt);
    }
}

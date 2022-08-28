package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicLoading extends Base {

    By content = By.id("content");
    By start = By.xpath("//div[@id='start']/button");
    By loading = By.xpath("//div[@id='loading']");
    By finish = By.xpath("//div[@id='finish']/h4");

    public DynamicLoading(WebDriver driver) {
        super(driver);
    }

    public void dynamicLoading() throws InterruptedException {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (isDisplayed(content)){
            click(start);
            Thread.sleep(5000);
            ewait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
        } else {
            System.out.println("Dynamic Loading page was no found");
        }
    }

    public Boolean compareFinishMessage(){
        return isDisplayed(finish);
    }
}

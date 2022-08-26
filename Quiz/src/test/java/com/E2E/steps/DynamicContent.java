package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DynamicContent {

@Given("the user is on the homepage page for dynamic content")
public void the_user_is_on_the_homepage_page_for_dynamic_content() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/dynamic_content");
}



@Then("the user opens the page once and checks the content then refereshes the content is unique each time")
public void the_user_opens_the_page_once_and_checks_the_content_then_refereshes_the_content_is_unique_each_time() {
    // Write code here that turns the phrase above into concrete actions
    WebElement text = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]"));
    WebElement img = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/img"));
    String srcfirst = img.getAttribute("src");
    String textfirst = text.getText();

    TestRunner.driver.navigate().refresh();

    WebElement imgSecond = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/img"));
    WebElement textSecond = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]"));

    String secondText = textSecond.getText();
    String secondsrc = imgSecond.getAttribute("src");


    Assert.assertNotEquals(srcfirst, secondsrc);
    Assert.assertNotEquals(textfirst, textSecond);
    TestRunner.driver.navigate().refresh();

    TestRunner.driver.navigate().refresh();


    WebElement imgThird = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/img"));
    WebElement testThird = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]"));

    String thirdText = testThird.getText();
    String thirdSrc = imgThird.getAttribute("src");

    Assert.assertNotEquals(thirdSrc, secondsrc);
    Assert.assertNotEquals(thirdText, secondText);

}
    
}

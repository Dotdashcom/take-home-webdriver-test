package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

public class MouseHover {
    @Given("I am on the mouse hover page")
    public void i_am_on_the_mouse_hover_page() {
        Driver.getDriver().get("http://localhost:7080/hovers");
    }

    @When("I hover on each image I verify that additional information is displayed for each image")
    public void i_hover_on_each_image() throws InterruptedException {
        Actions actions= new Actions(Driver.getDriver());
        for (int i =1; i<=3;i++) {
            actions.moveToElement(Driver.getDriver().findElement(By.xpath
                    ("(//img[@src='/img/avatar-blank.jpg'])" + "[" + i + "]"))).
                    build().perform();
            Thread.sleep(2000);
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h5)"+"[" + i + "]")).isDisplayed());
            System.out.println("Additional information is displayed next to each image: "+
                    Driver.getDriver().findElement(By.xpath("(//h5)"+ "[" + i + "]")).getText());
        }
    }





}

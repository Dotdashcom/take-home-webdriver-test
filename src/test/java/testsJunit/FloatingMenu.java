package testsJunit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.Driver;

public class FloatingMenu extends BaseClass  {
    //I am on the Floating Menu page
    //I scroll the page
    //I varify that the floating menu is still displayed

    @Test
    public void i_am_on_the_Floating_Menu_page() throws InterruptedException {

        Driver.getDriver().get(" http://localhost:7080/floating_menu");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(3000);
        Assert.assertTrue(Driver.getDriver().
                findElement(By.xpath("//*[@id='menu']")).isDisplayed());
        System.out.println("The Floating menu is displayed " + Driver.getDriver().
                findElement(By.xpath("//*[@id='menu']")).isDisplayed());
    }

}

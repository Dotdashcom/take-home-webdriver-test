
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MouseHoverPage;

public class Test14MouseHover extends TestBase{
    
    @Test
    public void test14MouseHover() throws InterruptedException{
        MouseHoverPage mouseHoverPage = new MouseHoverPage(webDriver);
        Actions actions = new Actions(webDriver);
        List<WebElement> images = mouseHoverPage.getImages();
        for (int i=0;i<3;){
            actions.moveToElement(images.get(i)).perform();
            Thread.sleep(2000);
            i++;
            Assert.assertTrue(mouseHoverPage.isithMessageDisplayed(i));
        }

    }
}
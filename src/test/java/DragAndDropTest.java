import framework.Pages.DragAndDropPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class DragAndDropTest extends WebDriverWrapper{


    @Test
    public void dragAndDropTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickDragAndDrop();
        DragAndDropPage dragAndDropPage = PageFactory.initElements(driver,DragAndDropPage.class);
        dragAndDropPage.dragAndDropObject();

    }
}

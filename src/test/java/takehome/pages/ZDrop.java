package takehome.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;

public class ZDrop {
   WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

   public ZDrop(){
       PageFactory.initElements(Driver.getDriver(), this);
   }

   @FindBy(linkText = "Drag and Drop")
   private  WebElement dragAndDropLink;
   @FindBy(id = "column-a")
           private WebElement dragA;
   @FindBy(id = "column-b")
   private WebElement dragB;

   public void clickDDLink() {
       wait.until(ExpectedConditions.elementToBeClickable(dragAndDropLink));
       dragAndDropLink.click();


   }

}

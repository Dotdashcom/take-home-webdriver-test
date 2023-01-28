package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DragAndDrop {
    private WebDriver driver;
    private SoftAssert softAssert;

    public DragAndDrop(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="column-a")
    private WebElement elementA;

    @FindBy(xpath = "//div[@id='column-a']/header")
    private WebElement textElementA;

    @FindBy(xpath = "//div[@id='column-b']/header")
    private WebElement textElementB;

    @FindBy(id="column-b")
    private WebElement elementB;



    public void verifyDragAndDropFunctionality() throws InterruptedException {
        navigateDragAndDrop();
        Actions builder = new Actions(driver);
       // builder.moveToElement(elementA).clickAndHold().moveToElement(elementB).release().perform();
       // builder.clickAndHold(textElementA).moveToElement(elementB).release().perform();
        //builder.dragAndDropBy(elementA,150,150).perform();

        Thread.sleep(2000);

       // builder.dragAndDrop(textElementA,elementB).perform();
        Thread.sleep(2000);



        final String java_script =

                        "var dragSrcEl = null;" +
                        "function handleDragStart(e) {" +
                        "  this.style.opacity = '0.4';" +

                        "  dragSrcEl = this;" +
                        "  e.dataTransfer.effectAllowed = 'move';" +
                        "  e.dataTransfer.setData('text/html', this.innerHTML);}" +
                        "function handleDragOver(e) {" +
                        "  if (e.preventDefault) {" +
                        "    e.preventDefault();" +
                        "  }" +
                        "  e.dataTransfer.dropEffect = 'move';" +

                        "  return false;" +
                        "}" +

                        "function handleDragEnter(e) {" +
                        "  this.classList.add('over');" +
                        "}" +
                        "function handleDragLeave(e) {" +
                        "  this.classList.remove('over');" +
                        "}" +
                        "function handleDrop(e) {" +
                        "  if (e.stopPropagation) {" +
                        "    e.stopPropagation();" +
                        "  }" +
                        "  if (dragSrcEl != this) {" +
                        "    dragSrcEl.innerHTML = this.innerHTML;" +
                        "    this.innerHTML = e.dataTransfer.getData('text/html');" +
                        "  }" +
                        "  return false;" +
                        "}" +
                        "function handleDragEnd(e) {" +
                        "  [].forEach.call(cols, function (col) {" +
                        "    col.classList.remove('over');" +
                        "  });" +
                        "  this.style.opacity = '1';" +
                        "}" +
                        "var cols = document.querySelectorAll('#columns .column');" +
                        "[].forEach.call(cols, function(col) {" +
                        "  col.addEventListener('dragstart', handleDragStart, false);" +
                        "  col.addEventListener('dragenter', handleDragEnter, false);" +
                        "  col.addEventListener('dragover', handleDragOver, false);" +
                        "  col.addEventListener('dragleave', handleDragLeave, false);" +
                        "  col.addEventListener('drop', handleDrop, false);" +
                        "  col.addEventListener('dragend', handleDragEnd, false);})";

        Object script = ((JavascriptExecutor) driver).executeScript(java_script, textElementA, textElementB);
        Thread.sleep(2000);
        Thread.sleep(2000);
        System.out.println(elementB.getText());




        softAssert.assertTrue(textElementB.getText().equalsIgnoreCase("A"), "The item didn't dragged and drop");

    }
    private void navigateDragAndDrop(){
        driver.get(ConfigReader.getProperty("url")+"/drag_and_drop");
    }
}

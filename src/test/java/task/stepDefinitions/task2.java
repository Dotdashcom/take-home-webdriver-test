package task.stepDefinitions;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import task.pages.CheckBoxesPage;
import task.pages.ContextMenuPage;
import task.pages.DragandDropPage;
import task.pages.DropdownPage;
import task.utilities.ConfigurationReader;
import task.utilities.Driver;

import java.util.ArrayList;
import java.util.List;


public class task2 {

  @Test
    public void checkBoxes (){
      CheckBoxesPage checkBoxesPage=new CheckBoxesPage();

      //CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
      Driver.getDriver().get(ConfigurationReader.getProperty("url")+"/checkboxes");
      checkBoxesPage.checkBox1.click();
      checkBoxesPage.checkBox2.click();

      Assert.assertTrue(checkBoxesPage.checkBox1.isSelected());
      Assert.assertTrue(checkBoxesPage.checkBox2.isEnabled());

  }



  @Test
    public void contextMenu () {
      ContextMenuPage contextMenu=new ContextMenuPage();

      //ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called
      // 'the-internet'. Test JavaScript alert text on Right-Click.

      Driver.getDriver().get(ConfigurationReader.getProperty("url")+"/context_menu");
      Actions actions=new Actions(Driver.getDriver());

      actions.moveToElement(contextMenu.contexMenuIcon).contextClick().build().perform();
      String actual=Driver.getDriver().switchTo().alert().getText();

     Assert.assertTrue(actual.contentEquals("You selected a context menu"));
       }




       @Test
    public void dragAndDrop (){
           DragandDropPage dragandDropPage=new DragandDropPage();

           // Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.

         Driver.getDriver().get(ConfigurationReader.getProperty("url")+"/drag_and_drop");

//           Actions action = new Actions(Driver.getDriver());
//           WebElement sourceElement = Driver.getDriver().findElement(By.id("column-a"));
//           WebElement targetElement = Driver.getDriver().findElement(By.id("column-a"));
//           action.dragAndDrop(sourceElement, targetElement);

//           Actions actions=new Actions(Driver.getDriver()) ;
//           Driver.getDriver().manage().window().maximize();
////         actions.dragAndDrop(Driver.getDriver().findElement(By.xpath("//div[./header[text()='A']]")),
////                 Driver.getDriver().findElement(By.xpath("//div[./header[text()='B']]"))).build().perform();
//         actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[./header[text()='A']]"))).clickAndHold().moveToElement(Driver.getDriver().findElement(By.xpath("//div[./header[text()='B']]"))).release().build().perform();
//           //Robot rb = new Robot();
           Actions builder = new Actions(Driver.getDriver());
           Action dragAndDrop = builder.clickAndHold(Driver.getDriver().findElement(By.xpath("//div[./header[text()='A']]")))
                   .moveToElement(Driver.getDriver().findElement(By.xpath("//div[./header[text()='B']]")))
                   .release(Driver.getDriver().findElement(By.xpath("//div[./header[text()='B']]")))
                   .build();

//Performing the drag and drop action
           dragAndDrop.perform();

           System.out.println("psss");




       }




       @Test
    public void dropdown (){
           DropdownPage dropdownPage=new DropdownPage();

           //  Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
           Driver.getDriver().get(ConfigurationReader.getProperty("url")+"/dropdown");

           Select select =new Select(dropdownPage.dropdown);

           select.selectByVisibleText("Option 1");

           String expected1="Option 1";
           String actual1 =select.getFirstSelectedOption().getText();
           Assert.assertEquals(expected1, actual1);

           select.selectByVisibleText("Option 2");

           String expected2="Option 2";
           String actual2=select.getFirstSelectedOption().getText();

           Assert.assertEquals(expected2, actual2);

       }



       @Test
    public void dynamicContent() throws InterruptedException {
           //Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
           Driver.getDriver().get(ConfigurationReader.getProperty("url")+"/dynamic_content");
           List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@id='content']/div[@class='row']"));
           List<String> contents = new ArrayList<>();
           elements.forEach(el -> contents.add(el.getText()));
           Driver.getDriver().navigate().refresh();
           Thread.sleep(2000);
           List<WebElement> elements2 = Driver.getDriver().findElements(By.xpath("//div[@id='content']/div[@class='row']"));
           List<String> contents2 = new ArrayList<>();
           elements2.forEach(el -> contents2.add(el.getText()));
           Assert.assertNotEquals(contents, contents2);





       }


    @After
    public void tearDown(){
        Driver.closeDriver();
    }

}

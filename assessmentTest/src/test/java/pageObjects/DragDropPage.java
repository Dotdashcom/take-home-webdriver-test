package pageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import baseClass.baseutils;

public class DragDropPage extends baseutils {

		//call baseutils class
		baseutils bu = new baseutils();
		
		//create a constructor
		public DragDropPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//locators for the A box
		@FindBy (xpath = "//div[@id='column-a']")
		WebElement BoxA;
		
		//locators for the B box
		@FindBy (xpath = "//div[@id='column-b']")
		WebElement BoxB;
				
		//drag and drop using actions class
		public void dragAndDrop() {
			try {
			      if (BoxA.isDisplayed() && BoxB.isDisplayed()) {
			            Actions action = new Actions(driver);
			            String boxANameBefore = BoxA.getText();
						String boxBNameBefore = BoxB.getText();
						System.out.println("--Box names before drag and drop--");
						System.out.println("for A : " + boxANameBefore + " and for B : " + boxBNameBefore);
			            action.dragAndDrop(BoxA, BoxB).build().perform();
			            String boxANameAfter = BoxA.getText();
						String boxBNameAfter = BoxB.getText() ;
						System.out.println("--Box names afer drag and drop are--");
						System.out.println("for A : " + boxANameAfter + " and for B : " + boxBNameAfter);
			        } else {
			            System.out.println("Element was not displayed to drag");
			        }
			    } catch (StaleElementReferenceException e) {
			        System.out.println("Element with " + BoxA + "or" + BoxB + "is not attached to the page document "
			                + e.getStackTrace());
			    } catch (NoSuchElementException e) {
			        System.out.println("Element " + BoxA + "or" + BoxB + " was not found in DOM "+ e.getStackTrace());
			    } catch (Exception e) {
			        System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
			    }
			}
		
		
		}



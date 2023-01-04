/**
 * 
 */
package com.testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author priyanka goswami
 * this is home page test file.
 *
 */


public class Home_Test {
	Home_Page hp=new Home_Page();
	
	
	  @BeforeMethod
	  public void setup() throws InterruptedException {
		 hp.setup();
	  }
	
	  @AfterMethod
	  public void tearDown() throws InterruptedException {
		 hp.tearDown();
	  }
	  
	  @Test
	  public void checkBox() throws InterruptedException {
		 hp.checkBox();
	  }
	  
		
		  @Test
		  public void contextMenu() { hp.contextMenu(); }
		 
	  
	  @Test
			public void dragAndDrop() throws InterruptedException {
				hp.dragAndDrop();
				
			}
	  
	  @Test
		public void dropDownOptions() throws InterruptedException {
			hp.dropDownOptions();
		}
	  @Test
		public void dynamicContent() {
			hp.dynamicContent();
		}
	  
	  @Test
		public void mouseHover() throws InterruptedException {
			hp.mouseHover();
		}
	  
	  @Test
		public void frame() throws InterruptedException {
			hp.frame();
		}
	  
	  @Test
			public void openInNewtab() throws InterruptedException {
				hp.openInNewTab();
			}
	  @Test
		public void notificationMessage() throws InterruptedException {
			hp.notificationMessage();
		}
	  @Test
	  public void dynamicLoading() throws InterruptedException {
			hp.dynamicLoading();
		}
	  @Test
	  public void dynamicControl() throws InterruptedException {
			hp.dynamicControl();
		}
	  @Test
	  public void fileDownload() throws InterruptedException {
			hp.fileDownload();
		}
	  @Test
	  public void fileUpload() throws InterruptedException {
			hp.fileUpload();
		}
	  @Test
	  public void floatingMenu() throws InterruptedException {
		  hp.floatingMenu();
	  }
	  @Test
	  public void javaScriptError() throws InterruptedException {
			hp.javaScriptError();
		}
	  
	  @Test
	  public void javaScriptAlert() throws InterruptedException {
			hp.javaScriptAlert();
		}
	  
}

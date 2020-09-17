package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.ContextClickPage;
import com.POM.DragAndDropPage;

public class DragAndDropTest extends dotDashBase  {
	WebDriver driver;


	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get(" http://localhost:7080/drag_and_drop"); //to open the site in the browser"
	}


	@Test 
	public void dragDrop(){
		DragAndDropPage dd = new DragAndDropPage(driver);
		dd.DragDrop();
		//this will compare the actual and expected result

	}



	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();


	}

}

package com.selenium.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentTest extends TestBase {

	@Test
	public void dragAndDrop() {

		driver.get("http://localhost:7080/dynamic_content");

		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		 // se almacena en una colección el texto del atributo src de las imagenes y
		 // luego se comparan las colecciones
	
		list1 = driver.findElements(By.cssSelector("#content img")).stream().map(e -> e.getAttribute("src"))
				.collect(Collectors.toList());

		driver.navigate().refresh();

		list2 = driver.findElements(By.cssSelector("#content img")).stream().map(e -> e.getAttribute("src"))
				.collect(Collectors.toList());

		boolean sameImages = list1.equals(list2);

		
		 //de igual manera que las imagenes se validan los textos
		
		list1 = driver.findElements(By.cssSelector(".large-centered .large-10")).stream().map(e -> e.getText())
				.collect(Collectors.toList());

		driver.navigate().refresh();

		list2 = driver.findElements(By.cssSelector(".large-centered .large-10")).stream().map(e -> e.getText())
				.collect(Collectors.toList());

		boolean sameText = list1.equals(list2);

		Assert.assertFalse((sameImages && sameText) ? true : false, "Neither the images or the text changed");

	}
}
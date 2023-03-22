package com.QA.testSteps;

import java.util.ArrayList;
import java.util.List;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Then;

public class stepsDynamicContent extends CommonMethods {

	public List<String> previousImages = new ArrayList<String>(), previousDescriptions = new ArrayList<String>();
	public int countOfDifferentImages, countOfDifferentDescriptions;

	@Then("refresh page {int} times and verify the content changes on each refresh")
	public void refresh_page_times_and_verify_the_content_changes_on_each_refresh(Integer integer) {

		for (int x = 0; x < integer; x++) {

			for (int i = 0; i < dynamicContent.images.size(); i++) {
				previousImages.add(i, dynamicContent.images.get(i).getAttribute("src"));
				previousDescriptions.add(i, dynamicContent.descriptions.get(i).getText());
			}

			driver.navigate().refresh();

			for (int i = 0; i < dynamicContent.images.size(); i++) {
				AA_Hooks.softAssert.assertNotEquals(dynamicContent.images.get(i).getAttribute("src"),
						previousImages.get(i));
				AA_Hooks.softAssert.assertNotEquals(dynamicContent.descriptions.get(i).getText(),
						previousDescriptions.get(i));
				if (!dynamicContent.images.get(i).getAttribute("src").equals(previousImages.get(i))) {
					countOfDifferentImages++;
				}
				if (!dynamicContent.descriptions.get(i).getText().equals(previousImages.get(i))) {
					countOfDifferentDescriptions++;
				}
			}
			System.out.println("Total images has beend changed: " + countOfDifferentImages);
			System.out.println("Total descriptions has been changed: " + countOfDifferentDescriptions);

			AA_Hooks.scenario.attach(CommonMethods.takeScreenshot("testDynamicContent/" + AA_Hooks.scenario.getName()),
					"image/png", AA_Hooks.scenario.getName());

		}

	}

}

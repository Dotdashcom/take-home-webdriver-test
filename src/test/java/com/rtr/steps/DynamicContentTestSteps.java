package com.rtr.steps;

import org.apache.commons.math3.ode.FirstOrderConverter;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DynamicContentTestSteps extends CommonMethods {

	@Given("I navigated to Dynamic Content website")
	public void i_navigated_to_dynamic_content_website() {
		setUp("/dynamic_content");

	}

	@Then("I refresh the page a couple of times and assert for each refresh.")
	public void i_refresh_the_page_a_couple_of_times_and_assert_for_each_refresh() {

		String firstContentc1 = dynamiccontent.c1.getText();
		String firstContentc2 = dynamiccontent.c2.getText();
		String firstContentc3 = dynamiccontent.c3.getText();

		driver.navigate().refresh();

		String secondContentc1 = dynamiccontent.c1.getText();
		String secondContentc2 = dynamiccontent.c2.getText();
		String secondContentc3 = dynamiccontent.c3.getText();

		if ((firstContentc1 == secondContentc1) && (firstContentc2 == secondContentc2)
				&& (firstContentc1 == secondContentc1)) {
			System.out.println("Test FAILED");
		} else {
			System.out.println("Test PASSED");
		}

		for (int i = 0; i <= 3; i++) {

			String LfirstContentc1 = dynamiccontent.c1.getText();
			String LfirstContentc2 = dynamiccontent.c2.getText();
			String LfirstContentc3 = dynamiccontent.c3.getText();

			driver.navigate().refresh();

			String LsecondContentc1 = dynamiccontent.c1.getText();
			String LsecondContentc2 = dynamiccontent.c2.getText();
			String LsecondContentc3 = dynamiccontent.c3.getText();

			if ((LfirstContentc1 == LsecondContentc1) && (LfirstContentc2 == LsecondContentc2)
					&& (LfirstContentc1 == LsecondContentc1)) {
				System.out.println("Test FAILED");
			} else {
				System.out.println("Test PASSED");
			}

		}
	}

}

Feature: Floating Menu Functinality

  @Test
  Scenario: user should be able to intarct with floating meny
    Given User Navigate to floating URL
    Then user compare the value of menu
      | menu    |
      | Home    |
      | News    |
      | Contact |
      | About   |

Feature: Login Operations

  @positive
  Scenario: As a user with valid credentials, I would like be able to login
      When User is on Login Portal
      And User enters valid credentials
      Then User is able to login and see the message "You logged into a secure area!" with an ability to dissmiss the message by clicking "×"



  @negative
  Scenario: As a user with invalid credentials, I would like to be prevented from login
      When User is on Login Portal
      And User enters invalid credentials as "Splunk" and "WireShark"
      Then User is should not be able to login and see the message "Your username is invalid!" with an ability to dissmiss the message by clicking "×"



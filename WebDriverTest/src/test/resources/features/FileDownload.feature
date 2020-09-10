#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: File Download

  File Download: http://localhost:7080/download Test File Download.

  Scenario: File Download

    Given user is on the Page "http://localhost:7080/download"
    When user clicks link to download file
    Then user sees file "some-file.txt" downloaded to the folder "/Users/robespierre/Downloads"
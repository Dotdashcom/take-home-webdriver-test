#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: File Upload

  File Upload: http://localhost:7080/upload Test File Upload.

  Scenario: File Upload

    Given user is on the Page "http://localhost:7080/upload"
    When user chooses the file "/Users/robespierre/Downloads/fileToUpload.txt" to upload and clicks on Upload button
    Then user sees "fileToUpload.txt" file successfully uploaded
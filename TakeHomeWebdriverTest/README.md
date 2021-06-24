Hi, my name is Abdullah Taqi. This is my submission for the QA excercise. 

I was having trouble running the tests using individual files from the pom.xml file as well as from the testng.xml file because the tests would start up opening a browser for each test but for some reason control would get lost and nothing would happen.

As a work around I added an AllTests.java file under src/main/java/tests which I put into the THWDTtestng.xml file by itself. It has all the tests from the individual files in it. When running the pom.xml file it works and executes all the tests without a problem.

Please change the chrome driver file path to yours in testBase/TestBase.java in the setup method before maven install and running the tests.

I was not able to get the Drag and Drop test to work using automation. Even though I put the correct source and destination the elements would not get switched.

FIX: I think the reason the build was failing was because the file path in the pom.xml for the suiteXmlFile was specified to my computer so I changed it to src\test\java\resources\THWDTtestng.xml. I tested it on my other computer and maven install worked. I think it should work now if you do maven install. 

FIX: I only had enough time to make one Page Object for the Login Page which is used in the Login Success and Login Failure Tests. 

Any feedback to help me improve is appreciated.

Thank you for this oppurtunity.

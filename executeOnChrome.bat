@echo OFF
echo ***Clean the Project***
cd.
Call mvn clean -Dmaven.clean.failOnError=false
cd.
echo ***Test Started***
Call mvn integration-test -P singlethread -Dmetafilter="" > ChromeExecutionLogs.txt | type ChromeExecutionLogs.txt
CALL mvn -P singlethread serenity:aggregate
echo ***Test Complete***
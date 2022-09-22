#!/bin/bash
@echo OFF
echo ***Clean the Project***
cd.
Call mvn clean -Dmaven.clean.failOnError=false
cd.
echo ***Test Started***
Call mvn integration-test -P singlethread -Dwebdriver.driver=chrome -Dmetafilter=""
CALL mvn -P singlethread serenity:aggregate
echo ***Test Complete***
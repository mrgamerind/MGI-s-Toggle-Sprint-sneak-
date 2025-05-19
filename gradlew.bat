@echo off
rem ------------------------------------------------------------------------------
rem
rem  Gradle start up script for Windows
rem
rem ------------------------------------------------------------------------------

set DIR=%~dp0
set APP_HOME=%DIR%

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar
java -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

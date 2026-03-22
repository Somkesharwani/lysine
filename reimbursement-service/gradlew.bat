@echo off
setlocal

set SCRIPT_DIR=%~dp0
for %%i in ("%SCRIPT_DIR%..") do set ROOT_DIR=%%~fi

set "TASK=%~1"
if "%TASK%"=="" set "TASK=build"
if not "%~1"=="" shift

call "%ROOT_DIR%\gradlew.bat" -p "%ROOT_DIR%" ":reimbursement-service:%TASK%" %*
exit /b %ERRORLEVEL%

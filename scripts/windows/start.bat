@echo off
set SCRIPT_DIR=%~dp0
cd /d "%SCRIPT_DIR%\..\.."

call mvnw.cmd spring-boot:run -Dmaven.test.skip=true

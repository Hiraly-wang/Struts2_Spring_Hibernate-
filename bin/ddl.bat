@echo off
echo [INFO] Use maven generate-ddl run the project.

cd %~dp0
cd ..

set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

mvn hibernate3:hbm2ddl -X

cd bin
pause
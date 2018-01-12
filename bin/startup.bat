@echo off

echo "**************************** 轻实训-项目案例 ****************************"

echo "[INFO] 项目启动..."

echo "[INFO] 项目启动成功后，请在浏览器中输入：http://localhost:6900/contact-ssh/"

cd ..

set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

call mvn jetty:run -Djetty.port=6900

cd bin
pause
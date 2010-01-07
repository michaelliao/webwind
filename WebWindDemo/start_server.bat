cd /d %~dp0
set PATH=%JAVA_HOME%\bin;%PATH%
java -classpath web\WEB-INF\classes;lib\jetty-6.1.22.jar;lib\jetty-util-6.1.22.jar;lib\commons-lang.jar;lib\commons-collections.jar;lib\servlet-api.jar;lib\hsqldb.jar org.expressme.webwind.demo.jetty.StartJetty
pause

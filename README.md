# System (E2E) tests of Scala application with Jacoco and Sonar test coverage

### Introduction
Simple scala application taken from Play Framework Scala examples:
https://github.com/playframework/play-samples/tree/2.7.x/play-scala-rest-api-example

#### Setup
- Have jacocoagent.jar file (it is in project directory in our case)
- Have pom.xml file to run jacoco tasks (also in project directory)
- Have local [sonar](https://www.sonarqube.org/downloads/) instance running (e.g. on port 9001)
- Create sonar project (scala-sonar in our case)
- [sonar-scanner](https://docs.sonarqube.org/latest/analysis/scan/sonarscanner/) should be added to PATH.
- Set sbt options:

```bash
export SBT_OPTS="-javaagent:jacocoagent.jar=destfile=jacoco-it.exec,output=file,append=true,dumponexit=true"
```
#### Run AUT and perform tests
Run scala application: 

```bash
sbt run
```
Application is up and running on localhost:9000  <br/>

At this point, we can run system e2e tests. Let's emulate some test case:
```bash
GET http://localhost:9000/v1/posts
```

#### Get results
In order to get jacoco report, we should stop application under test. <br/>
Generate Jacoco report with maven: 
```bash
mvn antrun:run@generate-report -Dskip.int.tests.report=false
```
In order to export jacoco report to Sonar, we should know path to jacoco coverage result xml file. 
It is target/coverage-report/coverage-report.xml.<br/>

```bash
sonar-scanner -Dsonar.projectKey=scala-sonar -Dsonar.sources=app -Dsonar.host.url=http://localhost:9001 -Dsonar.login=5ba67cce94830ebec270975bb32ede25868e0cc1 -Dsonar.coverage.jacoco.xmlReportPaths=target/coverage-report/coverage-report.xml
```
Sonar report is available at http://localhost:9001/dashboard?id=scala-sonar <br/>

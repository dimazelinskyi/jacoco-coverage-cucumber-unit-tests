# Jacoco configuration for unit and integration (Cucumber) tests

![alt text](./etc/jacoco_2.png "Junit Cucumber Jacoco")

***
#### 1. This is an example of how you can configure your jacoco reports for different levels of tests.
Two types of tests exist in this project-example: Unit tests (Junit framework) and Integration tests (Cucumber framwork).

***
#### 2. Configure jacoco agents for unit and integration tests ([pom.xml](./pom.xml#L75-L123))
```xml
<!-- Configuring and running Jacoco reports -->
<plugin>
   <groupId>org.jacoco</groupId>
   <artifactId>jacoco-maven-plugin</artifactId>
   <version>${jacoco-maven-plugin.version}</version>
   <executions>
       <execution>
           <id>pre-unit-test</id>
           <goals>
               <goal>prepare-agent</goal>
           </goals>
           <configuration>
               <destFile>${project.build.directory}/coverage-reports/jacoco.exec</destFile>
               <propertyName>surefireJacocoAgent</propertyName>
           </configuration>
       </execution>
       <execution>
           <id>pre-integration-test</id>
           <goals>
               <goal>prepare-agent-integration</goal>
           </goals>
           <configuration>
               <destFile>${project.build.directory}/coverage-reports/jacoco-it.exec</destFile>
               <propertyName>failsafeJacocoAgent</propertyName>
           </configuration>
       </execution>
       <execution>
           <id>post-unit-test</id>
           <phase>test</phase>
           <goals>
               <goal>report</goal>
           </goals>
           <configuration>
               <dataFile>${project.build.directory}/coverage-reports/jacoco.exec</dataFile>
               <outputDirectory>${project.reporting.outputDirectory}/jacoco</outputDirectory>
           </configuration>
       </execution>
       <execution>
           <id>post-integration-test</id>
           <goals>
               <goal>report-integration</goal>
           </goals>
           <configuration>
               <dataFile>${project.build.directory}/coverage-reports/jacoco-it.exec</dataFile>
               <outputDirectory>${project.reporting.outputDirectory}/jacoco-it</outputDirectory>
           </configuration>
       </execution>
   </executions>
</plugin>
```
***
#### 3. Add Jacoco agents to maven-surefire-plugin, cargo-maven2-plugin and maven-failsafe-plugin

* To maven-surefire-plugin [pom.xml](./pom.xml#L124-L132)
```xml
<!-- Running unit tests -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>${maven-surefire-plugin.version}</version>
    <configuration>
        <argLine>${surefireJacocoAgent}</argLine>
    </configuration>
</plugin>
```

* To cargo-maven2-plugin [pom.xml](./pom.xml#L204-L210)
```xml
<configuration>
  <properties>
      <cargo.servlet.port>9000</cargo.servlet.port>
      <cargo.logging>medium</cargo.logging>
      <cargo.jvmargs>${failsafeJacocoAgent}</cargo.jvmargs>
  </properties>
</configuration>
```

* To maven-failsafe-plugin [pom.xml](./pom.xml#L213-L227)
```xml
<!-- Running IT tests (Gherkin style) -->
<plugin>
   <artifactId>maven-failsafe-plugin</artifactId>
   <version>${maven-failsafe-plugin.version}</version>
   <executions>
       <execution>
           <goals>
               <goal>integration-test</goal>
               <goal>verify</goal>
           </goals>
           <configuration>
               <argLine>${failsafeJacocoAgent}</argLine>
           </configuration>
       </execution>
   </executions>
...
```

***
#### 3. To run example execute
```
mvn clean install -P acceptance-tests
```
* Reports are generetd into the folder `.target/site`:
![alt text](./etc/structure_reports_1.png "Folder reports structure")

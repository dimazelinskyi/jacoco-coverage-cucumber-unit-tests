# Jacoco configuration for unit and integration (Cucumber) tests

![alt text](./etc/jacoco_2.png "Junit Cucumber Jacoco")

#### 1. This is an example of how you can configure your jacoco reports for different levels of tests.

Two types of tests exist in this project-example: Unit tests (Junit framework) and Integration tests (Cucumber framwork).

#### 2. Configure jacoco agents for unit and integration tests
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
#### 2. Manen pom file

***
#### 3. Jacoco reports

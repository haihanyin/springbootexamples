## What is Spring Boot?
SpringBoot is an opinionated way of configuration.
[Spring Boot basics](https://developer.ibm.com/tutorials/j-spring-boot-basics-perry/#first-it-s-opinionated)

## What are the advantages of using Spring Boot?
less configuration, fast prototyping

## Why is it “opinionated”?
default libraries are chosen for you

## How does it work? How does it know what to configure?
depends on what is presented on the classpath

## What things affect what Spring Boot sets up?
Starters that are added to dependencies – only if @EnableAutoConfiguration or @SpringBoot application are used.

## How are properties defined? Where is Spring Boot’s default property source?
application.properties

## Would you recognize common Spring Boot annotations and configuration properties if you saw them in the exam?


## What is the difference between an embedded container and a WAR?
the embedded container works as a library
war file runs inside of a container 

## What embedded containers does Spring Boot support?
tomcat, jetty, undertow

## What does @EnableAutoConfiguration do?
configure application according to classpath jars

## What about @SpringBootApplication?
the combination of @EnableAutoConfiguration, @ComponentScan, @Configuration

## Does Spring Boot do component scanning? Where does it look by default?
yes, from the subpackages where the @SpringBootApplication is located

## What is a Spring Boot starter POM? Why is it useful?
groups a bunch of related dependencies, more readable and easier to remember

## Spring Boot supports both Java properties and YML files. Would you recognize and understand them if you saw them?
Yes

## Can you control logging with Spring Boot? How?
??
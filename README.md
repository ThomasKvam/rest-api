# Mestergruppen rest-api

## Table of contents
* [Features](#features)
* [Requirements](#requirements)
* [Technologies](#technologies)
* [Building](#building)
* [Testing](#testing)

## Features

## Requirements
* [Java 11](https://www.oracle.com/java/technologies/)
* [Docker](https://www.docker.com/)

## Technologies
This project have been created with the following technologies:
* [Gradle](https://gradle.org/)
* [Kotlin](https://kotlinlang.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [Hibernate](http://hibernate.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [OpenAPI 3.0](https://swagger.io/resources/open-api())
	
## Building
To build this project, checkout the code and use the supplied Gradle wrapper to build. 
Running the following code with download dependencies and build the entire project.

```
$ ./gradlew clean build
```

## Testing
To run all the included tests in this project, use following command. 
Test results are stored in binary format under `./build/test-results/tests`. 

```
$ ./gradlew clean test
```

## Running locally
First, start the PostgreSQL database in a docker container:
```
$ docker-compose -f development/docker-compose.yaml up -d
```

Then run this project in your favorite IDE or using the supplied gradle wrapper:

```
$ ./gradlew clean bootRun
```

Access swagger at http://localhost:8090/swagger-ui.html

## Data
Flyway is used for database migration and will insert testdata.

## Task
Create a REST API supporting
* CRUD for NobbProduct(s)
* List NobbProducts by NobbVaregruppe
* Search for NobbProducts by NobbNr and Varetekst containing a text

## Questions
* Describe potential issues when scaling, discuss possible solutions. 
* Describe the data model.
* Describe how the api can be secured.

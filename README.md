ClusteredData Warehouse
Build Status

Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals. One of customer stories is to accept deals details from and persist them into DB.

Java-Spring-boot
mysql
pre-installation
first need to download mysql i am using windows 34, we pull mysql image through docker composer windows/

java 17 and maven 3.9.2 
docker
Start code
Technical Specs :

Access to DB should be through JPA. For DB type.

1.Create table in Mysql

create database using docker composer file , and table ugrade to db once run
spring.jpa.hibernate.ddl-auto=update

the command are too easy first be sure you installed docker then

start docker  docker-compose.yml up -d

then wait second and the local adminer will run with 8080 port as in file etc..


2.java
here you need to be sure you downloaded java 17 i use intellij so i check it either with command line or intellij

java -version

in intellij go to file then project structure and set it to java 17

then use command to build to application

mvn clean install

the port here is 9090 so for postman use the localhost:9090/deal "the api "


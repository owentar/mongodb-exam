# MongoDB App

This project is a simple application to test mongodb with java.

## Application

It's a command line application with three main functionalities

 1. populate: populates the database with initial data (saves the data in 'population' collection)
 2. annualGrowth: calculate and show the two regions which have largest recent annual growth in population (saves the data in 'annualGrowth' collection)
 3. avgDeviation: based on the average rate of annual change in population for each region, calculates and 
show the top two deviations from that average (saves the data in 'averageRateGrowthDeviation' collection)

## Configuration

### MongoDB

MongoDB configuration can be found on src/main/resources/mongo.properties.

### Application

Main configuration of the application can be found on src/main/resources/ApplicationContext.xml

## Build:

Maven has to be insatlled and configured to build this project. Execute the following command:

    mvn clean package

## Execution

### With maven:

    mvn exec:java -Dexec.args=populate
    mvn exec:java -Dexec.args=annualGrowth
    mvn exec:java -Dexec.args=avgDeviation

### Java JAR file directly:

Once the project is built it can be executed with directly with following java commands:

    java -jar exam.jar populate
    java -jar exam.jar annualGrowth
    java -jar exam.jar avgDeviation
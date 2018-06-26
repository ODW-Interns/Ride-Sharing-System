# Ride-Sharing-Service
This ride sharing service will do 3 things. 
1. Keep track of inventory (cars), 
2. Keep track of personnel
3. Schedule, track, and evaluate ride cost


## Project Members
* Mark Constantine
* Wesley Dong
* Pete Tanthmanatham


## Project details
This will be an event [driven system](https://en.wikipedia.org/wiki/Event-driven_architecture).
At boot time, the sytem will be empty, and will require seeding. That seeding will read events from a file (see later sections) and pass them to the rest of the system. 

### build
* create the project using maven archetypes, to be built using java 8, j2se
* add slf4j logging
* add junit


### Structure
Proper data-modeling techniques need to be employed. Abstraction b/w people, cars, and rides need to take place. For example, there should be an Interface for car, and a concrete implementation for a car instantiation (with year, make, model, etc).

1. Break the project into the MVC mode
2. Ensure the model supports both abstract layers, as well as concrete. Ensure the concrete layers ARE NOT IN THE SAME PLACE (PACKAGE) as the abstraction
3. I should be able (with an event) to add cars,drivers,customers,pickups,etc.

### Architecture
![alt text](https://github.com/ODW-Interns/Ride-Sharing-System/blob/master/docs/Architecture.png "Architecture")


### Drivers
The company (the ride-sharing service) will have a staff of employees (drivers) that it needs to maintain. These employees can cycle on and off (quit and be re-hired) as they see fit.

### Pickups/Rides
Pickups, or rides, have to have 5 things.
1. A car
2. A driver
3. An origin location (longitude and latitude)
4. A destination location (longitude and latitude)
5. A customer profile

When scheduling a ride, you need to check for inventory of a car (make sure it's there), and drivers (make sure one is avaialble), before you can dispatch them to the location. Don't worry about keeping a catalog of locations or maps, rides will just go in a straight line b/w origin and destination. You will need to collect basic information about the rider as well (name/location).

The rider will be tracked (in memory for now) so we can see how many times she uses our services and therefore might be eligible for discounts. 


## Expected Input
Input will be injected into the system using a Functional Interface (Consumer) and will be broken into events. Events are defined in a delimited file, where the delimiter is a pipe.
Events should be, at a minimum:
1. Create/Modify/Delete a car
2. Create/Modify/Delete a driver
3. Create/Modify/Delete a scheduled pickup

### Create Formats
```
create|car|CAR_TYPE|MAKE|MODEL|COLOR|YEAR|\n
create|user|USER_TYPE|FIRST_NAME|LAST_NAME|SEX|AGE|\n
create|pickup|CUSTOMER_ID|ORIGIN_LATITUDE|ORIGIN_LONGITUDE|DESTINATION_LATITUDE|DESTINATION_LONGITUDE|\n
```
### Modify Formats
```
modify|car|CAR_ID|CAR_TYPE|MAKE|MODEL|COLOR|YEAR|\n
modify|user|USER_ID|driver|FIRST_NAME|LAST_NAME|SEX|AGE|AVAILABILITY|CAR_ID|\n
modify|user|USER_ID|customer|FIRST_NAME|LAST_NAME|SEX|AGE|\n
```
### Delete Formats
```
delete|car|CAR_ID|\n
delete|user|USER_ID|\n
delete|pickup|PICKUP_ID|\n
```
* Note, all input fields are strings excluding the following:
  * CAR_ID (INT)
  * USER_ID (INT)
  * CUSTOMER_ID (INT)
  * PICKUP_ID (INT)
  * YEAR (INT)
  * AGE (INT)
  * ORIGIN_LATITUDE (DOUBLE)
  * ORIGIN_LONGITUDE (DOUBLE)
  * DESTINATION_LATITUDE (DOUBLE)
  * DESTINATION_LONGITUDE (DOUBLE)
  * AVAILABILITY (BOOLEAN)
* Note, for the following formats below, any field in ALL_CAPS is meant to be replaced by actual field values in the input.
  * Also, our system is NOT case sensitive.
  * CAR_TYPE can be either Coupe/Sedan/Suv
  * USER_TYPE can be either Customer/Driver
  * It is expected that the ID is known ahead of time for any event requiring an ID.
   
### How to run
```
change directory to ride-sharing-service/
mvn package 
change directory to target/
java -jar ride-sharing-service-1.0.0-jar-with-dependencies.jar [INPUT_FILE_AND_PATH] 
java -jar ride-sharing-service-1.0.0-jar-with-dependencies.jar [INPUT_FILE_AND_PATH] [OUTPUT_FILES_DIRECTORY]
```

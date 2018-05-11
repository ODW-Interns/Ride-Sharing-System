# Uber-Employee-Tracker
A simple Maven project to collect, parse, process, and store information related to Uber employees.

## Expected Input
Input is to be expected from a file in CSV format.

## Expected Output
Information will be stored into an Oracle database.

### Class List
* _Input Class_ __(TODO: Rename)__
    * _This class will handle getting the input & parsing the information_
* _Database Class_ __(TODO: Rename)__
    * _This class will handle all the database-related stuff such as querying_
* _Logic Class_ __(TODO: Rename)__
    * _This class will handle all the processing required before sending out to a database_
    * Example calulations
      * __TODO__
* Transaction History (extends ArrayList)
    * List of Transaction
    * .getTotal()
* Car (Identity Class)
    * Make
    * Model
    * Miles
    * Type (4 door, etc..)
    * Condition
* Transaction (Identity Class)
    * Transation ID (unique)
    * Money paid
    * Start Time
    * End Time
    * Arrival Location
    * Destination Location
* Employee (Identity Class)
    * Name
    * Age
    * Salary
    * Rating

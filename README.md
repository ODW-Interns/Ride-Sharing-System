# Ride-Sharing-Service
A simple Maven project to collect, parse, process, and store information related to Uber employees.

## Project Members
* Mark
* Wesley
* Pete

## Expected Input
Input is to be expected from a file of the following format:
'''
EmployeeInfo|Transaction1Info|...|Transaction2Info
'''

## Expected Output
Information will be be passed off into a file of the following format:
'''
EmployeeName|Wage|Average
'''

## Simple UML
_Input Class_ --> _Logic Class_ --> _Database Class_

### Class List
* _InputParser_
    * _This class will handle getting the input & parsing the information._
    * _The employee part of the input will get passed into an EmployeeList (composed of Employee objects)._
    * _The transaction part of the input will get passed into an TransactionList (composed of Transaction objects)._
* _WageCalculator_
    * _This class will handle processing the wage and average._
* _EmployeeList_
    * _This class will hold Employee objects._
* _TransactionList_
    * _This class will hold Transaction objects._
* Transaction (Identity Class)
    * Transation ID (unique) [INT]
    * Money paid [INT]
    * Start Time [DATE Object(?)]
    * End Time [DATE Object(?)]
    * Miles Traveled [INT]
    * Customer [CUSTOMER Object]
* Employee (Identity Class)
    * Employee ID (unique) [INT]
    * Name [STRING]
    * Age [INT]
    * Gender [CHAR (?)]
    * Salary [INT]
    * Rating [INT]
    * Car [CAR Object]
* Customer (Identity Class)
    * Name [STRING]
* Car (Identity Class)
    * Make [STRING]
    * Model [STRING]
    * Color [STRING]
    * Miles [INT]
    * Type (4 door, etc..) [ENUM (?)]
    * Condition [ENUM (?)]

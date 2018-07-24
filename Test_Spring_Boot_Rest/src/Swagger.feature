Feature: Testing Swagger Hotels

Scenario: Testing a get request
Given the website exists
  When a user wants to view all hotels
   Then the status code reads 200
 
Scenario: Testing a post request
Given the website exists
 When the user creates a hotel
  Then the status code reads 201
  
Scenario: Testing specific get request
 Given the website exists
 And a hotel exists
  When a user wants specifc hotel 26
   Then the status code reads 200
   
Scenario: Testing put request
 Given the website exists
 And a hotel exists
  When user updates hotel 26
   Then the status code reads 204
   
   Scenario: Testing a delete request
Given the website exists
And a hotel exists
 When user deletes hotel 37
  Then the status code reads 204
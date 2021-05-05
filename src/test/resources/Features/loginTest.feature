Feature: Authenticate the login page

Scenario: Check login is successful for valid username and password

Given launch the web page
When you enter correct username and password and click login button
Then I should login successfully 

Scenario: Check login is failure for invalid username and password

Given launch the web page
When you enter wrong username and password and click login button
Then I should fail to login 

Scenario: Check login is failure for invalid username and correct password

Given launch the web page
When you enter wrong username and correct password and click login button
Then I should fail to login 

Scenario: Check login is failure for  correct username and  invalid password

Given launch the web page
When you enter correct username and wrong password and click login button
Then I should fail to login with wrong password
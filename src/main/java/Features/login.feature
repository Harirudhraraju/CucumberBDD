Feature: Free CRM Login Feature


#Without Example Keyword
#Scenario: Free CRM Login Test Scenario

#Given user is already on Login Page 
#When title of login page is Free CRM
#Then user enters "batchautomation" and "Test@12345"
#Then user clicks on login button	
#Then user is on home page

# With Examples Keyword

Scenario Outline: Free CRM Login Test Scenario

Given user is already on Login Page 
When  title of login page is Free CRM
Then  user enters "<username>" and "<password>"
Then  user clicks on login button	
Then  user is on home page
Then  close the browser


Examples:
     | username        | password    |
     | batchautomation | Test@12345  |
     | tom             | test456     |
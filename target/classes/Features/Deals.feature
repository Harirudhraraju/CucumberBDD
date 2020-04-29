Feature: Deal data Creation 

Scenario: Free CRM Create a Deals 

Given user is already on Login Page 
When title of login page is Free CRM
Then user enters username and password
| batchautomation  |   Test@12345   |
Then user clicks on login button	
Then user is on home page
Then user moves to new deal page 
Then user enters deal details
|  Test Deal  | 1000 | 50 | 10 |
Then close the browser

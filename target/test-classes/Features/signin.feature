Feature: To validate signin functionality in Target ecommerce Website
Background:
Given user should go to Target ecommerce homepage
When user should click signIn button and click on signIn link

Scenario: To validate signin functionality with invalid credentials
And user should enter invalid  email and password
Then user should click signIn button and get error message
Scenario: To validate signin functionality with valid credentials
And user should enter valid email and password
Then user should click signIn button and login successful

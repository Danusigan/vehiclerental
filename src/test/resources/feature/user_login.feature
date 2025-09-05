package vehicle1.example.vehiclerent.feature;

Feature: User Login
As a registered user
I want to login to my account
So that I can access the vehicle rental services

Scenario: Successful login with valid credentials
Given a user exists with name "john" and password "123"
When I submit a login request with name "john" and password "123"
Then the response status should be 200 OK
And the response should contain "Login successful!"

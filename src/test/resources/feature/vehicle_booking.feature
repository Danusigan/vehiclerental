@VehicleBooking
Feature: Vehicle Booking
As a registered user
I want to book a vehicle
So that I can rent a vehicle for my transportation needs

# Test scenario for successful vehicle booking

Scenario: Successful vehicle booking with valid credentials
Given I have a name "john" and password "123"
When I book the vehicle with vehicle ID "1"
Then the vehicle should be booked successfully

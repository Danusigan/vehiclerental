# BDD Tests for Vehicle Rental System

This directory contains Behavior-Driven Development (BDD) tests for the vehicle rental system using Cucumber with Java.

## Test Structure

### Feature Files
- `src/test/resources/feature/vehicle_booking.feature` - Contains the vehicle booking scenarios

### Step Definitions
- `src/test/java/vehicle1/example/vehiclerent/steps/VehicleBookingSteps.java` - Contains the step definitions for vehicle booking tests

### Test Runners
- `src/test/java/vehicle1/example/vehiclerent/runners/VehicleBookingCucumberTest.java` - Cucumber test runner for vehicle booking tests

## Test Scenarios

### Successful Vehicle Booking
**Scenario**: Successful vehicle booking with valid credentials
- **Given**: I have a name "testuser" and password "password123"
- **When**: I book the vehicle with vehicle ID "1"
- **Then**: The vehicle should be booked successfully

## How to Run the Tests

### Prerequisites
1. Make sure you have Maven installed
2. The tests will start their own application instance with a random port
3. No need to manually start the application before running tests
4. **Test Data**: Test users are created automatically during test execution

### Running the Tests

#### Option 1: Run via Maven Command
```bash
mvn test -Dtest=VehicleBookingCucumberTest
```

#### Option 2: Run via IDE
1. Open the `VehicleBookingCucumberTest.java` file
2. Right-click on the class name
3. Select "Run VehicleBookingCucumberTest"

#### Option 3: Run specific scenarios
```bash
mvn test -Dcucumber.filter.tags="@VehicleBooking"
```

## Test Configuration

The tests use the following configuration:
- **Database**: H2 in-memory database for testing
- **Profile**: `test` profile is activated
- **Port**: Random port (automatically assigned)
- **Configuration File**: `src/test/resources/application-test.properties`

## Test Data Setup

### Test Data Created During Tests
- **Users**: Created automatically for each test scenario
  - Valid user: "testuser" with password "password123"

## Test Reports

After running the tests, you can find the reports in:
- **HTML Report**: `target/cucumber-reports/vehicle-booking-report.html`
- **JSON Report**: `target/cucumber-reports/vehicle-booking-report.json`

## Understanding the Tests

### Step Definitions
The step definitions in `VehicleBookingSteps.java` handle:

1. **Given Steps**: Set up test data (users and vehicles)
2. **When Steps**: Perform the actual booking action via REST API
3. **Then Steps**: Verify the expected outcomes

### Test Data Management
- Each test scenario cleans up user data before execution
- Test users are created as needed for each scenario
- The tests use realistic booking data (dates, times, etc.)

### API Testing
The tests make actual HTTP requests to the booking API endpoint:
- **Endpoint**: `POST /api/bookings/create`
- **Content-Type**: `application/json`
- **Expected Response**: Success/failure messages with appropriate HTTP status codes

## Troubleshooting

### Common Issues

1. **Port Already in Use**: Tests use random ports, so this shouldn't be an issue
2. **Database Connection**: Ensure H2 dependencies are in the classpath
3. **Spring Context**: Make sure @CucumberContextConfiguration is properly configured

### Debug Mode
To run tests in debug mode, add the following to your IDE run configuration:
```
-Dspring.profiles.active=test
-Dlogging.level.vehicle1.example.vehiclerent=DEBUG
```

## Adding New Scenarios

To add new test scenarios:

1. **Add to Feature File**: Add new scenarios to `vehicle_booking.feature`
2. **Implement Steps**: Add corresponding step definitions in `VehicleBookingSteps.java`
3. **Run Tests**: Execute the tests to verify the new scenarios work

## BDD Best Practices

1. **Clear Scenarios**: Write scenarios that are easy to understand
2. **Independent Tests**: Each scenario should be independent
3. **Proper Cleanup**: Always clean up test data
4. **Meaningful Assertions**: Verify both positive and negative outcomes
5. **Realistic Data**: Use realistic test data that represents real usage

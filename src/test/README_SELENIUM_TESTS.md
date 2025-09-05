# Selenium UI Tests for Vehicle Rental System

This directory contains Selenium WebDriver UI tests for the vehicle rental system using Java and Spring Boot.

## Test Structure

### UI Test Classes
- `src/test/java/vehicle1/example/vehiclerent/selenium/LoginUITest.java` - Login functionality tests
- `src/test/java/vehicle1/example/vehiclerent/selenium/RegisterUITest.java` - User registration tests

## Test Scenarios

### 1. Login UI Tests (`LoginUITest.java`)

#### Test: Successful Login
- **Description**: Tests successful login with valid credentials
- **Steps**:
  1. Navigate to `/login` page
  2. Enter valid username and password
  3. Submit login form
  4. Verify successful login (redirect or success message)

#### Test: Failed Login with Invalid Credentials
- **Description**: Tests login failure with invalid credentials
- **Steps**:
  1. Navigate to `/login` page
  2. Enter invalid username and password
  3. Submit login form
  4. Verify error message is displayed

### 2. Registration UI Tests (`RegisterUITest.java`)

#### Test: Successful Registration
- **Description**: Tests successful user registration
- **Steps**:
  1. Navigate to `/register` page
  2. Fill all required fields with valid data
  3. Submit registration form
  4. Verify successful registration (redirect or success message)

#### Test: Failed Registration with Invalid Data
- **Description**: Tests registration failure with empty/invalid fields
- **Steps**:
  1. Navigate to `/register` page
  2. Leave required fields empty
  3. Submit registration form
  4. Verify validation error messages

#### Test: Registration with Duplicate Username
- **Description**: Tests registration failure with existing username
- **Steps**:
  1. Navigate to `/register` page
  2. Enter username that already exists
  3. Fill other fields with valid data
  4. Submit registration form
  5. Verify duplicate username error

## Prerequisites

1. **Java 17+** and **Maven** installed
2. **Chrome Browser** installed (for ChromeDriver)
3. **Spring Boot Application** running (tests will start their own instance)

## Dependencies

The following dependencies are automatically added to `pom.xml`:
- `selenium-java` (v4.15.0) - Selenium WebDriver
- `webdrivermanager` (v5.6.2) - Automatic driver management

## How to Run the Tests

### Option 1: Run via Maven Command
```bash
# Run all Selenium tests
mvn test -Dtest="*UITest"

# Run specific test class
mvn test -Dtest=LoginUITest
mvn test -Dtest=RegisterUITest

# Run specific test method
mvn test -Dtest=LoginUITest#testSuccessfulLogin
```

### Option 2: Run via IDE
1. Open the test class (e.g., `LoginUITest.java`)
2. Right-click on the class name or specific test method
3. Select "Run Test"

## Test Configuration

### Chrome Options
- **Headless Mode**: Tests run without opening browser window (CI/CD friendly)
- **Window Size**: 1920x1080 for consistent testing
- **Security**: Disabled sandbox and GPU for stability

### WebDriver Setup
- **Automatic Driver Management**: WebDriverManager handles ChromeDriver installation
- **Wait Strategy**: Explicit waits with 10-second timeout
- **Port Management**: Random port assignment to avoid conflicts

## Test Data

### Login Tests
- **Valid Credentials**: `testuser` / `password123`
- **Invalid Credentials**: `invaliduser` / `wrongpassword`

### Registration Tests
- **Unique Username**: Generated with timestamp to avoid conflicts
- **Test Data**: Realistic phone numbers and NIC/Passport values

## Expected Page Elements

### Login Page (`/login`)
- Input field with `name="username"`
- Input field with `name="password"`
- Submit button with `type="submit"`

### Registration Page (`/register`)
- Input field with `name="name"`
- Input field with `name="phoneNumber"`
- Input field with `name="password"`
- Input field with `name="nicOrPassport"`
- Submit button with `type="submit"`

## Success/Error Indicators

### Success Indicators
- URL redirect (e.g., `/dashboard`, `/login`)
- CSS class: `success`
- Text content: `Welcome`, `Registration successful`

### Error Indicators
- CSS class: `error`, `alert-danger`, `validation-error`
- Text content: `Invalid`, `Failed`, `required`, `already exists`

## Troubleshooting

### Common Issues

1. **ChromeDriver Not Found**
   - Solution: WebDriverManager automatically downloads the correct driver
   - Ensure Chrome browser is installed

2. **Element Not Found**
   - Check if page structure matches expected selectors
   - Verify page loads completely before test execution

3. **Test Failures**
   - Check console output for detailed error messages
   - Verify application is accessible on the test port

### Debug Mode
To run tests with visible browser:
```java
// Remove or comment out this line in setUp() method:
// options.addArguments("--headless");
```

## Best Practices

1. **Explicit Waits**: Always use explicit waits for dynamic elements
2. **Unique Test Data**: Generate unique data to avoid conflicts
3. **Cleanup**: Tests automatically clean up WebDriver resources
4. **Headless Mode**: Use headless mode for CI/CD environments
5. **Error Handling**: Graceful handling of missing elements or timeouts

## Adding New UI Tests

To add new UI test scenarios:

1. **Create Test Class**: Extend existing pattern with `@SpringBootTest`
2. **Setup WebDriver**: Use `@BeforeEach` for driver initialization
3. **Implement Test Methods**: Use `@Test` annotation
4. **Cleanup Resources**: Use `@AfterEach` for driver cleanup
5. **Follow Naming Convention**: `test[ScenarioName]` for test methods

## Integration with CI/CD

The tests are configured for CI/CD environments:
- **Headless Mode**: No browser window required
- **Automatic Port Assignment**: No port conflicts
- **WebDriver Management**: Automatic driver installation
- **Spring Boot Integration**: Self-contained test environment

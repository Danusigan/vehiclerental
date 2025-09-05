//package vehicle1.example.vehiclerent.selenium;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//import java.time.Duration;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class RegisterUITest {
//
//    @LocalServerPort
//    private int port;
//
//    private WebDriver driver;
//    private WebDriverWait wait;
//    private String baseUrl;
//
//    @BeforeEach
//    public void setUp() {
//        // Setup WebDriverManager
//        WebDriverManager.chromedriver().setup();
//
//        // Set up Chrome options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // Run in headless mode for CI/CD
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--window-size=1920,1080");
//
//        // Initialize WebDriver
//        driver = new ChromeDriver(options);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Set base URL
//        baseUrl = "http://localhost:" + port;
//
//        System.out.println("Register UI Test - Server running on port: " + port);
//    }
//
//    @Test
//    public void testSuccessfulRegistration() {
//        // Navigate to registration page
//        driver.get(baseUrl + "/register");
//        System.out.println("Navigated to registration page: " + driver.getCurrentUrl());
//
//        // Wait for page to load
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//        // Generate unique username to avoid conflicts
//        String uniqueUsername = "testuser" + System.currentTimeMillis();
//
//        // Find registration form elements
//        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
//        WebElement phoneField = driver.findElement(By.name("phoneNumber"));
//        WebElement passwordField = driver.findElement(By.name("password"));
//        WebElement nicField = driver.findElement(By.name("nicOrPassport"));
//        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        // Clear fields and enter registration data
//        nameField.clear();
//        nameField.sendKeys(uniqueUsername);
//
//        phoneField.clear();
//        phoneField.sendKeys("1234567890");
//
//        passwordField.clear();
//        passwordField.sendKeys("password123");
//
//        nicField.clear();
//        nicField.sendKeys("NIC123456789");
//
//        // Click register button
//        registerButton.click();
//
//        // Wait for successful registration (redirect or success message)
//        try {
//            // Check if redirected to login page or shows success message
//            wait.until(ExpectedConditions.or(
//                ExpectedConditions.urlContains("/login"),
//                ExpectedConditions.presenceOfElementLocated(By.className("success")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Registration successful')]")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Welcome')]"))
//            ));
//
//            System.out.println("Registration successful - Current URL: " + driver.getCurrentUrl());
//            assertTrue(true, "Registration should be successful");
//
//        } catch (Exception e) {
//            // If no specific success indicator, check if we're not on registration page
//            String currentUrl = driver.getCurrentUrl();
//            assertFalse(currentUrl.contains("/register"), "Should not remain on registration page after successful registration");
//            System.out.println("Registration successful - Redirected to: " + currentUrl);
//        }
//    }
//
//    @Test
//    public void testFailedRegistrationWithInvalidData() {
//        // Navigate to registration page
//        driver.get(baseUrl + "/register");
//        System.out.println("Navigated to registration page: " + driver.getCurrentUrl());
//
//        // Wait for page to load
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//        // Find registration form elements
//        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
//        WebElement phoneField = driver.findElement(By.name("phoneNumber"));
//        WebElement passwordField = driver.findElement(By.name("password"));
//        WebElement nicField = driver.findElement(By.name("nicOrPassport"));
//        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        // Clear fields and enter invalid data (empty fields)
//        nameField.clear();
//        phoneField.clear();
//        passwordField.clear();
//        nicField.clear();
//
//        // Click register button
//        registerButton.click();
//
//        // Wait for validation error messages
//        try {
//            wait.until(ExpectedConditions.or(
//                ExpectedConditions.presenceOfElementLocated(By.className("error")),
//                ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")),
//                ExpectedConditions.presenceOfElementLocated(By.className("validation-error")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'required')]")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'invalid')]"))
//            ));
//
//            System.out.println("Registration failed as expected - Validation error displayed");
//            assertTrue(true, "Validation error should be displayed for invalid data");
//
//        } catch (Exception e) {
//            // If no specific error indicator, check if we're still on registration page
//            String currentUrl = driver.getCurrentUrl();
//            assertTrue(currentUrl.contains("/register"), "Should remain on registration page after failed registration");
//            System.out.println("Registration failed as expected - Remained on registration page");
//        }
//    }
//
//    @Test
//    public void testRegistrationWithDuplicateUsername() {
//        // Navigate to registration page
//        driver.get(baseUrl + "/register");
//        System.out.println("Navigated to registration page: " + driver.getCurrentUrl());
//
//        // Wait for page to load
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//        // Use a username that might already exist
//        String existingUsername = "existinguser";
//
//        // Find registration form elements
//        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
//        WebElement phoneField = driver.findElement(By.name("phoneNumber"));
//        WebElement passwordField = driver.findElement(By.name("password"));
//        WebElement nicField = driver.findElement(By.name("nicOrPassport"));
//        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        // Clear fields and enter registration data
//        nameField.clear();
//        nameField.sendKeys(existingUsername);
//
//        phoneField.clear();
//        phoneField.sendKeys("9876543210");
//
//        passwordField.clear();
//        passwordField.sendKeys("password123");
//
//        nicField.clear();
//        nicField.sendKeys("NIC987654321");
//
//        // Click register button
//        registerButton.click();
//
//        // Wait for duplicate username error message
//        try {
//            wait.until(ExpectedConditions.or(
//                ExpectedConditions.presenceOfElementLocated(By.className("error")),
//                ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'already exists')]")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'duplicate')]")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'taken')]"))
//            ));
//
//            System.out.println("Registration failed as expected - Duplicate username error displayed");
//            assertTrue(true, "Error should be displayed for duplicate username");
//
//        } catch (Exception e) {
//            // If no specific error indicator, check if we're still on registration page
//            String currentUrl = driver.getCurrentUrl();
//            assertTrue(currentUrl.contains("/register"), "Should remain on registration page after failed registration");
//            System.out.println("Registration failed as expected - Remained on registration page");
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

class RegisterUITest {
    WebDriver browser;

    @BeforeEach
    void beforeEach() {
        var options = new FirefoxOptions();
        options.addArguments("--safe-mode");
        options.setCapability("webSocketUrl", true);
        browser = new FirefoxDriver(options);
    }

    @Test
    void googleTest() throws InterruptedException {
        browser.get("http://localhost:3001/Register");


        var firstnameBox=browser.findElement(By.cssSelector("input[placeholder='Enter Your Username']"));
        firstnameBox.sendKeys("arune");


        var phonenumberBox=browser.findElement(By.cssSelector("input[placeholder='Enter your phone number']"));
        phonenumberBox.sendKeys("076213123");

        var passwordBox=browser.findElement(By.cssSelector("input[placeholder='Enter your Password']"));
        passwordBox.sendKeys("1234");

        var cpasswordBox=browser.findElement(By.cssSelector("input[placeholder='Confirm Password"));
        cpasswordBox.sendKeys("1234");
        Thread.sleep(1000);

        var nicBox=browser.findElement(By.cssSelector("input[placeholder='NIC number"));
        nicBox.sendKeys("123434242");

        WebElement checkbox = browser.findElement(By.cssSelector("input[type='checkbox']"));
        if (!checkbox.isSelected()) {  // Check if the checkbox is not already checked
            checkbox.click();  // Click to tick it
        }
        browser.findElement(By.cssSelector("button.Register_btn")).click();

//        browser.get("https://demoqa.com/buttons");
//        browser.findElement(By.xpath("//button[text()='Click Me']")).click();
//        var textt=browser.findElement(By.id("dynamicClickMessage")).getText();
//        System.out.println(textt);
//        assertEquals("dynamicClickMessage", textt);
    }

    @AfterEach
    void afterEach() {
//        browser.close();
    }
}

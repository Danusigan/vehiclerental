package vehicle1.example.vehiclerent.selenium;
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
//public class LoginUITest {
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
//        System.out.println("Login UI Test - Server running on port: " + port);
//    }
//
//    @Test
//    public void testSuccessfulLogin() {
//        // Navigate to login page
//        driver.get(baseUrl + "/login");
//        System.out.println("Navigated to login page: " + driver.getCurrentUrl());
//
//        // Wait for page to load
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//        // Find login form elements
//        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
//        WebElement passwordField = driver.findElement(By.name("password"));
//        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        // Clear fields and enter credentials
//        usernameField.clear();
//        usernameField.sendKeys("testuser");
//
//        passwordField.clear();
//        passwordField.sendKeys("password123");
//
//        // Click login button
//        loginButton.click();
//
//        // Wait for successful login (redirect or success message)
//        try {
//            // Check if redirected to dashboard or shows success message
//            wait.until(ExpectedConditions.or(
//                ExpectedConditions.urlContains("/dashboard"),
//                ExpectedConditions.presenceOfElementLocated(By.className("success")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Welcome')]"))
//            ));
//
//            System.out.println("Login successful - Current URL: " + driver.getCurrentUrl());
//            assertTrue(true, "Login should be successful");
//
//        } catch (Exception e) {
//            // If no specific success indicator, check if we're not on login page
//            String currentUrl = driver.getCurrentUrl();
//            assertFalse(currentUrl.contains("/login"), "Should not remain on login page after successful login");
//            System.out.println("Login successful - Redirected to: " + currentUrl);
//        }
//    }
//
//    @Test
//    public void testFailedLoginWithInvalidCredentials() {
//        // Navigate to login page
//        driver.get(baseUrl + "/login");
//        System.out.println("Navigated to login page: " + driver.getCurrentUrl());
//
//        // Wait for page to load
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//        // Find login form elements
//        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
//        WebElement passwordField = driver.findElement(By.name("password"));
//        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        // Clear fields and enter invalid credentials
//        usernameField.clear();
//        usernameField.sendKeys("invaliduser");
//
//        passwordField.clear();
//        passwordField.sendKeys("wrongpassword");
//
//        // Click login button
//        loginButton.click();
//
//        // Wait for error message
//        try {
//            wait.until(ExpectedConditions.or(
//                ExpectedConditions.presenceOfElementLocated(By.className("error")),
//                ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Invalid')]")),
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Failed')]"))
//            ));
//
//            System.out.println("Login failed as expected - Error message displayed");
//            assertTrue(true, "Error message should be displayed for invalid credentials");
//
//        } catch (Exception e) {
//            // If no specific error indicator, check if we're still on login page
//            String currentUrl = driver.getCurrentUrl();
//            assertTrue(currentUrl.contains("/login"), "Should remain on login page after failed login");
//            System.out.println("Login failed as expected - Remained on login page");
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
/*
 * This source file was generated by the Gradle 'init' task
 */


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

class LoginUITest {
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
         browser.get("http://localhost:3001/Login");
         Thread.sleep(5000);

         var firstnameBox=browser.findElement(By.cssSelector("input[placeholder='Username']"));
         firstnameBox.sendKeys("arun");
         Thread.sleep(1000);

        var passwordBox=browser.findElement(By.cssSelector("input[placeholder='Password']"));
        passwordBox.sendKeys("12345");
        Thread.sleep(1000);
        browser.findElement(By.cssSelector("button.login_btn")).click();
        Thread.sleep(5000);
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

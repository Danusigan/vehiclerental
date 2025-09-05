package vehicle1.example.vehiclerent.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vehicle1.example.vehiclerent.controller.UserController;
import vehicle1.example.vehiclerent.model.User;
import vehicle1.example.vehiclerent.service.Userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserController userController;

    @MockBean
    private Userservice userService;

    @Test
    public void shouldReturn201WhenAddingValidUser() {
        // Arrange
        User newUser = new User();
        newUser.setName("john");
        newUser.setPhoneNumber("0763545232");
        newUser.setPassword("123");
        newUser.setNicOrPassport("13213213123");

        User savedUser = new User();
        savedUser.setName("john");
        savedUser.setPhoneNumber("0763545232");
        savedUser.setNicOrPassport("13213213123");

        when(userService.registerUser(any(User.class))).thenReturn(savedUser);

        // Act
        ResponseEntity<User> response = userController.registerUser(newUser);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode()); // Check for 201 status
        assertNotNull(response.getBody());
        assertEquals("john", response.getBody().getName());
    }

    @Test
    public void shouldReturn400WhenAddingEmptyName() {
        // Arrange
        User newUser = new User();
        newUser.setName(""); // Empty name
        newUser.setPhoneNumber("0763545232");
        newUser.setPassword("123");
        newUser.setNicOrPassport("13213213123");

        // Act
        ResponseEntity<User> response = userController.registerUser(newUser);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode()); // Check for 400 status
    }

    @Test
    public void shouldReturn400WhenAddingEmptyPassword() {
        // Arrange
        User newUser = new User();
        newUser.setName("john"); // Null name
        newUser.setPhoneNumber("0763545232");
        newUser.setPassword("");
        newUser.setNicOrPassport("13213213123");

        // Act
        ResponseEntity<User> response = userController.registerUser(newUser);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode()); // Check for 400 status
    }
}
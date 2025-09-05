package vehicle1.example.vehiclerent.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vehicle1.example.vehiclerent.service.Userservice;
import vehicle1.example.vehiclerent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3001")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private Userservice userService;

    @PostMapping("/register")
//    public User registerUser(@RequestBody User user) {
//        return userService.registerUser(user);
//    }
   public ResponseEntity<User> registerUser(@RequestBody User user) {
    if (user.getPassword().isEmpty()  || user.getName().isEmpty()) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Return 400 if name is empty
    }
    User savedUser = userService.registerUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED); // Return 201 if user is created
}

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        Optional<User> userOpt = userService.findByName(loginRequest.getName());
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(loginRequest.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }

    @PutMapping("/updatePassword")
    public String updatePassword(@RequestBody User updatePasswordRequest) {
        Optional<User> userOpt = userService.findByName(updatePasswordRequest.getName());
        if (userOpt.isPresent()) {
            userService.updatePassword(userOpt.get(), updatePasswordRequest.getNewPassword());
            return "Password updated successfully!";
        } else {
            return "User not found!";
        }
    }

    @DeleteMapping("/deleteAccount")
    public String deleteAccount(@RequestBody User request) {  // Changed to handle DeleteAccountRequest
        Optional<User> userOpt = userService.findByName(request.getName());  // Access name from the request
        if (userOpt.isPresent()) {
            userService.deleteUser(userOpt.get());
            return "Account deleted successfully!";
        } else {
            return "User not found!";
        }
    }
}

class LoginRequest {
    private String name;
    private String password;

    // Getters and Setters
}

class UpdatePasswordRequest {
    private String name;
    private String newPassword;

    // Getters and Setters
}

class request{
    private String name;
}

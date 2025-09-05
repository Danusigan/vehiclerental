//package vehicle1.example.vehiclerent.ui;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import vehicle1.example.vehiclerent.controller.UserController;
//import vehicle1.example.vehiclerent.model.User;
//import vehicle1.example.vehiclerent.service.Userservice;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////@WebMvcTest(UserController.class)
////public class Usercontrollertest {
////
////    @Autowired
////    private MockMvc mockMvc;
////
////    @Autowired
////    private ObjectMapper objectMapper;
////
////    @MockBean
////    private Userservice userService;
////
////    @Test
////    @DisplayName("register: returns saved user with 200 OK")
////    void register_returnsSavedUser() throws Exception {
////        User request = new User();
////        request.setId(1L);
////        request.setName("arun");
////        request.setPhoneNumber("0763545232");
////        request.setPassword("123");
////        request.setNicOrPassport("13213213123");
////
////        when(userService.registerUser(any(User.class))).thenReturn(request);
////
////        mockMvc.perform(
////                post("/api/users/register")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(request))
////        )
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.name").value("arun"));
////    }
////
////    @Test
////    @DisplayName("login: success with correct credentials")
////    void login_success() throws Exception {
////        User existing = new User();
////        existing.setId(1L);
////        existing.setName("John");
////        existing.setPassword("123");
////
////        when(userService.findByName("John")).thenReturn(Optional.of(existing));
////
////        User login = new User();
////        login.setName("John");
////        login.setPassword("123");
////
////        mockMvc.perform(
////                post("/api/users/login")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(login))
////        )
////                .andExpect(status().isOk())
////                .andExpect(content().string("Login successful!"));
////    }
////
////    @Test
////    @DisplayName("login: failure with wrong password")
////    void login_failure_wrongPassword() throws Exception {
////        User existing = new User();
////        existing.setId(1L);
////        existing.setName("John");
////        existing.setPassword("correct");
////
////        when(userService.findByName("John")).thenReturn(Optional.of(existing));
////
////        User login = new User();
////        login.setName("John");
////        login.setPassword("wrong");
////
////        mockMvc.perform(
////                post("/api/users/login")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(login))
////        )
////                .andExpect(status().isOk())
////                .andExpect(content().string("Invalid credentials!"));
////    }
////}
//@SpringBootTest
//public class Usercontrollertest {
//
//    @Autowired
//    private UserController userController;
//
//    @MockBean
//    private Userservice userService;
//
//    @Test
//    public void shouldReturn201WhenAddingValidUser() {
//        // Arrange
//        User newUser = new User();
//        newUser.setName("John");
//        newUser.setPhoneNumber("0763545232");
//        newUser.setPassword("123");
//        newUser.setNicOrPassport("13213213123");
//
//        User savedUser = new User();
//        savedUser.setId(1L);
//        savedUser.setName("John");
//        savedUser.setPhoneNumber("0763545232");
//        savedUser.setNicOrPassport("13213213123");
//
//        when(userService.registerUser(any(User.class))).thenReturn(savedUser);
//
//        // Act
//        User response = userController.registerUser(newUser);
//
//        // Assert
//        assertNotNull(response);
//        assertEquals("John", response.getName());
//        assertEquals("0763545232", response.getPhoneNumber());
//        assertEquals("13213213123", response.getNicOrPassport());
//    }
//
//    @Test
//    public void shouldReturn404WhenAddingnullname() {
//        // Arrange
//        User newUser = new User();
//        newUser.setName("");
//        newUser.setPhoneNumber("0763545232");
//        newUser.setPassword("123");
//        newUser.setNicOrPassport("13213213123");
//
//        User savedUser = new User();
//        savedUser.setId(1L);
//        savedUser.setName("");
//        savedUser.setPhoneNumber("0763545232");
//        savedUser.setNicOrPassport("13213213123");
//
//        when(userService.registerUser(any(User.class))).thenReturn(savedUser);
//
//        // Act
//        User response = userController.registerUser(newUser);
//
//        // Assert
//        assertNotNull(response);
//        assertEquals("John", response.getName());
//        assertEquals("0763545232", response.getPhoneNumber());
//        assertEquals("13213213123", response.getNicOrPassport());
//    }
//}

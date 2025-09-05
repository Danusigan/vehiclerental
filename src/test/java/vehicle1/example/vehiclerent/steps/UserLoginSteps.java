//package vehicle1.example.vehiclerent.steps;
//
//import io.cucumber.java.en.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import vehicle1.example.vehiclerent.model.User;
//import vehicle1.example.vehiclerent.repository.UserRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class UserLoginSteps {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private UserRepository userRepository; // Assuming you have a repository
//
//    private User loginRequest;
//    private ResponseEntity<String> response;
//    private final String baseUrl = "http://localhost:8080/api/users";
//
//    @Before
//    public void setup() {
//        loginRequest = null;
//        response = null;
//        // Clean up test data before each scenario
//        userRepository.deleteAll();
//    }
//
//    @Given("a user exists with name {string} and password {string}")
//    public void a_user_exists_with_name_and_password(String username, String password) {
//        // Create and save a test user in the database
//        User testUser = new User();
//        testUser.setName(username);
//        testUser.setPassword(password);
//        testUser.setPhoneNumber("1234567890");
//        testUser.setNicOrPassport("NIC123456789");
//
//        userRepository.save(testUser);
//
//        // Verify the user was saved
//        assertTrue(userRepository.findByName(username).isPresent());
//    }
//
//    @When("I submit a login request with name {string} and password {string}")
//    public void i_submit_a_login_request_with_name_and_password(String username, String password) throws Exception {
//        loginRequest = new User();
//        loginRequest.setName(username);
//        loginRequest.setPassword(password);
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        String requestJson = objectMapper.writeValueAsString(loginRequest);
//        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
//
//        response = restTemplate.exchange(
//                baseUrl + "/login",
//                HttpMethod.POST,
//                entity,
//                String.class
//        );
//    }
//
//    @Then("the response status should be {int} {string}")
//    public void the_response_status_should_be(int statusCode, String statusText) {
//        assertEquals(statusCode, response.getStatusCodeValue());
//        assertEquals(statusText, response.getStatusCode().getReasonPhrase());
//    }
//
//    @Then("the response should contain {string}")
//    public void the_response_should_contain(String expectedContent) {
//        assertTrue(response.getBody().contains(expectedContent));
//    }
//}
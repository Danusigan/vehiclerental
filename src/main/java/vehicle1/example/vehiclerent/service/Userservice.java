package vehicle1.example.vehiclerent.service;



import vehicle1.example.vehiclerent.model.User;
import vehicle1.example.vehiclerent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public void updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}


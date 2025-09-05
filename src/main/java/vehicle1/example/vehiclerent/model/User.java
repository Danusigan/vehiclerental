package vehicle1.example.vehiclerent.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private String password;
    @Column(name = "nicOrPassport")
    private String nicOrPassport;

    public User() {
    }

    // Constructor with all fields
    public User(Long id, String name, String phoneNumber, String password, String nicOrPassport) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nicOrPassport = nicOrPassport;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getNicOrPassport() {
        return nicOrPassport;
    }

    public String getNewPassword() {
        return password;
    }
    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setNewPassword(String password) {
        this.password = password;
    }

    public void setNicOrPassport(String nicOrPassport) {
        this.nicOrPassport = nicOrPassport;
    }


}

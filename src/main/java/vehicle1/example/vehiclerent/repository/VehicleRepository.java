package vehicle1.example.vehiclerent.repository;



import vehicle1.example.vehiclerent.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findById(Long vehicleId);
}


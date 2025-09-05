package vehicle1.example.vehiclerent.repository;



import vehicle1.example.vehiclerent.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByVehicleId(Long vehicleId);
}


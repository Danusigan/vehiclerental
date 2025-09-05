package vehicle1.example.vehiclerent.service;



import vehicle1.example.vehiclerent.model.Booking;
import vehicle1.example.vehiclerent.model.User;
import vehicle1.example.vehiclerent.model.Vehicle;
import vehicle1.example.vehiclerent.repository.BookingRepository;
import vehicle1.example.vehiclerent.repository.UserRepository;
import vehicle1.example.vehiclerent.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Bookingservice {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public String createBooking(String name, Long vehicleId, String pickupDate,String pickupTime, String dropDate, String dropTime) {
        Optional<User> userOpt = userRepository.findByName(name);
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(vehicleId);

        if (userOpt.isPresent() && vehicleOpt.isPresent()) {
            Booking booking = new Booking();
            booking.setUser(userOpt.get());
            booking.setVehicle(vehicleOpt.get());
            booking.setPickupDate(pickupDate);
            booking.setDropDate(dropDate);
            booking.setPickupTime(pickupTime);
            booking.setDropTime(dropTime);


            bookingRepository.save(booking);
            return "Booking created successfully!";
        } else {
            return "User or Vehicle not found!";
        }
    }

    public String updateBooking(Long bookingId, String pickupDate, String pickupTime, String dropDate, String dropTime) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setPickupDate(pickupDate);
            booking.setPickupTime(pickupTime);
            booking.setDropDate(dropDate);
            booking.setDropTime(dropTime);
            bookingRepository.save(booking);
            return "Booking updated successfully!";
        } else {
            return "Booking not found!";
        }
    }

    public String deleteBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            bookingRepository.delete(bookingOpt.get());
            return "Booking deleted successfully!";
        } else {
            return "Booking not found!";
        }
    }
}


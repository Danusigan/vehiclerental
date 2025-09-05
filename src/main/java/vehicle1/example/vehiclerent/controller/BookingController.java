package vehicle1.example.vehiclerent.controller;

import vehicle1.example.vehiclerent.service.Bookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private Bookingservice bookingService;

    @PostMapping("/create")
    public String createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(
                bookingRequest.getName(),
                bookingRequest.getVehicleId(),
                bookingRequest.getPickupDate(),
                bookingRequest.getPickupTime(),
                bookingRequest.getDropDate(),
                bookingRequest.getDropTime()

        );
    }

    @PutMapping("/update/{bookingId}")
    public String updateBooking(@PathVariable Long bookingId, @RequestBody BookingRequest bookingRequest) {
        return bookingService.updateBooking(
                bookingId,
                bookingRequest.getPickupDate(),
                bookingRequest.getPickupTime(),
                bookingRequest.getDropDate(),
                bookingRequest.getDropTime()
        );
    }

    @DeleteMapping("/delete/{bookingId}")
    public String deleteBooking(@PathVariable Long bookingId) {
        return bookingService.deleteBooking(bookingId);
    }
}

class BookingRequest {
    private String name;
    private Long vehicleId;
    private String pickupDate;
    private String pickupTime;
    private String dropDate;
    private String dropTime;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDropDate() {
        return dropDate;
    }

    public String getDropTime() {
        return dropTime;
    }

    public void setDropDate(String dropDate) {
        this.dropDate = dropDate;
    }

    public void setDropTime(String dropTime) {
        this.dropTime = dropTime;
    }

// Getters and Setters
}
